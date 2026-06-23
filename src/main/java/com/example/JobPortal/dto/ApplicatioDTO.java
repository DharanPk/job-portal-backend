package com.example.JobPortal.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ApplicatioDTO {
    private long user_id;
    private String status;
    private  long job_id;
    private long app_id;
    private MultipartFile file;
}
