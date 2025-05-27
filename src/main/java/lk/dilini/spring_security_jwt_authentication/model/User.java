package lk.dilini.spring_security_jwt_authentication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Authority> authorities;
}