package com.ktxdevelopment.gatewayservice.auth.security.controller;

import com.ktxdevelopment.siratumustakim.auth.security.model.AuthenticationRequest;
import com.ktxdevelopment.siratumustakim.auth.security.model.AuthenticationResponse;
import com.ktxdevelopment.siratumustakim.auth.security.model.RegisterRequest;
import com.ktxdevelopment.siratumustakim.auth.security.service.AuthenticationService;
import com.ktxdevelopment.siratumustakim.util.response.CustomResponseModel;
import com.ktxdevelopment.siratumustakim.util.response.RestResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;
  @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CustomResponseModel<AuthenticationResponse>> register(@RequestBody RegisterRequest request) {
      return RestResponse.ok(service.register(request));
  }


  @PostMapping("/authenticate")
  public ResponseEntity<CustomResponseModel<AuthenticationResponse>> authenticate(@RequestBody AuthenticationRequest request) {
    return RestResponse.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public ResponseEntity<CustomResponseModel<AuthenticationResponse>> refreshToken(HttpServletRequest request, HttpServletResponse response) {
    return RestResponse.ok(service.refreshToken(request, response));
  }
}
