package at.dke.service.useradmin.service;

import at.dke.service.useradmin.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsersByUsername(String username);

    void createUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(User user);

    List<User> getFollowers(String username);

    List<User> getFollowing(String username);
}
