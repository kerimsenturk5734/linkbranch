package com.kerimsenturk.linkbranch.dto.converter;

import com.kerimsenturk.linkbranch.model.User;
import com.kerimsenturk.linkbranch.dto.UserDto;
import com.kerimsenturk.linkbranch.util.ObjectConverter.Convertable;

import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class UserAndUserDtoConverter implements Convertable<User, UserDto> {
    private final LinkAndLinkDtoConverter linkAndLinkDtoConverter;
    private final ProfileAndProfileDtoConverter profileAndProfileDtoConverter;

    public UserAndUserDtoConverter(LinkAndLinkDtoConverter linkAndLinkDtoConverter, ProfileAndProfileDtoConverter profileAndProfileDtoConverter) {
        this.linkAndLinkDtoConverter = linkAndLinkDtoConverter;
        this.profileAndProfileDtoConverter = profileAndProfileDtoConverter;
    }


    @Override
    public UserDto convert(User user) {
        if(user == null)
            return new UserDto();

        return new UserDto(
                user.getUuid(),
                user.getName(),
                user.getLastname(),
                user.getUsername(),
                user.getMail(),
                user.getUserType(),
                user.getLinks()
                        .stream()
                        .map(linkAndLinkDtoConverter :: convert)
                        .collect(Collectors.toList()),
                profileAndProfileDtoConverter.convert(user.getProfile()));
    }

    @Override
    public User deConvert(UserDto userDto) {
        if(userDto == null)
            return new User();

        return new User(
                userDto.getUuid(),
                userDto.getName(),
                userDto.getLastname(),
                userDto.getUsername(),
                null,
                userDto.getMail(),
                userDto.getUserType());
    }
}
