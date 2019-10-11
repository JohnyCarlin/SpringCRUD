package beans.repository;

import beans.entity.User;

import java.util.Collection;

public interface UserRepository {

    void addNewUser(User user);
    Collection<User> getAllUsers();
    User getUserByID(Integer id);
    boolean removeUser(Integer id);
    boolean editExistingUser(User user);
}
