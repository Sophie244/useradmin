package at.dke.service.useradmin.resource;

import at.dke.service.useradmin.entity.User;
import at.dke.service.useradmin.model.UserModel;
import at.dke.service.useradmin.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Endpoint for user administration")
@SwaggerDefinition(tags = {
        @Tag(name = "Endpoint for user administration",
        description = "Endpoint to create, read, update, delete users")
})
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping
    @ApiOperation(value = "Create a new user", response = UserModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Creation Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<User> createUser(@ApiParam(value = "User to create", required = true) @RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Update a user", response = UserModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Update Successful"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public ResponseEntity<User> updateUser(@ApiParam(value = "ID of the user to update", required = true) @PathVariable Long id,
                                           @ApiParam(value = "User to update", required = true) @RequestBody User user) {
        userService.updateUser(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "Get users by exact or similar username", response = UserModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<User>> getUserByUsername(@ApiParam(value = "Username", required = true) @RequestParam String username) {
        List<User> users;
        users = userService.getUsersByUsername(username);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{username}/followers")
    @ApiOperation(value = "Get the followers of an user", response = UserModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<User>> getUsersFollower(@ApiParam(value = "Username", required = true) @PathVariable String username) {
        List<User> users;
        users = userService.getFollowers(username);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{username}/following")
    @ApiOperation(value = "Get the followed users", response = UserModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<List<User>> getUserFollowing(@ApiParam(value = "Username", required = true) @PathVariable String username) {
        List<User> users;
        users = userService.getFollowing(username);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping
    @ApiOperation(value = "Delete a user", response = UserModel.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Request Successful"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public ResponseEntity<User> deleteUser(@ApiParam(value = "User", required = true) @RequestBody User user) {
        userService.deleteUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
