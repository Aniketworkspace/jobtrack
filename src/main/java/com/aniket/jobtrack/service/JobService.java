package com.aniket.jobtrack.service;

import com.aniket.jobtrack.dto.JobRequestDto;
import com.aniket.jobtrack.dto.JobResponseDto;
import com.aniket.jobtrack.entity.Job;
import com.aniket.jobtrack.exception.JobNotFoundException;
import com.aniket.jobtrack.repository.JobRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobResponseDto saveJob(JobRequestDto request) {
        Job job = new Job();
        job.setCompanyName(request.getCompanyName());
        job.setJobTitle(request.getJobTitle());
        job.setLocation(request.getLocation());
        job.setSalary(request.getSalary());
        job.setStatus(request.getStatus());

        Job savedJob = jobRepository.save(job);
        JobResponseDto response = new JobResponseDto();

        response.setJobId((savedJob.getJobId()));
        response.setCompanyName(savedJob.getCompanyName());
        response.setJobTitle(savedJob.getJobTitle());
        response.setLocation(savedJob.getLocation());
        response.setSalary(savedJob.getSalary());
        response.setStatus(savedJob.getStatus());

        return response;
    }

    public Page<JobResponseDto> getAllJobs(Pageable pageable) {
        return jobRepository.findAll(pageable).map(job -> {

            JobResponseDto response = new JobResponseDto();
            response.setJobId(job.getJobId());
            response.setCompanyName(job.getCompanyName());
            response.setJobTitle(job.getJobTitle());
            response.setLocation(job.getLocation());
            response.setSalary(job.getSalary());
            response.setStatus(job.getStatus());
            return response;

        });
    }

    public JobResponseDto getJobById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException("job with id " + id + " not found"));
        JobResponseDto response = new JobResponseDto();
        response.setJobId(job.getJobId());
        response.setCompanyName(job.getCompanyName());
        response.setJobTitle(job.getJobTitle());
        response.setLocation(job.getLocation());
        response.setSalary(job.getSalary());
        response.setStatus(job.getStatus());

        return response;
    }

    public void deleteById(Long id) {
         jobRepository.findById(id).orElseThrow(()-> new JobNotFoundException("job with id " + id + " not found"));

         jobRepository.deleteById(id);
    }
}


