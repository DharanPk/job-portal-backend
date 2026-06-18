package com.example.JobPortal.Controller;

import com.example.JobPortal.Model.Company;
import com.example.JobPortal.Model.Job;
import com.example.JobPortal.Service.CompanyService;
import com.example.JobPortal.Service.JobService;
import com.example.JobPortal.dto.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {
    @Autowired
    private JobService s;
    @PostMapping("/job")
    public String poster(@RequestBody List<JobDTO> c) {
        return s.adduser(c);
    }

    @GetMapping("/job")
    public List<Job> get() {
        return s.get();
    }

    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getuid(@PathVariable("id") long id) {
        Optional<Job> company = s.idget(id);

        if(company.isPresent()) {
            return ResponseEntity.ok(company.get());
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(404));
    }

    @DeleteMapping("/job/{id}")
    public String delete(@PathVariable("id") long d) {
        return s.deleteid(d);
    }
}
