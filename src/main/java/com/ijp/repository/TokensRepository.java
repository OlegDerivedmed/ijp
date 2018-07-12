package com.ijp.repository;

import com.ijp.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */
public interface TokensRepository extends JpaRepository<Token,Long> {

    Optional<Token> findOneByValue(String value);
}
