package org.kataew.newsapi.controllers;

import lombok.RequiredArgsConstructor;
import org.kataew.newsapi.dtos.JwtAuthenticationResponse;
import org.kataew.newsapi.dtos.SignInRequest;
import org.kataew.newsapi.dtos.SignUpRequest;
import org.kataew.newsapi.services.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
