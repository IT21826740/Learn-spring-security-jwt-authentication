package lk.dilini.spring_security_jwt_authentication.security;


import org.springframework.transaction.annotation.Transactional;
import lk.dilini.spring_security_jwt_authentication.model.User;
import lk.dilini.spring_security_jwt_authentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("authentication user with username [{}]", username);

        User user = (User) userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("No user found with username  [" + username + "]")
        );
        System.out.println("user " + user.getAuthorities().size());

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities().stream()
                        .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                        .toList())
                .build();
    }
}
