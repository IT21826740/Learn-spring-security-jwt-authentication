package lk.dilini.spring_security_jwt_authentication.repository;

import lk.dilini.spring_security_jwt_authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Object> findByUsername(String username);
}
