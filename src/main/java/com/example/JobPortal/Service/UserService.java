package com.example.JobPortal.Service;

import com.example.JobPortal.Model.User;
import com.example.JobPortal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public String adduser(List<User> user) {
        repo.saveAll(user);
        return "add...";
    }

    public List<User> get() {
        return repo.findAll();
    }

    public User idget(long id) {
        return repo.findAllById(id);
    }

    public String deleteid(long d) {
        repo.deleteById(d);
        return "Delted ...";
    }
}
