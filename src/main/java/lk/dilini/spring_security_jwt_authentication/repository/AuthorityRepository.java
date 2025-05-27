package lk.dilini.spring_security_jwt_authentication.repository;

import lk.dilini.spring_security_jwt_authentication.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
