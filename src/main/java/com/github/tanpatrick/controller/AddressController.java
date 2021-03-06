package com.github.tanpatrick.controller;

import com.github.tanpatrick.model.Address;
import com.github.tanpatrick.model.User;
import com.github.tanpatrick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<Address> getUserAddress(@PathVariable String id) {
        User user = userService.findUserById(id).orElse(null);

        if (user == null) {
            return ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity.ok(new Address(String.format("Address of user %s", user.toString())));
    }
}
