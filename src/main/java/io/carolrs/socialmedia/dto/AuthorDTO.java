package io.carolrs.socialmedia.dto;

import io.carolrs.socialmedia.socialmedia.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO (User obj){
        id = obj.getId();
        name = obj.getName();
    }
}

