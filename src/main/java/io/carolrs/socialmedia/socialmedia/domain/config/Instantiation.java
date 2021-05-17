package io.carolrs.socialmedia.socialmedia.domain.config;

import io.carolrs.socialmedia.socialmedia.domain.Post;
import io.carolrs.socialmedia.socialmedia.domain.User;
import io.carolrs.socialmedia.socialmedia.domain.resource.repository.PostRepository;
import io.carolrs.socialmedia.socialmedia.domain.resource.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
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

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, LocalDate.now(),"Partiu viagem", "Vou viajar para SP.",maria);
        Post post2 = new Post(null, LocalDate.now(),"Bom dia", "Acordei feliz.",maria);

        postRepository.saveAll(Arrays.asList(post1,post2));
        userRepository.saveAll(Arrays.asList(maria,alex,bob));

    }
}
