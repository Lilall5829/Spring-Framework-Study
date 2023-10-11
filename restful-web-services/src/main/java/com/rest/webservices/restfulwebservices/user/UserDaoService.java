package com.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// DAO = Data Access Object
@Component
public class UserDaoService {
    //JPA/Hibernate -> Database
    //UserDaoService -> Static Lists
    private static List<User> users = new ArrayList<>();
    private static Integer usersCount = 0;
    static {
        users.add(new User(++usersCount, "Lila1", LocalDate.now().minusYears(28)));
        users.add(new User(++usersCount, "Lila2", LocalDate.now().minusYears(29)));
        users.add(new User(++usersCount, "Lila3", LocalDate.now().minusYears(30)));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        User user = users.stream().filter(predicate).findFirst().get();
        // If the user doesn't exist, return a proper error structure and id.
        User user = users.stream().filter(predicate).findFirst().orElse(null);
        return user;
    }
}
