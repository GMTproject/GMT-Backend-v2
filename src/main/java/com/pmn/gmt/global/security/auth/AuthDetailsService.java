package com.pmn.gmt.global.security.auth;

import com.pmn.gmt.domain.user.domain.entity.User;
import com.pmn.gmt.domain.user.exception.UserNotFoundException;
import com.pmn.gmt.domain.user.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AuthDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AuthDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return new AuthDetails(user);
    }
}