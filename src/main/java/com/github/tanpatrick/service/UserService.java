package com.github.tanpatrick.service;

import com.github.tanpatrick.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users = Arrays.asList(
            new User("464d3975-3a59-4447-94d6-fd273600ec50", "Doe", "John"),
            new User("d52cafcd-3f09-4304-a047-b06526ee01a0", "Doe", "Jane")
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
