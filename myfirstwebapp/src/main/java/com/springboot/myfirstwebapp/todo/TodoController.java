package com.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//import static com.sun.beans.introspect.PropertyInfo.Name.description;

//@Controller This controller was deprecated!!!
@SessionAttributes("name")

public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
//    private String getLoggedInUsername(ModelMap model){
//        return (String)model.get("name");
//    }
    //list-todos
    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername(model);
        List<Todo> todos = todoService.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }



    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model) {
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "addTodo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "addTodo";
        }
        String username = getLoggedInUsername(model);
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
        //redirect should be followed by the URL(such as list-todos) rather than jsp name!
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "addTodo";
    }

    @PostMapping("update-todo")
    public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "addTodo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

