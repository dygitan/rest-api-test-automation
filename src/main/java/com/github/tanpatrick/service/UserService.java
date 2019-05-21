package com.github.tanpatrick.service;

import com.github.tanpatrick.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users = Arrays.asList(
            new User("Doe", "John"),
            new User("Doe", "Jane")
    );

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> findUserById(String id) {
        return users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
