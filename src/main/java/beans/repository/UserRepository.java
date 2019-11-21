package beans.repository;

import beans.entity.User;

import java.util.Collection;

public interface UserRepository {

    void addNewUser(User user);
    Collection<User> getAllUsers();
    User getUserByID(Long id);
    boolean removeUser(Long id);
    boolean editExistingUser(User user);
    public User getUserByName(String name);
}
