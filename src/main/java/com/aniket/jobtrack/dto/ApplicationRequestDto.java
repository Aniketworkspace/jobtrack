package com.aniket.jobtrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicationRequestDto {
    @NotNull
    private Long jobId;
    @NotNull
    private LocalDate appliedDate;
    @NotBlank
    private String status;

    private String notes;
}
