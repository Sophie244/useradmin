package at.dke.service.useradmin.repository;

import at.dke.service.useradmin.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface UserRepository extends Neo4jRepository<User, Long> {

    User getUserByUsername(String username);

    List<User> findUserByUsernameContaining(String username);

}
