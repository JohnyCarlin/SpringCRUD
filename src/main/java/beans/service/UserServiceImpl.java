package beans.service;

import beans.entity.User;
import beans.exception.SomethingWrongException;
import beans.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void addNewUser(User user) throws SomethingWrongException {
        if (Objects.isNull(user)) {
            throw new SomethingWrongException("Provided user is null");
        }
        userRepository.addNewUser(user);
    }

    @Transactional
    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Transactional
    public User getUserByID(Integer id) {
        return userRepository.getUserByID(id);
    }

    @Transactional
    public boolean removeUser(Integer id) {
        return userRepository.removeUser(id);
    }

    @Transactional
    public boolean editExistingUser(User user) throws SomethingWrongException {
        if (Objects.isNull(user)) {
            throw new SomethingWrongException("Provided user is null");
        }
        return userRepository.editExistingUser(user);
    }


}
