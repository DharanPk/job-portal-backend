package com.example.JobPortal.Controller;

import com.example.JobPortal.Model.Company;

import com.example.JobPortal.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService s;
    @PostMapping("/company")
    public String poster(@RequestBody List<Company> c) {
        return s.adduser(c);
    }

    @GetMapping("/company")
    public List<Company> get() {
        return s.get();
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getuid(@PathVariable("id") long id) {
        Optional<Company> company = s.idget(id);

        if(company.isPresent()) {
            return ResponseEntity.ok(company.get());
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(404));
    }

    @DeleteMapping("/company/{id}")
    public String delete(@PathVariable("id") long d) {
        return s.deleteid(d);
    }
}


