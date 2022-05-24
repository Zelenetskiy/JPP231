package web.services;

import web.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);
    void editUser(User user);
    void removeUser(Long id);
    User getUserById(Long id);
}
