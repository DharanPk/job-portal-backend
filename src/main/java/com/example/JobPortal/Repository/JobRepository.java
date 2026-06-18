package com.example.JobPortal.Repository;

import com.example.JobPortal.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
}
