package at.dke.service.useradmin;

import at.dke.service.useradmin.entity.User;
import at.dke.service.useradmin.repository.UserRepository;
import at.dke.service.useradmin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UseradminApplication {

	public static final Logger log = LoggerFactory.getLogger(UseradminApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UseradminApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDB(UserRepository userRepository, UserService userService) {
		return args -> {
			User user = new User();
			user.setFirstName("fistname");
			user.setLastName("lastname");
			user.setUsername("username");
			user.setPwd("password");
			userRepository.save(user);

			// retrieve all
			Iterable<User> users = userRepository.findAll();

			List<User> u = userService.getUsersByUsername("firstname");
			log.info("UseradminApplication, {}", u);
			// print all
			users.forEach(System.out::println);
		};
	}
}
