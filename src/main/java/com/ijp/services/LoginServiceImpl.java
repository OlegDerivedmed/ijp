package com.ijp.services;

import com.ijp.dto.TokenDto;
import com.ijp.entities.Token;
import com.ijp.entities.User;
import com.ijp.form.LoginForm;
import com.ijp.repository.TokensRepository;
import com.ijp.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
            var user = userCandidate.get();
            if (passwordEncoder.matches(loginForm.getPassword(),user.getPassword())){
                var token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(64,true,true))
                        .build();
                tokensRepository.save(token);
                return TokenDto.from(token);
            }
        }
        throw new IllegalArgumentException("wrong login or password");
    }
}
