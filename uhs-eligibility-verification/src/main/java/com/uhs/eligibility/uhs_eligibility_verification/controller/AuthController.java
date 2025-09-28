package com.uhs.eligibility.uhs_eligibility_verification.controller;

import com.uhs.eligibility.uhs_eligibility_verification.config.JWTTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JWTTokenProvider tokenProvider;


    public AuthController(JWTTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestParam String userName) {
        String token = tokenProvider.generateToken(userName);
        return ResponseEntity.ok(Map.of("token", token));
    }

}
