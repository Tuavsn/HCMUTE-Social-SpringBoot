package Tuan.HCMUTESocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Tuan.HCMUTESocial.entities.user;

public interface UserRepository extends JpaRepository<user, Integer>{
	Optional<user> findByUserName(String username);
}
