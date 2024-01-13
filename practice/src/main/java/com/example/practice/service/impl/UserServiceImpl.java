package com.example.practice.service.impl;

import com.example.practice.dto.UserDto;
import com.example.practice.entity.Item;
import com.example.practice.entity.Order;
import com.example.practice.entity.Role;
import com.example.practice.entity.User;
import com.example.practice.repository.ItemRepository;
import com.example.practice.repository.OrderRepository;
import com.example.practice.repository.RoleRepository;
import com.example.practice.repository.UserRepository;
import com.example.practice.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;


    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,OrderRepository orderRepository,
                           ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_USER");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }

    @Override
    public void addItemToCart(User currentUser, Long itemId) {
//        User user = currentUser;
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

        // Create or update cart order
        Order cartOrder = currentUser.getOrders().stream()
                .filter(order -> order.getItems().isEmpty())
                .findFirst()
                .orElseGet(() -> {
                    Order newCartOrder = new Order();
                    newCartOrder.setUser(currentUser);
                    return orderRepository.save(newCartOrder);
                });

        // Check if the item is already in the cart, update quantity
        boolean itemInCart = cartOrder.getItems().stream()
                .anyMatch(cartItem -> cartItem.getId().equals(itemId));

        if (itemInCart) {
            // Update quantity for existing item in the cart
            // Note: You may need to implement a method in Item entity to update quantity
            // or manually update the quantity in the cart items list.
        } else {
            // Add the item to the cart
            cartOrder.getItems().add(item);
            item.getOrders().add(cartOrder);
            orderRepository.save(cartOrder);
        }
    }
}

