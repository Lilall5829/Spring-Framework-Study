package com.example.practice.controller;

import com.example.practice.dto.UserDto;
import com.example.practice.entity.Item;
import com.example.practice.entity.User;
import com.example.practice.repository.ItemRepository;
import com.example.practice.repository.UserRepository;
import com.example.practice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;


@Controller
@SessionAttributes("name")
public class AuthController {
    private UserService userService;
    private ItemRepository itemRepository;

    public AuthController(UserService userService, ItemRepository itemRepository) {
        this.userService = userService;
        this.itemRepository = itemRepository;
    }

    // handler method to handle home page request
    @GetMapping("/")
    public String index(){
        return "index";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/items")
    public String items(Model model){
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "items";
    }
    @GetMapping("add-item")
    public String showNewItemPage(ModelMap model) {
        Item item = new Item();

        model.put("item", item);
        return "addItem";
    }

    @PostMapping("add-item")
    public String addNewItem(@Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "addItem";
        }
        itemRepository.save(item);
//        itemService.addItem();
        return "redirect:items";
    }

    @RequestMapping("delete-item")
    public String deleteItem(@RequestParam Long id) {
        itemRepository.deleteById(id);
        return "redirect:items";
    }

    @GetMapping("update-item")
    public String showUpdateItemPage(@RequestParam Long id, ModelMap model) {
        Item item = itemRepository.findById(id).get();
        model.addAttribute("item", item);
        return "addItem";
    }
    @PostMapping("update-item")
    public String updateItem(@Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "addItem";
        }
        itemRepository.save(item);
        return "redirect:items";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/homepage")
    public String homepage(ModelMap model){
        model.put("name", getLoggedinUsername());
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "homepage";
    }
    @GetMapping("/detail")
    public String coat(@RequestParam String name, Model model) {
       Item item = itemRepository.findByName(name);
        model.addAttribute("item", item);
        return "detail";
    }
    @GetMapping("/addSuccess")
    public String addItemToCart(
            @RequestParam Long id) {
        String name = getLoggedinUsername();
        User user = userService.findUserByName(name);
//        User user = userService.findUserByName(name);
        userService.addItemToCart(user, id);
        return "addSuccess";

    }

    @GetMapping("/contact")
    public String contact(ModelMap model){
        model.put("name", getLoggedinUsername());
        return "contact";
    }


//    @PostMapping("/submit")
//    public ResponseEntity<String> submitOrder(@RequestParam String userEmail) {
//        userService.submitOrder(userEmail);
//        return ResponseEntity.ok("Order submitted successfully.");
//    }
    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
