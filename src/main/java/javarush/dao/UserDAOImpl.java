package javarush.dao;

import javarush.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        User userToUpdate = getUser(user.getId());
        userToUpdate.setName(user.getName());
        userToUpdate.setAge(user.getAge());
        userToUpdate.setIsAdmin(user.isIsAdmin());
        getCurrentSession().update(userToUpdate);
    }

    @Override
    public User getUser(int id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUser(id);
        if (user != null)
            getCurrentSession().delete(user);
    }

    @Override
    //return List because we can have few users at same name
    public List<User> searchUsers(String name) {
        List<User> result = new ArrayList<>();
        for (User user : getUsers()) {
            if (user.getName().equals(name))
                result.add(user);
        }

        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return getCurrentSession().createQuery("from User").list();
    }
}
