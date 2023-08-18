package com.kerimsenturk.linkbranch.model.dto.converter;

import com.kerimsenturk.linkbranch.model.Profile;
import com.kerimsenturk.linkbranch.model.dto.ProfileDto;
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
        return new ProfileDto(
                profile.getId(),
                profile.getDescription(),
                profile.getProfileImage(),
                profile.getTheme(),
                userAndUserDtoConverter.convert(profile.getUser()));
    }

    @Override
    public Profile deConvert(ProfileDto profileDto) {
        return null;
    }
}
