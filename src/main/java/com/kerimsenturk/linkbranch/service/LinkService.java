package com.kerimsenturk.linkbranch.service;

import com.kerimsenturk.linkbranch.dto.LinkDto;
import com.kerimsenturk.linkbranch.dto.UserDto;
import com.kerimsenturk.linkbranch.dto.converter.LinkAndLinkDtoConverter;
import com.kerimsenturk.linkbranch.dto.converter.UserAndUserDtoConverter;
import com.kerimsenturk.linkbranch.dto.request.CreateLinkRequest;
import com.kerimsenturk.linkbranch.dto.request.RemoveLinkRequest;
import com.kerimsenturk.linkbranch.dto.request.UpdateLinkRequest;
import com.kerimsenturk.linkbranch.model.Link;
import com.kerimsenturk.linkbranch.repository.LinkRepository;
import com.kerimsenturk.linkbranch.util.IconManager.IconManager;
import com.kerimsenturk.linkbranch.util.IconManager.IconSize;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;
import com.kerimsenturk.linkbranch.util.Result.HttpResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LinkService implements ILinkService{
    private final LinkRepository linkRepository;
    private final LinkAndLinkDtoConverter linkAndLinkDtoConverter;
    private final IconManager iconManager;
    private final UserService userService;
    private final UserAndUserDtoConverter userAndUserDtoConverter;
    public LinkService(LinkRepository linkRepository, LinkAndLinkDtoConverter linkAndLinkDtoConverter, IconManager iconManager, UserService userService, UserAndUserDtoConverter userAndUserDtoConverter) {
        this.linkRepository = linkRepository;
        this.linkAndLinkDtoConverter = linkAndLinkDtoConverter;
        this.iconManager = iconManager;
        this.userService = userService;
        this.userAndUserDtoConverter = userAndUserDtoConverter;
    }

    @Override
    public HttpDataResult<LinkDto> addLink(CreateLinkRequest createLinkRequest) {
        //Solve the icon by site url
        byte[] solvedIcon;

        try{
            solvedIcon = iconManager.solveBySiteURL(createLinkRequest.url(), IconSize._16);
        }
        catch (IOException e){
            //Assign default icon to solvedIcon.
            solvedIcon = new byte[1024];
        }

        HttpDataResult<UserDto> httpDataResult = userService.getUserByUuid(createLinkRequest.uuid());

        if(httpDataResult.isSuccess()){

            //Create new Link object
            Link link = new Link(0,
                    createLinkRequest.name(),
                    createLinkRequest.url(),
                    solvedIcon,
                    createLinkRequest.linkCategory(),
                    userAndUserDtoConverter.deConvert(httpDataResult.getData()));

            LinkDto addLinkDto = linkAndLinkDtoConverter.convert(linkRepository.save(link));

            return new HttpDataResult<LinkDto>(addLinkDto, true, HttpStatus.CREATED);
        }


        return new HttpDataResult<LinkDto>(
                null,
                false,
                httpDataResult.getMessage(),
                httpDataResult.getStatus());

    }

    @Override
    public HttpDataResult<List<LinkDto>> findAllByUser_Username(String username) {
        //Get links
        List<Link> links = linkRepository.findAllByUser_Username(username);

        //Handle if not found
        if(links.isEmpty())
           return HttpDataResult.notFoundResult(String.format("Links not found by username = %s", username));

        //Convert to dto
        List<LinkDto> linkDtos = links
                .stream()
                .map(linkAndLinkDtoConverter::convert)
                .toList();

        return new HttpDataResult<List<LinkDto>>(linkDtos, true, HttpStatus.OK);
    }

    @Override
    public HttpDataResult<List<LinkDto>> findAllByUser_Uuid(int uuid) {
        //Get links
        List<Link> links = linkRepository.findAllByUser_Uuid(uuid);

        //Handle if not found
        if(links.isEmpty())
            return HttpDataResult.notFoundResult(String.format("Links not found by uuid = %s", uuid));

        //Convert to dto
        List<LinkDto> linkDtos = links
                .stream()
                .map(linkAndLinkDtoConverter::convert)
                .toList();

        return new HttpDataResult<List<LinkDto>>(linkDtos, true, HttpStatus.OK);
    }

    @Override
    public HttpResult removeLink(RemoveLinkRequest removeLinkRequest) {
        Optional<Link> linkOptional = linkRepository.findById(removeLinkRequest.linkId());

        if(linkOptional.isPresent()){
            Link link = linkOptional.get();

            if(link.getUser().getUuid() == removeLinkRequest.uuid()){

                linkRepository.deleteById(removeLinkRequest.linkId());

                return new HttpResult(
                        true,
                        String.format("The link successfully removed by linkId: %d", link.getId()),
                        HttpStatus.ACCEPTED);

            }

            return new HttpResult(
                    false,
                    "Access Denied!!!",
                    HttpStatus.FORBIDDEN);
        }

        return HttpResult.notFoundResult(String.format("Indicated link not found by linkId: %d", removeLinkRequest.linkId()));
    }

    @Override
    public HttpDataResult<LinkDto> updateLink(UpdateLinkRequest updateLinkRequest) {
        //Get related link
        Optional<Link> link = linkRepository.findById(updateLinkRequest.linkId());

        //Check is it exist
        if(link.isPresent()){

            //Compare the request uuid and uuid of related link
            if(link.get().getUser().getUuid() == updateLinkRequest.uuid()){
                Link linkToUpdate = link.get();

                //Update the fields
                linkToUpdate.setName(updateLinkRequest.name());
                linkToUpdate.setUrl(updateLinkRequest.url());
                linkToUpdate.setCategory(updateLinkRequest.linkCategory());

                //Solve new icon if url changed.
                if(link.get().getUrl().equals(linkToUpdate.getUrl())){

                    try{
                        byte[] newIcon = iconManager.solveBySiteURL(linkToUpdate.getUrl(), IconSize._16);
                        linkToUpdate.setIcon(newIcon);
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }

                }

                //Update it and get updated link to response back.
                Link updatedLink = linkRepository.save(linkToUpdate);
                LinkDto updatedLinkDto = linkAndLinkDtoConverter.convert(updatedLink);

                return new HttpDataResult<>(
                        updatedLinkDto,
                        true,
                        String.format("Link updated by linkId: %d", updateLinkRequest.linkId()),
                        HttpStatus.OK
                );
            }

            return new HttpDataResult<>(
                    null,
                    false,
                    "Access Denied",
                    HttpStatus.FORBIDDEN);
        }

        return HttpDataResult.notFoundResult(
                String.format("Not Found link by linkId: %d", updateLinkRequest.linkId()));
    }

}
