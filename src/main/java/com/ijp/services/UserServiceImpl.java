package com.ijp.services;

import com.ijp.entities.Role;
import com.ijp.entities.State;
import com.ijp.entities.User;
import com.ijp.form.UserForm;
import com.ijp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    @Transactional
    public void createUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .login(userForm.getLogin())
                .password(encoder.encode(userForm.getPassword()))
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        repository.save(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return repository.findOneByLogin(login);
    }

    @Override
    public Optional<User> fingById(long id) {
        return repository.findById(id);
    }
}
