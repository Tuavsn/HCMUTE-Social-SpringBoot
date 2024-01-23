package Tuan.HCMUTESocial.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Tuan.HCMUTESocial.entities.user;
import Tuan.HCMUTESocial.repository.UserRepository;

public class CustomUserDetailService implements UserDetailsService {
	
	private UserRepository userRepository;
	
	public CustomUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		user user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username or email" + usernameOrEmail));
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword());
	}
	
}
