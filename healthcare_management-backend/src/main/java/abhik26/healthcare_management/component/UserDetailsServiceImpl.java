package abhik26.healthcare_management.component;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import abhik26.healthcare_management.entity.User;
import abhik26.healthcare_management.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDetails userDetails = null;

        final List<User> users = userRepository.findByEmail(username);

        if (users == null || users.isEmpty() || users.get(0) == null) {
            throw new UsernameNotFoundException(username);
        } else {
            final User user = users.get(0);
            userDetails = new UserDetailsImpl(user.getEmail(), passwordEncoder.encode(user.getPassword()),
                    user.getAuthorities());
        }

        return userDetails;
    }
}
