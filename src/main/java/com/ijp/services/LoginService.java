package com.ijp.services;


import com.ijp.dto.TokenDto;
import com.ijp.form.LoginForm;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */
public interface LoginService {

    TokenDto login(LoginForm loginForm);
}
