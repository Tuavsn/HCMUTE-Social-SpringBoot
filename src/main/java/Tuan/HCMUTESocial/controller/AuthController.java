package Tuan.HCMUTESocial.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tuan.HCMUTESocial.DTO.AuthenticationResponse;
import Tuan.HCMUTESocial.DTO.UserLoginDto;
import Tuan.HCMUTESocial.DTO.UserRegistDto;
import Tuan.HCMUTESocial.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationService authenticationService;
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> Regist(@RequestBody UserRegistDto request) {
		return ResponseEntity.ok(authenticationService.register(request));	
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> Login(@RequestBody UserLoginDto request) {
		return ResponseEntity.ok(authenticationService.login(request));
	}
	
	@PostMapping("/refresh-token")
	public void RefreshToken(
			HttpServletRequest request,
			HttpServletResponse response
	) throws IOException {
		authenticationService.refreshToken(request, response);
	}
	
}
