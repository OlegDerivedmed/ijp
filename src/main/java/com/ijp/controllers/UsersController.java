package com.ijp.controllers;

import com.ijp.entities.Token;
import com.ijp.entities.User;
import com.ijp.form.UserForm;
import com.ijp.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/signup")
    @ApiOperation(value = "signup method")
    public ResponseEntity<HttpStatus> signUp(@RequestBody @Valid UserForm userForm) {
        userService.createUser(userForm);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/update")
    @ApiOperation(value = "get update user page")
    public UserForm getUpdatePage(@RequestParam String token) {
        Optional<User> userCandidate = userService.findByToken(token);
        User user = userCandidate.orElseThrow(() -> new IllegalStateException("invalid token"));
        return UserForm.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .build();
    }
}
