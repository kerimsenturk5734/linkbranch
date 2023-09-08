package com.kerimsenturk.linkbranch.model.builder;

import com.kerimsenturk.linkbranch.model.enums.ProfileTheme;

public enum ProfileConfig{
    DEFAULT_CONFIG(
            new ProfileBuilder()
                    .id(0)
                    .description("This is default description.")
                    .profileImage(null)
                    .theme(ProfileTheme.DEFAULT)
                    .user(null)),
    ADMIN_CONFIG(
            new ProfileBuilder()
            .id(0)
            .description("This is admin description.")
            .profileImage(null)
            .theme(ProfileTheme.DARK)
            .user(null));

    private final ProfileBuilder profileBuilder;

    ProfileConfig(ProfileBuilder profileBuilder) {
        this.profileBuilder = profileBuilder;
    }

    public ProfileBuilder getProfileBuilder() {
        return profileBuilder;
    }
}


