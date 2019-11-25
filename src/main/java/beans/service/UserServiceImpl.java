package beans.service;

import beans.entity.User;
import beans.exception.SomethingWrongException;
import beans.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void addNewUser(User user) throws SomethingWrongException {
        if (Objects.isNull(user)) {
            throw new SomethingWrongException("Provided user is null");
        }
        userRepository.addNewUser(user);
    }

    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserByID(Long id) {
        return userRepository.getUserByID(id);
    }

    public boolean removeUser(Long id) {
        return userRepository.removeUser(id);
    }

    public boolean editExistingUser(User user) throws SomethingWrongException {
        if (Objects.isNull(user)) {
            throw new SomethingWrongException("Provided user is null");
        }
        return userRepository.editExistingUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByName(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole()));
//        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
