package com.aniket.jobtrack.controller;

import com.aniket.jobtrack.dto.ApplicationRequestDto;
import com.aniket.jobtrack.dto.ApplicationResponseDto;
import com.aniket.jobtrack.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
public class ApplicationController{
    private final ApplicationService applicationService;

    ApplicationController(ApplicationService applicationService){
        this.applicationService=applicationService;
    }
    @PostMapping
    public ResponseEntity<ApplicationResponseDto> createApplication(@RequestBody @Valid  ApplicationRequestDto request){
        ApplicationResponseDto responseDto = applicationService.saveApplication(request);

        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
     @GetMapping
    public Page<ApplicationResponseDto> getAllApplications(@PageableDefault(size = 5, sort = "applicationId")
                                                           Pageable pageable){
        return applicationService.getAllAplications(pageable);
    }
    @GetMapping("/{id}")
    public ApplicationResponseDto getApplicationById(@PathVariable Long id){
        return applicationService.getApplicationById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id){
         applicationService.deleteApplication(id);

         return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ApplicationResponseDto updateApplication(@PathVariable Long id, @RequestBody @Valid ApplicationRequestDto request){
        return applicationService.updateApplication(id, request);
    }
}
