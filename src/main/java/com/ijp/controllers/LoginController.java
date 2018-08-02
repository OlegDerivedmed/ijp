package com.ijp.controllers;

import com.ijp.dto.TokenDto;
import com.ijp.form.LoginForm;
import com.ijp.services.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */
@RestController
@Api
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation(value = "login method")
    public ResponseEntity<TokenDto> login(@RequestBody LoginForm loginForm){
        return ResponseEntity.ok(loginService.login(loginForm));
    }
}
