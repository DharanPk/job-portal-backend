package com.example.JobPortal.Service;

import com.example.JobPortal.Model.Application;
import com.example.JobPortal.Model.Company;
import com.example.JobPortal.Model.Job;
import com.example.JobPortal.Model.User;
import com.example.JobPortal.Repository.ApplicationRepository;
import com.example.JobPortal.Repository.CompanyRepository;
import com.example.JobPortal.Repository.JobRepository;
import com.example.JobPortal.Repository.UserRepository;
import com.example.JobPortal.dto.ApplicatioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository repo;

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private UserRepository userRepo;

    public String adduser(List<ApplicatioDTO> dto) {

        List<Application> applications = dto.stream().map( app -> {
            Application application = new Application();
            Job job = jobRepo.findById(app.getJob_id()).get();
            application.setJob(job);
            User user = userRepo.findById(app.getUser_id()).get();
            application.setUser(user);
            application.setStatus(app.getStatus());
            return application;
        }).toList();

        repo.saveAll(applications);
        return "add...";
    }

    public Page<Application> get(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return repo.findAll(pageable);
    }

    public Optional<Application> idget(long id) {
        return repo.findById(id);
    }

    public String deleteid(long d) {
        repo.deleteById(d);
        return "Delted ...";

    }

    public Application applicationedit(long id, Application dto) {
        Application application=repo.findById(id).orElseThrow(()->new RuntimeException("Not found"));
        application.setStatus(dto.getStatus());
        return repo.save(application);

    }

    public void uploadFile(ApplicatioDTO applicationDTO) throws IOException {
        System.out.println(applicationDTO.getFile().getName());

        saveFile(applicationDTO.getFile());
    }

    public void saveFile(MultipartFile file) throws IOException {

        String uploadDir = "D:\\java\\JobPortal\\Uploads/";

        Path path = Paths.get(uploadDir + file.getOriginalFilename());

        Files.write(path, file.getBytes());

        System.out.println("File saved successfully");
    }
}
