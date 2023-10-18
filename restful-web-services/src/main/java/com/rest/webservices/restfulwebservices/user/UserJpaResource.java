package com.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    private UserDaoService userDaoService;

    public UserJpaResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    //GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    //GET /users/1
//    @GetMapping("/users/{id}")
//    //@PathVariable is different from @RequestParam. Pay attention to use them!
//    public User retrieveUser(@PathVariable int id){
//        User user = userDaoService.findById(id);
//        if (user == null)
//            //UserNotFoundException extends RuntimeException class
//            throw new UserNotFoundException("id:" + id);
////        return userDaoService.findById(id);
//        return user;
//    }


    // HATEOAS
    // EntityModel and WebMvcLinkBuilder
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        User user = userDaoService.findById(id);
        if (user == null)
            throw new UserNotFoundException("id:" + id);
        // Wrap the User, create an EntityModel
        EntityModel<User> entityModel = EntityModel.of(user);
        // Use WebMvcLinkBuilder to create a link
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        // Add the link to the EntityModel
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    //Delete
    @DeleteMapping("/users/{id}")
    //@PathVariable is different from @RequestParam. Pay attention to use them!
    public void deleteUser(@PathVariable int id){
        userDaoService.deleteById(id);
    }

    //POST /users
    @PostMapping("/users")
    //Make this method to response of POST status, it should return 201
    //Add @Valid
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        //location - /users/4
        URI localtion = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri(); // users/4 => /users/{id}
        return ResponseEntity.created(localtion).build();
    }
}
