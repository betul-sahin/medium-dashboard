package com.betulsahin.mediumdashboard.controllers;

import com.betulsahin.mediumdashboard.dto.LoginDTO;
import com.betulsahin.mediumdashboard.services.LoginService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private LoginService loginService;

    public LoginController(BCryptPasswordEncoder bCryptPasswordEncoder, LoginService loginService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.loginService = loginService;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody LoginDTO loginDTO) {
        loginDTO.setPassword(bCryptPasswordEncoder.encode(loginDTO.getPassword()));
        loginService.save(loginDTO);
    }
}
