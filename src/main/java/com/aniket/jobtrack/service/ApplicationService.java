package com.aniket.jobtrack.service;

import com.aniket.jobtrack.dto.ApplicationRequestDto;
import com.aniket.jobtrack.dto.ApplicationResponseDto;
import com.aniket.jobtrack.entity.Application;
import com.aniket.jobtrack.entity.Job;
import com.aniket.jobtrack.repository.ApplicationRepository;
import com.aniket.jobtrack.exception.JobNotFoundException;
import com.aniket.jobtrack.repository.JobRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            new JobNotFoundException("Job with id " + request.getJobId() + " not found"));
    Application application = new Application();

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

    public Page<ApplicationResponseDto>getAllAplications(Pageable pageable){
        Page<Application> applications =
    applicationRepository.findAll(pageable);

        return applications.map(application -> {
          ApplicationResponseDto response =  new ApplicationResponseDto();

          response.setApplicationId(application.getApplicationId());
          response.setJobId(application.getJob().getJobId());
          response.setAppliedDate(application.getAppliedDate());
          response.setStatus(application.getStatus());
          response.setNotes(application.getNotes());

          return response;
        });
    }
}
