package com.pmn.gmt.domain.user.service.impl;

import com.pmn.gmt.domain.user.presentation.data.dto.UserInfoDto;
import com.pmn.gmt.domain.user.service.FindUserInfoService;
import com.pmn.gmt.domain.user.util.UserConverter;
import com.pmn.gmt.domain.user.util.UserUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindUserInfoServiceImpl implements FindUserInfoService {

    private UserUtil userUtil;
    private UserConverter userConverter;

    @Override
    public UserInfoDto execute() {
        return userConverter.toDto(userUtil.fetchCurrentUser());
    }
}
