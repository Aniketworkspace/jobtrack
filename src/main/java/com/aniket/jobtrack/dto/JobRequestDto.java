package com.aniket.jobtrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class JobRequestDto {

    @NotBlank
    private String companyName;
    @NotBlank
    private String jobTitle;
    private String location;
    @Positive
    private double salary;
    private String status;
}
