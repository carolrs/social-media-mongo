package io.carolrs.socialmedia.socialmedia.domain.resource.service;

import io.carolrs.socialmedia.socialmedia.domain.User;
import io.carolrs.socialmedia.socialmedia.domain.resource.repository.UserRepository;
import io.carolrs.socialmedia.socialmedia.domain.resource.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List <User> findAll(){
         return repo.findAll();
    }
    public User findById (String id){

        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
    }
}
