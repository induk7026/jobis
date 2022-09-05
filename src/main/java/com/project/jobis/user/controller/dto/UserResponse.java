package com.project.jobis.user.controller.dto;

import com.project.jobis.user.domain.User;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String userId;
    private int loginCount;
    private LocalDateTime lastLoginAt;
    private LocalDateTime createAt;

    public static UserResponse toEntity(User user) {

        return UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .userId(user.getUserNo())
            .loginCount(user.getLoginCount())
            .lastLoginAt(user.getLastLoginAt())
            .createAt(user.getCreateAt())
            .build();
    }
}
