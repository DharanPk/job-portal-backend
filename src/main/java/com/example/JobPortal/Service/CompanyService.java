package com.example.JobPortal.Service;

import com.example.JobPortal.Model.Company;
import com.example.JobPortal.Model.User;
import com.example.JobPortal.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repo;

    public String adduser(List<Company> c) {
        repo.saveAll(c);
        return "add...";
    }

    public List<Company> get() {
        return repo.findAll();
    }

    public Optional<Company> idget(long id) {
        return repo.findById(id);
    }

    public String deleteid(long d) {
        repo.deleteById(d);
        return "Delted ...";

    }
}
