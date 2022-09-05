package com.project.jobis.security;

import com.project.jobis.user.domain.User;
import com.project.jobis.user.domain.UserRole;
import com.project.jobis.user.enums.UserRoleType;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class UserPrincipal implements OAuth2User, UserDetails {
    private User user;
    private Long id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    public UserPrincipal(User user, Long id, String userId, String password, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.id = id;
        this.email = userId;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        Set<UserRole> userRoleList = user.getUserRoles();
        Set<GrantedAuthority> authorities = userRoleList.isEmpty() ? Collections.
            singleton(new SimpleGrantedAuthority("ROLE_USER")): getRoles(userRoleList);

        return new UserPrincipal(
                user,
                user.getId(),
                user.getUserNo(),
                user.getPassword(),
                authorities
        );
    }

    private static Set<GrantedAuthority> getRoles(Set<UserRole> userRoles) {
        return userRoles.stream()
            .map(UserRole::getType)
            .map(UserRoleType::getLabel)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toSet());
    }

    public static UserPrincipal create(User user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = UserPrincipal.create(user);
        userPrincipal.setAttributes(attributes);
        return userPrincipal;
    }

    public  User getUser() { return user; }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }
}
