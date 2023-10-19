package com.rest.webservices.restfulwebservices.user;

import com.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    //Replace "userDaoService" by "userRepository". Not use UserDaoService
    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    // /jpa/users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    // HATEOAS
    // EntityModel and WebMvcLinkBuilder
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        // Change the type of user from "User" to "Optional<User>"
        Optional<User> user = userRepository.findById(id);
//      if (user == null)
        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);
        // Wrap the User, create an EntityModel
//        EntityModel<User> entityModel = EntityModel.of(user);
        EntityModel<User> entityModel = EntityModel.of(user.get());
        // Use WebMvcLinkBuilder to create a link
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        // Add the link to the EntityModel
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    //Delete
    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    //POST /users
    @PostMapping("/jpa/users")
    //Make this method to response of POST status, it should return 201
    //Add @Valid
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
        //location - /users/4
        URI localtion = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri(); // users/4 => /users/{id}
        return ResponseEntity.created(localtion).build();
    }

    // Retrieve Posts for a user
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePosts(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);
        return user.get().getPosts();
    }
    // Create a Post for a user
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPosts(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);
        post.setUser(user.get());

        Post savedPost = postRepository.save(post);
        URI localtion = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri(); // users/4 => /users/{id}
        return ResponseEntity.created(localtion).build();
    }

}
