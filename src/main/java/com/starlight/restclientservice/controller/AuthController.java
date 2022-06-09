package com.starlight.restclientservice.controller;

import com.starlight.restclientservice.dto.AuthUserDto;
import com.starlight.restclientservice.security.JwtTokenProvider;
import com.starlight.restclientservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthUserDto authUserDto) {
        try {

            String userEmail = authUserDto.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEmail, authUserDto.getPassword()));
            String token = jwtTokenProvider.createToken(userEmail);
            log.info("Token successfully created");
            Map<Object, Object> credentialsResponse = new HashMap<>();
            credentialsResponse.put("email", userEmail);
            credentialsResponse.put("token", token);

            return ResponseEntity.ok(credentialsResponse);

        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid data", HttpStatus.NOT_FOUND);
        }

    }

}
