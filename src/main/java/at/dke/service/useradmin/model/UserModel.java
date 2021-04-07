package at.dke.service.useradmin.model;

import at.dke.service.useradmin.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "UserModel")
public class UserModel {

    @ApiModelProperty(value = "Generated ID",
            dataType = "Long")
    private Long id;

    @ApiModelProperty(value = "firstname",
            dataType = "String")
    private String firstName;

    @ApiModelProperty(value = "lastname",
            dataType = "String")
    private String lastName;

    @ApiModelProperty(value = "username",
            dataType = "String")
    private String username;

    @ApiModelProperty(value = "password",
            dataType = "String")
    private String pwd;

    @ApiModelProperty(value = "follower",
            dataType = "List")
    private List<User> follower;

    @ApiModelProperty(value = "following",
            dataType = "List")
    private List<User> following;

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<User> getFollower() {
        return follower;
    }

    public void setFollower(List<User> follower) {
        this.follower = follower;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }
}
