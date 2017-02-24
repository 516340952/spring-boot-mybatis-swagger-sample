package sample.mybatis.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.mybatis.domain.User;


/**
 * User的JPA Repository
 *
 * @author 小翼
 * @version 1.0.0
 */
public interface UserRepository extends JpaRepository<User,String>{
	
}