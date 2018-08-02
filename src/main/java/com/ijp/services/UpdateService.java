package com.ijp.services;

import com.ijp.entities.User;
import com.ijp.form.UserForm;

public interface UpdateService {

    void updateUser(User user, UserForm userForm);
}
