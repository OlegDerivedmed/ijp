package com.ijp.dto;

import com.ijp.entities.Token;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */
@Data
@AllArgsConstructor
public class TokenDto {

    private String token;

    public static TokenDto from(Token token) {
        return new TokenDto(token.getValue());
    }
}
