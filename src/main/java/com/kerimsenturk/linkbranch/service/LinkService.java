package com.kerimsenturk.linkbranch.service;

import com.kerimsenturk.linkbranch.dto.LinkDto;
import com.kerimsenturk.linkbranch.dto.converter.LinkAndLinkDtoConverter;
import com.kerimsenturk.linkbranch.dto.request.CreateLinkRequest;
import com.kerimsenturk.linkbranch.model.Link;
import com.kerimsenturk.linkbranch.repository.LinkRepository;
import com.kerimsenturk.linkbranch.util.IconManager.IconManager;
import com.kerimsenturk.linkbranch.util.IconManager.IconSize;
import com.kerimsenturk.linkbranch.util.Result.HttpDataResult;
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
                createLinkRequest.url(),
                solvedIcon,
                createLinkRequest.linkCategory(),
                null);

        LinkDto addLinkDto = linkAndLinkDtoConverter.convert(linkRepository.save(link));

        return new HttpDataResult<LinkDto>(addLinkDto, true, HttpStatus.CREATED);
    }

    @Override
    public HttpDataResult<List<LinkDto>> findAllByUser_Username(String username) {
        return null;
    }

    @Override
    public HttpDataResult<List<LinkDto>> findAllByUser_Uuid(int uuid) {
        return null;
    }

    @Override
    public HttpDataResult<LinkDto> removeLinkById(int id) {
        return null;
    }
}
