package com.pmn.gmt.domain.user.util.impl;

import com.pmn.gmt.domain.user.domain.entity.User;
import com.pmn.gmt.domain.user.domain.entity.role.UserRole;
import com.pmn.gmt.domain.user.exception.UserNotFoundException;
import com.pmn.gmt.domain.user.domain.repository.UserRepository;
import com.pmn.gmt.domain.user.util.UserConverter;
import com.pmn.gmt.domain.user.util.UserUtil;
import com.pmn.gmt.global.security.auth.AuthDetails;
import gauth.GAuthUserInfo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserUtilImpl implements UserUtil {

    private UserRepository userRepository;
    private UserConverter userConverter;

    public User fetchCurrentUser() {
        String email = fetchUserEmail();
        return fetchUserByEmail(email);
    }

    private User fetchUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new UserNotFoundException();
        return user;
    }

    private String fetchUserEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email;
        if (principal instanceof UserDetails)
            email = ((AuthDetails) principal).getUsername();
        else
            email = principal.toString();
        return email;
    }

    public void saveUser(GAuthUserInfo GAuthUserInfo, UserRole role){
        userRepository.save(userConverter.toEntity(GAuthUserInfo,role));
    }
}
