package com.awakelife93.apigateway.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awakelife93.apigateway.common.error.exceptions.APIResponseException;
import com.awakelife93.apigateway.service.auth.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("signIn")
  public Map<String, Object> signIn(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body) throws APIResponseException {
    return authService.signIn(request, body);
  }

  @PostMapping("signOut")
  public Map<String, Object> signOut(HttpServletRequest request, HttpServletResponse response,
      @RequestBody Map<String, Object> body)
      throws APIResponseException {
    return authService.signOut(request, body);
  }
}
