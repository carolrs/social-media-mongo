package io.carolrs.socialmedia.socialmedia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode (of = "id")
public class User implements Serializable {
    private String id;
    private String name;
    private String email;
}
