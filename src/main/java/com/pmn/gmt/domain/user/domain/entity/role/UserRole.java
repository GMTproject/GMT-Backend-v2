package com.pmn.gmt.domain.user.domain.entity.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum UserRole implements GrantedAuthority {
    TEACHER("선생님"), STUDENT("학생");

    private final String description;

    @Override
    public String getAuthority() {
        return name();
    }
}
