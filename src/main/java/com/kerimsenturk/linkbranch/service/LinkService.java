package com.kerimsenturk.linkbranch.service;

import com.kerimsenturk.linkbranch.dto.LinkDto;
import com.kerimsenturk.linkbranch.dto.converter.LinkAndLinkDtoConverter;
import com.kerimsenturk.linkbranch.dto.request.CreateLinkRequest;
import com.kerimsenturk.linkbranch.model.Link;
import com.kerimsenturk.linkbranch.repository.LinkRepository;
import com.kerimsenturk.linkbranch.util.IconManager.IconManager;
import com.kerimsenturk.linkbranch.util.IconManager.IconSize;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;
import com.kerimsenturk.linkbranch.util.Result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LinkService implements ILinkService{
    private final LinkRepository linkRepository;
    private final LinkAndLinkDtoConverter linkAndLinkDtoConverter;
    private final IconManager iconManager;

    public LinkService(LinkRepository linkRepository, LinkAndLinkDtoConverter linkAndLinkDtoConverter, IconManager iconManager) {
        this.linkRepository = linkRepository;
        this.linkAndLinkDtoConverter = linkAndLinkDtoConverter;
        this.iconManager = iconManager;
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

        //Create new Link object
        Link link = new Link(0,
                createLinkRequest.name(),
                createLinkRequest.url(),
                solvedIcon,
                createLinkRequest.linkCategory(),
                null); // Get the current user on site and set here.

        LinkDto addLinkDto = linkAndLinkDtoConverter.convert(linkRepository.save(link));

        return new HttpDataResult<LinkDto>(addLinkDto, true, HttpStatus.CREATED);
    }

    @Override
    @SuppressWarnings("unchecked")
    public HttpDataResult<List<LinkDto>> findAllByUser_Username(String username) {
        //Get links
        List<Link> links = linkRepository.findAllByUser_Username(username);

        //Handle if not found
        if(links.isEmpty())
           return (HttpDataResult<List<LinkDto>>) notFoundResult(String.format("Links not found by username = %s", username));

        //Convert to dto
        List<LinkDto> linkDtos = links
                .stream()
                .map(linkAndLinkDtoConverter::convert)
                .toList();

        return new HttpDataResult<List<LinkDto>>(linkDtos, true, HttpStatus.OK);
    }

    @Override
    @SuppressWarnings("unchecked")
    public HttpDataResult<List<LinkDto>> findAllByUser_Uuid(int uuid) {
        //Get links
        List<Link> links = linkRepository.findAllByUser_Uuid(uuid);

        //Handle if not found
        if(links.isEmpty())
            return (HttpDataResult<List<LinkDto>>) notFoundResult(String.format("Links not found by uuid = %s", uuid));

        //Convert to dto
        List<LinkDto> linkDtos = links
                .stream()
                .map(linkAndLinkDtoConverter::convert)
                .toList();

        return new HttpDataResult<List<LinkDto>>(linkDtos, true, HttpStatus.OK);
    }

    @Override
    public HttpDataResult<LinkDto> removeLinkById(int id) {
        return null;
    }

    private Result notFoundResult(String message){
        return new HttpDataResult<>(
                null,
                false,
                message,
                HttpStatus.NOT_FOUND);
    }
}
