package com.ijp.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by Oleg Derivedmed on 05.07.2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String login;
    @NotNull
    private String password;
}
