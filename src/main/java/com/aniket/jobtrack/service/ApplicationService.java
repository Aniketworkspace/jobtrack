package com.aniket.jobtrack.service;

import com.aniket.jobtrack.dto.ApplicationRequestDto;
import com.aniket.jobtrack.dto.ApplicationResponseDto;
import com.aniket.jobtrack.entity.Application;
import com.aniket.jobtrack.entity.Job;
import com.aniket.jobtrack.repository.ApplicationRepository;
import com.aniket.jobtrack.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final JobRepository jobRepository;

    public ApplicationService(JobRepository jobRepository, ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
        this.jobRepository = jobRepository;
    }

    public ApplicationResponseDto saveApplication(ApplicationRequestDto request){

    Job job = jobRepository.findById(request.getJobId()).orElseThrow(()->
            new RuntimeException("Job not found"));
    Application application = new Application();

    application.setAppliedDate(request.getAppliedDate());
    application.setStatus(request.getStatus());
    application.setNotes(request.getNotes());
    application.setAppliedDate(request.getAppliedDate());
    application.setJob(job);

    Application savedApplication = applicationRepository.save(application);

    ApplicationResponseDto response = new ApplicationResponseDto();

    response.setApplicationId(savedApplication.getApplicationId());
    response.setJobId(savedApplication.getJob().getJobId());
    response.setStatus(savedApplication.getStatus());
    response.setNotes(savedApplication.getNotes());
    response.setAppliedDate(savedApplication.getAppliedDate());
    return response;
    }
}
