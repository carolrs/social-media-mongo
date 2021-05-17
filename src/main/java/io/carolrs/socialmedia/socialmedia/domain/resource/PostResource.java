package io.carolrs.socialmedia.socialmedia.domain.resource;

import io.carolrs.socialmedia.dto.UserDTO;
import io.carolrs.socialmedia.socialmedia.domain.Post;
import io.carolrs.socialmedia.socialmedia.domain.User;
import io.carolrs.socialmedia.socialmedia.domain.resource.service.PostService;
import io.carolrs.socialmedia.socialmedia.domain.resource.service.UserService;
import io.carolrs.socialmedia.socialmedia.domain.resource.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "")String text) {
        text = URL.decodeParam(text);
        List<Post> list= service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text",defaultValue = "")String text,
            @RequestParam(value = "minDate",defaultValue = "")String minDate,
            @RequestParam(value = "maxDate",defaultValue = "")String maxDate)
    {
        text = URL.decodeParam(text);
        LocalDateTime min = URL.convertDate(minDate, LocalDateTime.of( 1970,1,1,0,0 ));
        LocalDateTime max = URL.convertDate(maxDate, LocalDateTime.now());
        List<Post> list= service.fullSearch(text,min,max);
        return ResponseEntity.ok().body(list);
    }

}