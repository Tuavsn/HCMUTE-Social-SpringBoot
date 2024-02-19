package Tuan.HCMUTESocial.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Tuan.HCMUTESocial.entities.token;

public interface TokenRepository extends JpaRepository<token, Integer>{
	@Query(value="""
			select t from token t inner join user u\s
			on t.userId.userId = u.userId\s
			where u.userId = :id and (t.expired = false or t.revoked = false)\s
			""")
	List<token> findAllValidTokenByUser(Integer id);
	Optional<token> findByToken(String token);
}
