package com.ijp.services;


import com.ijp.entities.User;
import com.ijp.form.UserForm;

import java.util.Optional;


public interface UserService {

    void createUser(UserForm userForm);
    Optional<User> findByLogin(String login);
    Optional<User> fingById(long id);
}
