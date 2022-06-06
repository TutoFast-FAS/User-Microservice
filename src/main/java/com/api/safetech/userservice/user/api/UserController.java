package com.api.safetech.userservice.user.api;

import com.api.safetech.userservice.user.domain.service.UserService;
import com.api.safetech.userservice.user.mapping.UserMapper;
import com.api.safetech.userservice.user.resource.CreateUserResource;
import com.api.safetech.userservice.user.resource.UpdateUserResource;
import com.api.safetech.userservice.user.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User")
@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Operation(summary = "Get All Users", description = "Get All Users")
    @GetMapping
    public List<UserResource> getAllUser(){
        return userMapper.toResource(userService.getAll());
    }

    @Operation(summary = "Get User by Id", description = "Get User by Id")
    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable Long userId){
        return userMapper.toResource(userService.getById(userId));
    }

    @Operation(summary = "Get User by Email", description = "Get User by Email")
    @GetMapping("emails/{email}")
    public UserResource getUserByEmail(@PathVariable String email){
        return userMapper.toResource(userService.getByEmail(email));
    }

    @Operation(summary = "Get User by Complete Name", description = "Get User by Complete Name")
    @GetMapping("firstName/{firstName}/lastName/{lastName}")
    public List<UserResource> getUserByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return userMapper.toResource(userService.getByFirstNameAndLastName(firstName, lastName));
    }

    @Operation(summary = "Create New User", description = "Create New User")
    @PostMapping
    public UserResource createUser(@RequestBody CreateUserResource model){
        return userMapper.toResource(userService.create(userMapper.toModel(model)));
    }

    @Operation(summary = "Update User", description = "Update User")
    @PutMapping("{userId}")
    public UserResource updateUser(@PathVariable Long userId, @RequestBody UpdateUserResource model){
        return userMapper.toResource(userService.update(userId, userMapper.toModel(model)));
    }

    @Operation(summary = "Delete User", description = "Delete User")
    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.delete(userId);
    }


}
