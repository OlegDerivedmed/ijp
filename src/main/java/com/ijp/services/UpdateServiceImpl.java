package com.ijp.services;

import com.ijp.entities.User;
import com.ijp.form.UserForm;
import com.ijp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public void updateUser(User user, UserForm userForm) {
        userRepository.save(updateUserFields(user,userForm));
    }

    private User updateUserFields(User user, UserForm userForm){
        return User.builder().id(user.getId())
                .email(userForm.getEmail())
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .login(userForm.getLogin())
                .password(encoder.encode(userForm.getPassword()))
                .role(user.getRole())
                .state(user.getState())
                .tokens(user.getTokens())
                .build();
    }
}
