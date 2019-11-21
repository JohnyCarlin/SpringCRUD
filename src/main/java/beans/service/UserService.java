package beans.service;

import beans.entity.User;
import beans.exception.SomethingWrongException;

import java.util.Collection;

public interface UserService {

    void addNewUser(User user) throws SomethingWrongException;
    Collection<User> getAllUsers() throws SomethingWrongException;
    User getUserByID(Long id) throws SomethingWrongException;
    boolean removeUser(Long id) throws SomethingWrongException;
    boolean editExistingUser(User user) throws SomethingWrongException;
}
