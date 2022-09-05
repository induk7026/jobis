package com.project.jobis.user.domain;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "regNo")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String userNo;

    private String regNo;

    @JsonIgnore
    private String password;

    private int loginCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<UserRole> userRoles;

    private LocalDateTime lastLoginAt;

    private LocalDateTime createAt;

    public User(String name, String email, String password) {
        this(null, name, email, email, password, 0, null, null, null);
    }

    @Builder
    public User(Long id, String name, String userId, String email, String password, int loginCount, String regNo, LocalDateTime lastLoginAt, LocalDateTime createAt) {
        checkArgument(isNotEmpty(name), "name must be provided.");
        checkArgument(
            name.length() >= 1 && name.length() <= 10,
            "name length must be between 1 and 10 characters."
        );
        checkNotNull(userId, "userId must be provided.");
        checkNotNull(password, "password must be provided.");

        this.id = id;
        this.name = name;
        this.userNo = userId;
        this.regNo = regNo;
        this.password = password;
        this.loginCount = loginCount;
        this.lastLoginAt = lastLoginAt;
        this.createAt = defaultIfNull(createAt, now());
    }

    public void updateLastLoginAt(){
        this.lastLoginAt = LocalDateTime.now();
        this.loginCount++;
    }

}
