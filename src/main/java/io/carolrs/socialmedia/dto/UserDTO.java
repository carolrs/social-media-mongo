package io.carolrs.socialmedia.dto;

import io.carolrs.socialmedia.socialmedia.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO(User obj){
        id= obj.getId();
        name= obj.getName();
        email=obj.getEmail();
    }
}
