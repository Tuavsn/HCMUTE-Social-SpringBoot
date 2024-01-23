package Tuan.HCMUTESocial.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import Tuan.HCMUTESocial.entities.user;

public interface UserRepository extends CrudRepository<user, Integer>{
	Optional<user> findByUsernameOrEmail(String username, String email);
}
