package lk.dilini.spring_security_jwt_authentication;

import lk.dilini.spring_security_jwt_authentication.model.Authority;
import lk.dilini.spring_security_jwt_authentication.model.User;
import lk.dilini.spring_security_jwt_authentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            adminUser.setEnabled(true);

            Authority adminAuthority = new Authority();
            adminAuthority.setAuthority("ROLE_ADMIN");
            adminAuthority.setUser(adminUser);

            adminUser.setAuthorities(Collections.singletonList(adminAuthority));
            userRepository.save(adminUser);
        }

        if (userRepository.findByUsername("user").isEmpty()) {
            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user123"));
            user.setEnabled(true);

            Authority userAuthority = new Authority();
            userAuthority.setAuthority("ROLE_USER");
            userAuthority.setUser(user);

            user.setAuthorities(Collections.singletonList(userAuthority));
            userRepository.save(user);
        }
    }
}
