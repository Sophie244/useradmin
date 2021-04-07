package at.dke.service.useradmin.serviceimpl;

import at.dke.service.useradmin.entity.User;
import at.dke.service.useradmin.repository.UserRepository;
import at.dke.service.useradmin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    /**
     * Get a list of users with with username similar to the requested username
     *
     * @param username
     * @return
     */
    @Override
    public List<User> getUsersByUsername(String username) {
        log.info("getUsersByUsername, {}", username);
        return userRepository.findUserByUsernameContaining(username);
    }

    /**
     * Creates a user
     *
     * @param user
     */
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    /**
     * Updates the user with the requested id
     *
     * @param id
     */
    @Override
    public void updateUser(Long id, User user) {
        Optional<User> u = userRepository.findById(id);
        if (u.isPresent()) {
            log.info("updateUser, {}", user);
            user.setId(u.get().getId());
            user.setFirstName(u.get().getFirstName());
            user.setLastName(u.get().getLastName());
            user.setUsername(u.get().getUsername());
            user.setPwd(u.get().getPwd());
            user.setFollower(u.get().getFollower());
            user.setFollowing(u.get().getFollowing());
            userRepository.save(user);
        } else {
            log.error("updateUser, no user to update with id {}", id);
        }
    }

    /**
     * Deletes a user
     *
     * @param user
     */
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
        log.info("deleteUser, {}", user);
    }

    /**
     * Get the followers of a user
     *
     * @param username
     * @return
     */
    @Override
    public List<User> getFollowers(String username) {
        User user = userRepository.getUserByUsername(username);
        if (user != null) {
            log.info("getFollowers, {}", username);
            return user.getFollower();
        }
        return null;
    }

    /**
     * Get the following
     *
     * @param username
     * @return
     */
    @Override
    public List<User> getFollowing(String username) {
        User user = userRepository.getUserByUsername(username);
        if (user != null) {
            log.info("getFollowing, {}", username);
            return user.getFollowing();
        }
        return null;
    }
}
