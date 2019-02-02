package com.ijp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Post_tags",
    joinColumns = {@JoinColumn(name = "tag_id")},
    inverseJoinColumns = {@JoinColumn(name = "post_id")})
    private Set<Tag> tags;

}
