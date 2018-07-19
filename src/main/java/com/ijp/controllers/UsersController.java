package com.ijp.controllers;

import com.ijp.form.UserForm;
import com.ijp.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */

@RestController
@Api
@CrossOrigin
public class UsersController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    @ApiOperation(value = "signup method")
    public ResponseEntity<HttpStatus> signUp(@RequestBody@Valid UserForm userForm){
        service.createUser(userForm);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
