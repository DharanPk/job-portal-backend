package com.example.JobPortal.Service;

import com.example.JobPortal.Model.Company;
import com.example.JobPortal.Model.Job;
import com.example.JobPortal.Repository.CompanyRepository;
import com.example.JobPortal.Repository.JobRepository;
import com.example.JobPortal.dto.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository repo;

    public String adduser(List<JobDTO> DTO) {
        List<Job> j=DTO.stream().map((dto)->{
            Job job=new Job();
            job.setTitle(dto.getTitle());
            job.setSalary(dto.getSalary());
            job.setDescription(dto.getDescription());
            Company company=new Company();
            company.setId(dto.getCompany_id());
            job.setCompany(company);
            return job;
        }).toList();

        repo.saveAll(j);
        return "add...";
    }

    public List<Job> get() {
        return repo.findAll();
    }

    public Optional<Job> idget(long id) {
        return repo.findById(id);
    }

    public String deleteid(long d) {
        repo.deleteById(d);
        return "Delted ...";

    }
}
