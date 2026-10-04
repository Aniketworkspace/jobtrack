package com.aniket.jobtrack.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicationRequestDto {
    private Long jobId;

    private LocalDate appliedDate;

    private String status;
    
    private String notes;
}
