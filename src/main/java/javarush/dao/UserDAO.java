package javarush.dao;

import javarush.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void updateUser(User user);

    User getUser(int id);

    List<User> searchUsers(String name);

    void deleteUser(int id);

    List<User> getUsers();
}
