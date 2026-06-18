package com.example.JobPortal.Controller;

import com.example.JobPortal.Model.User;
import com.example.JobPortal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService s;

    @PostMapping("/user")
    public String poster(@RequestBody List<User> user) {
        return s.adduser(user);
    }

    @GetMapping("/user")
    public List<User> get() {
        return s.get();
    }

    @GetMapping("/user/{id}")
    public User getid(@PathVariable("id") long id) {
        return s.idget(id);
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") long d) {
        return s.deleteid(d);
    }
}
