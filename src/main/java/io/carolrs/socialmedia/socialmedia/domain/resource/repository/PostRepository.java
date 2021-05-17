package io.carolrs.socialmedia.socialmedia.domain.resource.repository;

import io.carolrs.socialmedia.socialmedia.domain.Post;
import io.carolrs.socialmedia.socialmedia.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
    //busca query

}
