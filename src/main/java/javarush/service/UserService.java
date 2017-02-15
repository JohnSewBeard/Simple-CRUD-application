package javarush.service;

import javarush.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void updateUser(User user);

    User getUser(int id);

    List<User> searchUsers(String name);

    void deleteUser(int id);

    List<User> getUsers();
}
