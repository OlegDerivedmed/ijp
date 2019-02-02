package com.ijp.services;

import com.ijp.dto.TokenDto;
import com.ijp.entities.Token;
import com.ijp.entities.User;
import com.ijp.form.LoginForm;
import com.ijp.repository.TokensRepository;
import com.ijp.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userCandidate = userRepository.findOneByLogin(loginForm.getLogin());
        if (userCandidate.isPresent()){
            User user = userCandidate.get();
            if (passwordEncoder.matches(loginForm.getPassword(),user.getPassword())){
                String randomString = RandomStringUtils.random(64, true, true);
                SecretKey secretKey = Keys.hmacShaKeyFor(randomString.getBytes());
                String jwt = Jwts.builder()
                        .claim("id",user.getId())
                        .signWith(secretKey)
                        .compact();
                Token token = Token.builder()
                        .user(user)
                        .value(jwt)
                        .expires(LocalDateTime.now().plusDays(1))
                        .build();
                tokensRepository.save(token);
                return TokenDto.from(token);
            }
        }
        throw new IllegalArgumentException("wrong login or password");
    }
}
