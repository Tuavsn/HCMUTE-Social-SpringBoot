package Tuan.HCMUTESocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import Tuan.HCMUTESocial.DTO.AuthenticationResponse;
import Tuan.HCMUTESocial.DTO.UserLoginDto;
import Tuan.HCMUTESocial.DTO.UserRegistDto;
import Tuan.HCMUTESocial.entities.user;
import Tuan.HCMUTESocial.entities.token;
import Tuan.HCMUTESocial.repository.TokenRepository;
import Tuan.HCMUTESocial.repository.UserRepository;
import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
	
@Service
public class AuthenticationService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TokenRepository tokenRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(UserRegistDto request) {
		var User = user.builder()
				.fullName(request.getFullName())
				.userName(request.getUserName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.gender(request.getGender())
				.role(request.getRole())
				.build();
		var savedUser = userRepository.save(User);
		var jwtToken = jwtService.generateToken(User);
		var refreshToken = jwtService.generateRefreshToken(User);
		saveUserToken(savedUser, jwtToken);
		return AuthenticationResponse.builder()
				.accessToken(jwtToken)
				.refresh_token(refreshToken)
				.build();
	}
	
	public AuthenticationResponse login(UserLoginDto request) {
		authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
					request.getUsername(), 
					request.getPassword()
			)
		);
		var User = userRepository.findByUserName(request.getUsername()).orElseThrow();
		var jwtToken = jwtService.generateToken(User);
		var refreshToken = jwtService.generateRefreshToken(User);
		revokeAllUserTokens(User);
		saveUserToken(User, jwtToken);
		return AuthenticationResponse.builder()
				.accessToken(jwtToken)
				.refresh_token(refreshToken)
				.build();
	}
	
	public void refreshToken(
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		final String refreshToken;
		final String userName;
		if(authHeader == null || !authHeader.startsWith("Bearer")) return;
		refreshToken = authHeader.substring(7);
		userName = jwtService.extractUsername(refreshToken);
		if(userName != null) {
			var User = userRepository.findByUserName(userName).orElseThrow();
			if(jwtService.isTokenValid(refreshToken, User)) {
				var accessToken = jwtService.generateToken(User);
				revokeAllUserTokens(User);
				saveUserToken(User, refreshToken);
				var authResponse = AuthenticationResponse.builder()
						.accessToken(accessToken)
						.refresh_token(refreshToken)
						.build();
				new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
			}
		}
	}
	
	public void saveUserToken(user User, String jwtToken) {
		var Token = token.builder()
				.userId(User)
				.token(jwtToken)
				.expired(false)
				.revoked(false)
				.build();
		tokenRepository.save(Token);
	}
	
	public void revokeAllUserTokens(user User) {
		var validUserTokens = tokenRepository.findAllValidTokenByUser(User.getUserId());
		if(validUserTokens.isEmpty()) return;
		validUserTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		tokenRepository.saveAll(validUserTokens);
	}
	
}
