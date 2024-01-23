package Tuan.HCMUTESocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tuan.HCMUTESocial.DTO.UserLoginDto;
import Tuan.HCMUTESocial.DTO.UserRegistDto;
import Tuan.HCMUTESocial.entities.user;
import Tuan.HCMUTESocial.repository.UserRepository;

//@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	User signin
	@PostMapping("/signin")
	public ResponseEntity<String> authenticateUser(@RequestBody UserLoginDto loginDto) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsername()
				, loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
	}
	
//	@PostMapping("/regist")
//	public ResponseEntity<?> registUser(@RequestBody UserRegistDto registDto) {
//		
//	}
	
//	@GetMapping("/regist")
//	public ResponseEntity<Object> register(@RequestBody User)
}
