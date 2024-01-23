package Tuan.HCMUTESocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tuan.HCMUTESocial.entities.user;
import Tuan.HCMUTESocial.repository.UserRepository;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/findAll")
	public ResponseEntity<Iterable<user>> getAllUser() {
		Iterable<user> users = userRepository.findAll();
		return ResponseEntity.ok(users);
	}
}
