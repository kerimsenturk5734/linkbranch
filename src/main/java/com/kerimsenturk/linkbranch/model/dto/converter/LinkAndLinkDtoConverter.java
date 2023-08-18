package com.kerimsenturk.linkbranch.model.dto.converter;

import com.kerimsenturk.linkbranch.model.Link;
import com.kerimsenturk.linkbranch.model.dto.LinkDto;
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
        return new LinkDto(
                link.getId(),
                link.getUrl(),
                link.getIcon(),
                link.getCategory(),
                userAndUserDtoConverter.convert(link.getUser()));
    }

    @Override
    public Link deConvert(LinkDto linkDto) {
        return new Link(
                linkDto.getId(),
                linkDto.getUrl(),
                linkDto.getIcon(),
                linkDto.getCategory(),
                userAndUserDtoConverter.deConvert(linkDto.getUser()));
    }
}
