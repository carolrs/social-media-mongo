package io.carolrs.socialmedia.socialmedia.domain.resource.repository;

import io.carolrs.socialmedia.socialmedia.domain.Post;
import io.carolrs.socialmedia.socialmedia.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
