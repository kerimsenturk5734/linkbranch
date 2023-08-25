package com.kerimsenturk.linkbranch.dto.converter;

import com.kerimsenturk.linkbranch.dto.ProfileDto;
import com.kerimsenturk.linkbranch.model.Profile;
import com.kerimsenturk.linkbranch.util.ObjectConverter.Convertable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ProfileAndProfileDtoConverter implements Convertable<Profile, ProfileDto> {
    private final UserAndUserDtoConverter userAndUserDtoConverter;

    public ProfileAndProfileDtoConverter(@Lazy UserAndUserDtoConverter userAndUserDtoConverter) {
        this.userAndUserDtoConverter = userAndUserDtoConverter;
    }

    @Override
    public ProfileDto convert(Profile profile) {
        if (profile == null)
            return new ProfileDto();

        return new ProfileDto(
                profile.getId(),
                profile.getDescription(),
                profile.getProfileImage(),
                profile.getTheme(),
                null);
    }

    @Override
    public Profile deConvert(ProfileDto profileDto) {
        if(profileDto == null)
            return new Profile();

        return new Profile(
                profileDto.getId(),
                profileDto.getDescription(),
                profileDto.getProfileImage(),
                profileDto.getTheme(),
                userAndUserDtoConverter.deConvert(profileDto.getUser()));
    }
}
