package javarush.dao;

import javarush.model.User;

import java.util.List;

public interface UserDAO {

    void addTeam(User team);

    void updateTeam(User team);

    User getTeam(int id);

    void deleteTeam(int id);

    User searchUser(String name);

    List<User> getTeams();
}
