package io.carolrs.socialmedia.socialmedia.domain.config;

import io.carolrs.socialmedia.dto.AuthorDTO;
import io.carolrs.socialmedia.dto.CommentDTO;
import io.carolrs.socialmedia.socialmedia.domain.Post;
import io.carolrs.socialmedia.socialmedia.domain.User;
import io.carolrs.socialmedia.socialmedia.domain.resource.repository.PostRepository;
import io.carolrs.socialmedia.socialmedia.domain.resource.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Mari a Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null, LocalDateTime.now(),"Partiu viagem", "Vou viajar para SP.",new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDateTime.now(),"Bom dia", "Acordei feliz.",new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem!", LocalDate.now(),new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!", LocalDate.now(),new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um otimo dia!", LocalDate.now(),new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);

    }
}
