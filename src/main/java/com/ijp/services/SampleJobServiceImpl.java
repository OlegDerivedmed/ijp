package com.ijp.services;

import com.ijp.entities.Token;
import com.ijp.repository.TokensRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SampleJobServiceImpl implements SampleJobService {

    @Autowired
    TokensRepository tokensRepository;

    public void executeSampleJob(){
        List<Token> tokens = tokensRepository.findAll();
        tokens.stream().filter(t -> t.getExpires().isBefore(LocalDateTime.now()))
                .forEach(t -> tokensRepository.delete(t));
    }
}
