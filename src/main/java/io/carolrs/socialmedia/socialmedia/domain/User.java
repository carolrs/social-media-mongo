package io.carolrs.socialmedia.socialmedia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@EqualsAndHashCode (of = "id")
@Document
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true)
    //os posts so serao acecssados se voce explicitar.Evita que eles venham jnt com o User.
    private List<Post> posts= new ArrayList<>();


    public User(String id,String name, String email) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public List <Post> getPosts(){
        return posts;
    }
    public void  setPosts(List<Post> posts){
        this.posts=posts;
    }
}
