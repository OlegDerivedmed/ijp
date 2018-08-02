package com.ijp.controllers;

import com.ijp.entities.User;
import com.ijp.form.UserForm;
import com.ijp.services.UpdateService;
import com.ijp.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */

@RestController
@Api
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private UpdateService updateService;

    @PostMapping("/signup")
    @ApiOperation(value = "signup method")
    public ResponseEntity<HttpStatus> signUp(@RequestBody @Valid UserForm userForm) {
        userService.createUser(userForm);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/update")
    @ApiOperation(value = "get update user page")
    public UserForm getUpdatePage(@RequestParam String token) {
        User user = getUserByToken(token);
        return getUserForm(user);

    }

    @PostMapping("/update")
    @ApiOperation(value = "update user")
    public ResponseEntity<HttpStatus> update(@RequestParam String token, @RequestBody @Valid UserForm userForm) {
        updateService.updateUser(getUserByToken(token), userForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private User getUserByToken(String token) {
        Optional<User> userCandidate = userService.findByToken(token);
        return userCandidate.orElseThrow(() -> new IllegalStateException("invalid token"));

    }

    private UserForm getUserForm(User user) {
        return UserForm.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .build();
    }
}
