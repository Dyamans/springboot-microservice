package com.pccw.regservice.controller;



import com.pccw.regservice.model.User;
import com.pccw.regservice.service.UserService;
import com.pccw.regservice.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;
    //private EmailService emailService;


    @Autowired
    private RestTemplate restTemplate;


    // -------------------Create a User-------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody final User user,
                                        final UriComponentsBuilder ucBuilder, final BindingResult bindingResult) {
        logger.info("Creating User : {}", user);

        //userValidator.validate(user, bindingResult);
       
        try {

            userService.addUser(user);

            //send email.
            restTemplate.exchange(
                    "http://email-service/api/email/" + user.getEmail(),
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<String>() {
                    });

        }catch(HttpStatusCodeException e) {
            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());
        }

        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // -------------------Retrieve Single User------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") final Long id) {
        logger.info("Fetching User with id {}", id.toString());
        final User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    // ------------------- Update a User ------------------------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") final long id, @RequestBody final User user) {
        logger.info("Updating User with id {}", id);
        final User currentUser = userService.findUserById(id);

        currentUser.setName(user.getName());
        currentUser.setPhone(user.getPhone());
        currentUser.setEmail(user.getEmail());

        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    // ------------------- Delete a User-----------------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") final long id) {
        logger.info("Fetching & Deleting User with id {}", id);
        userService.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    // -------------------Retrieve All Users---------------------------------------------

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Fetching all Users");
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()) {
            return new ResponseEntity("There is no records", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
