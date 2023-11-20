package com.example.springsecurity.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static final List<Todo> todoList = List.of(new Todo("lila", "Learn Spring boot"), new Todo("lila", "Learn AWS"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
        return todoList;
    }
    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForSpecificUser(@PathVariable String username){
        return todoList.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo){
        logger.info("Create {} for {}", todo, username);
    }
}
record Todo(String username, String description){

}