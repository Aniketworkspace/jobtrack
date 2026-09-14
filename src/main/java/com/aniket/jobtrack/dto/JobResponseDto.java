package com.aniket.jobtrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class JobResponseDto {
    private Long jobId;
    private String companyName;
    private String jobTitle;
    private String location;
    private double salary;
    private String status;

}
