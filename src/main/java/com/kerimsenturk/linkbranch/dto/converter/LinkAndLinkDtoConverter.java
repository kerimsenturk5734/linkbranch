package com.kerimsenturk.linkbranch.dto.converter;

import com.kerimsenturk.linkbranch.model.Link;
import com.kerimsenturk.linkbranch.dto.LinkDto;
import com.kerimsenturk.linkbranch.util.ObjectConverter.Convertable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LinkAndLinkDtoConverter implements Convertable<Link, LinkDto> {

    private final UserAndUserDtoConverter userAndUserDtoConverter;

    public LinkAndLinkDtoConverter(@Lazy UserAndUserDtoConverter userAndUserDtoConverter) {
        this.userAndUserDtoConverter = userAndUserDtoConverter;
    }

    @Override
    public LinkDto convert(Link link) {
        if(link == null)
            return new LinkDto();

        return new LinkDto(
                link.getId(),
                link.getUrl(),
                link.getIcon(),
                link.getCategory(),
                null);
    }

    @Override
    public Link deConvert(LinkDto linkDto) {
        if(linkDto == null)
            return new Link();

        return new Link(
                linkDto.getId(),
                linkDto.getUrl(),
                linkDto.getIcon(),
                linkDto.getCategory(),
                userAndUserDtoConverter.deConvert(linkDto.getUser()));
    }
}
