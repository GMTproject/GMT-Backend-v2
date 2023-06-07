package com.pmn.gmt.domain.auth.presentation.controller;

import com.pmn.gmt.domain.auth.presentation.data.reqeuestDto.LoginRequestDto;
import com.pmn.gmt.domain.auth.service.LoginService;
import com.pmn.gmt.domain.auth.util.AuthConverter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    LoginService loginService;
    AuthConverter authConvertor;

    @GetMapping("/login")
    public String login(@RequestParam(value = "code") String code) {
        System.out.println("실행");
        loginService.execute(authConvertor.toDto(code));
        return "redirect:/success";
    }

}
