package io.carolrs.socialmedia.socialmedia.domain;

import io.carolrs.socialmedia.dto.AuthorDTO;
import io.carolrs.socialmedia.dto.CommentDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@EqualsAndHashCode (of = "id")
@Document //indica que é um doc no mongo
public class Post implements Serializable {

    @Id
    private String id;
    private LocalDateTime date;
    private String title;
    private String body;
    private AuthorDTO author;

    private List <CommentDTO> comments = new ArrayList<>();

    public Post(String id, LocalDateTime date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

}
