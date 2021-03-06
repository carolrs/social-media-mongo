package io.carolrs.socialmedia.socialmedia.domain.resource.service;

import io.carolrs.socialmedia.dto.UserDTO;
import io.carolrs.socialmedia.socialmedia.domain.Post;
import io.carolrs.socialmedia.socialmedia.domain.User;
import io.carolrs.socialmedia.socialmedia.domain.resource.repository.PostRepository;
import io.carolrs.socialmedia.socialmedia.domain.resource.repository.UserRepository;
import io.carolrs.socialmedia.socialmedia.domain.resource.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }
    public List<Post> fullSearch(String text, LocalDateTime minDate, LocalDateTime maxDate) {
        return repo.fullSearch(text, minDate, maxDate);
    }

}