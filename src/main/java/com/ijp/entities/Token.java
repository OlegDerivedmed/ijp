package com.ijp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Oleg Derivedmed on 07.07.2018
 */
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    private LocalDateTime expires;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
