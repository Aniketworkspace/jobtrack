package com.aniket.jobtrack.controller;

import com.aniket.jobtrack.dto.JobRequestDto;
import com.aniket.jobtrack.dto.JobResponseDto;
import com.aniket.jobtrack.service.JobService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService service;

    public JobController(JobService service){
        this.service=service;

    }
    @PostMapping
    public JobResponseDto createJob(@RequestBody @Valid JobRequestDto request){
        return service.saveJob(request);
    }
    @GetMapping
    public Page<JobResponseDto> getAlljobs(@PageableDefault(size = 5, sort = "jobId") Pageable pageable){
        return service.getAllJobs(pageable);
    }
     @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id){
        service.deleteById(id);
    }
    @GetMapping("/{id}")
    public JobResponseDto getJobById(@PathVariable Long id){
        return service.getJobById(id);
    }
}
