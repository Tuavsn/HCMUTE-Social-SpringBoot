package Tuan.HCMUTESocial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	
	@GetMapping("/login")
	public ResponseEntity<String> Login() {
		return ResponseEntity.ok("well come to login page");	
	}
	
	
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
//	User signin
//	@PostMapping("/signin")
//	public ResponseEntity<String> authenticateUser(@RequestBody UserLoginDto loginDto) {
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginDto.getEmail()
//				, loginDto.getPassword()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
//	}
	
//	@PostMapping("/regist")
//	public ResponseEntity<?> registUser(@RequestBody UserRegistDto registDto) {
//		
//	}
	
//	@GetMapping("/regist")
//	public ResponseEntity<Object> register(@RequestBody User)
}
