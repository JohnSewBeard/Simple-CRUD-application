package javarush.service;

import javarush.model.User;

import java.util.List;

public interface UserService {

    void addTeam(User team);

    void updateTeam(User team);

    User getTeam(int id);

    User searchUser(String name);

    void deleteTeam(int id);

    List<User> getTeams();
}
