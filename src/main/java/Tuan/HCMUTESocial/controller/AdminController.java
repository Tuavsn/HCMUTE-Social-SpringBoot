package Tuan.HCMUTESocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tuan.HCMUTESocial.entities.user;
import Tuan.HCMUTESocial.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/get_total_users")
	public ResponseEntity<Iterable<user>> getAllUser() {
		Iterable<user> users = userRepository.findAll();
		return ResponseEntity.ok(users);
	}
//	
//	@GetMapping("/get_total_posts")
//	public ReponseEnity
//	
//	@GetMapping("/get_total_comments")
//	
//	@GetMapping("/get_total_likes")
//	
//	@GetMapping("/get_total_spam_posts")
//	
//	@GetMapping("/get_spam_posts")
//	
//	@GetMapping("/delete_spam_posts/{id}")
//	public ResponseEntity<String> 
}
