package com.project.jobis.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRoleType {

    ROLE_USER("ROLE_USER"),
    ROLE_DEV("ROLE_DEV"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String label;

}
