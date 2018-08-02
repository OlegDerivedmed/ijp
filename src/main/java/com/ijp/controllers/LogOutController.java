package com.ijp.controllers;

import com.ijp.repository.TokensRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
public class LogOutController {

    @Autowired
    TokensRepository tokensRepository;

    @GetMapping("/logOut")
    @SneakyThrows
    @ApiOperation(value = "log out")
    public ResponseEntity<HttpStatus> logOut(@RequestParam String token){
        tokensRepository.delete(tokensRepository
                .findOneByValue(token)
                .orElseThrow(NotFound::new));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
