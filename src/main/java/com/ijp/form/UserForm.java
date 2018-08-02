package com.ijp.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Oleg Derivedmed on 05.07.2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String login;
    @NotNull
    @NotBlank
    private String password;
}
