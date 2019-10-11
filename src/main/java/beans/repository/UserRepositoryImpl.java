package beans.repository;

import beans.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNewUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public List getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    public User getUserByID(Integer id) {
        return sessionFactory.getCurrentSession().byId(User.class).load(id);
    }

    public boolean removeUser(Integer id) {

        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);
        return true;
    }

    public boolean editExistingUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        return true;
    }
}