package com.pmn.gmt.domain.user.presentation.controller;

import com.pmn.gmt.domain.user.presentation.data.responseDto.UserInfoResponseDto;
import com.pmn.gmt.domain.user.service.FindUserInfoService;
import com.pmn.gmt.domain.user.util.UserConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin(origins = {"https://gmt-pmn.shop", "https://gmt-pmn.store"})
public class UserController {

    private FindUserInfoService findUserInfoService;
    private UserConverter userConverter;

    @GetMapping("/info")
    public ResponseEntity<UserInfoResponseDto> findUserInfo(){
        return ResponseEntity.ok(userConverter.toResponseDto(findUserInfoService.execute()));
    }
}
