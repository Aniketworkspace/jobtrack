package com.aniket.jobtrack.controller;

import com.aniket.jobtrack.dto.ApplicationRequestDto;
import com.aniket.jobtrack.dto.ApplicationResponseDto;
import com.aniket.jobtrack.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
