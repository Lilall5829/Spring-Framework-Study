package com.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    //GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    //GET /users/1
    @GetMapping("/users/{id}")
    //@PathVariable is different from @RequestParam. Pay attention to use them!
    public User retrieveUser(@PathVariable int id){
        User user = userDaoService.findById(id);
        if (user == null)
            //UserNotFoundException extends RuntimeException class
            throw new UserNotFoundException("id:" + id);
//        return userDaoService.findById(id);
        return user;
    }

    //POST /users
    @PostMapping("/users")
    //Make this method to response of POST status, it should return 201
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userDaoService.save(user);
        //location - /users/4
        URI localtion = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri(); // users/4 => /users/{id}
        return ResponseEntity.created(localtion).build();
    }
}
