package io.carolrs.socialmedia.socialmedia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode (of = "id")
@Document //indica que é um doc no mongo
public class Post implements Serializable {

    @Id
    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private User author;

}
