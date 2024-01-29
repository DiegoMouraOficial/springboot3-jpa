package io.diegomoura.springboot.resources;

import io.diegomoura.springboot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User users = new User(1L, "Diego", "diego@gmail.com", "11 92001-2470", "*****");
        return ResponseEntity.ok().body(users);
    }
}
