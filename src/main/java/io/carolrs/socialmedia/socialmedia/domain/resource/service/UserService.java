package io.carolrs.socialmedia.socialmedia.domain.resource.service;

import io.carolrs.socialmedia.socialmedia.domain.User;
import io.carolrs.socialmedia.socialmedia.domain.resource.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List <User> findAll(){
         return repo.findAll();
    }
}
