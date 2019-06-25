package com.pccw.regservice.service;

import com.pccw.regservice.exception.UserAlreadyExistException;
import com.pccw.regservice.exception.UserNotFoundException;
import com.pccw.regservice.model.User;
import com.pccw.regservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    @Transactional
    public void addUser(final User user) {

        if(isUserExist(user.getId())){
            throw new UserAlreadyExistException(User.class, "id", user.getId().toString());
        }
        userRepository.saveAndFlush(user);

    }

    public User findUserById(final Long id) {

        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(User.class, "id", id.toString()));
    }

    @Transactional
    public void updateUser(final User user){

        userRepository.saveAndFlush(user);
    }

    @Transactional
    public void deleteUser(Long id) {

        if(!isUserExist(id)){
            throw new UserNotFoundException(User.class, "id", id.toString());
        }

        userRepository.deleteById(id);
    }

    public List<User> findAllUsers() {

        return userRepository.findAll();
    }

    private boolean isUserExist(Long id){
        return userRepository.findById(id).isPresent();
    }

}
