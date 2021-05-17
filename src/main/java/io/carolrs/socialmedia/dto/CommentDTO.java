package io.carolrs.socialmedia.dto;

import io.carolrs.socialmedia.socialmedia.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDTO implements Serializable {
    private String text;
    private LocalDate date;
    private AuthorDTO author;

}
