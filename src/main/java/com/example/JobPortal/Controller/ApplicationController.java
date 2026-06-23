package com.example.JobPortal.Controller;

import com.example.JobPortal.Model.Application;
import com.example.JobPortal.Service.ApplicationService;
import com.example.JobPortal.dto.ApplicatioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ApplicationController {
    @Autowired
    private ApplicationService s;
    @PostMapping("/app")
    public String poster(@RequestBody List<ApplicatioDTO> c) {
        return s.adduser(c);
    }

    @GetMapping("/app")
    public Page<Application> get(@RequestParam int pageNo,
                                 @RequestParam int pageSize) {
        return s.get(pageNo, pageSize);
    }

    @GetMapping("/app/{id}")
    public ResponseEntity<Application> getuid(@PathVariable("id") long id) {
        Optional<Application> company = s.idget(id);

        if(company.isPresent()) {
            return ResponseEntity.ok(company.get());
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(404));
    }

    @DeleteMapping("/app/{id}")
    public String delete(@PathVariable("id") long d) {
        return s.deleteid(d);
    }

    @PutMapping("app/{id}")
    public ResponseEntity<Application> putadd(@PathVariable long id,@RequestBody Application Dto){
        try{
            Application application=s.applicationedit(id,Dto);
            return ResponseEntity.ok(application);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));

        }

    }

    @PostMapping("/file")
    public ResponseEntity<String> uploadFile(@ModelAttribute ApplicatioDTO applicationDTO) throws IOException {
        s.uploadFile(applicationDTO);
        return ResponseEntity.ok("SUCCESS");
    }

}
