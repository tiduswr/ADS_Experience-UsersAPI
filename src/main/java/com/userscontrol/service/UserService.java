package com.userscontrol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.userscontrol.model.User;
import com.userscontrol.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;

    @Transactional(readOnly = false)
    public User saveUser(User user){
        return repo.save(user);
    }

    public void delete(Long id){
        repo.findById(id)
            .map(userDb -> {
                repo.delete(userDb);
                return userDb;
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
        return repo.findAll();
    }

    @Transactional(readOnly = false)
    public User update(Long id, User user){
        return repo.findById(id)
            .map(userDb -> {
                userDb.setDataNascimento(user.getDataNascimento());
                userDb.setPassword(user.getPassword());
                userDb.setUserName(user.getUserName());
                repo.save(userDb);
                return userDb;
            }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
