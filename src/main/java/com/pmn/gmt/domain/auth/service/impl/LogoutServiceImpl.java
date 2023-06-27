package com.pmn.gmt.domain.auth.service.impl;

import com.pmn.gmt.domain.auth.domain.entity.RefreshToken;
import com.pmn.gmt.domain.auth.domain.repository.RefreshTokenRepository;
import com.pmn.gmt.domain.auth.service.LogoutService;
import com.pmn.gmt.domain.user.domain.entity.User;
import com.pmn.gmt.domain.user.exception.UserNotFoundException;
import com.pmn.gmt.domain.user.util.UserUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogoutServiceImpl implements LogoutService {

    UserUtil userUtil;
    RefreshTokenRepository refreshTokenRepository;

    @Override
    public void execute() {
        User userInfo = userUtil.fetchCurrentUser();
        RefreshToken refreshToken = refreshTokenRepository.findByUserId(userInfo.getId());
        if (refreshToken == null)
            throw new UserNotFoundException();
        refreshTokenRepository.delete(refreshToken);
    }
}
