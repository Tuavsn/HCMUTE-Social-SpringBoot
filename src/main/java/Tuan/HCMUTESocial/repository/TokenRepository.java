package Tuan.HCMUTESocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Tuan.HCMUTESocial.entities.token;

public interface TokenRepository extends JpaRepository<token, Integer>{
	
	Optional<token> findByToken(String token);
}
