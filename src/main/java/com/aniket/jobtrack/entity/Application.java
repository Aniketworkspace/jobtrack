package com.aniket.jobtrack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "applications")
@Data
public class Application {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long applicationId;
private LocalDate appliedDate;
private String status;

private String notes;
@ManyToOne
@JoinColumn(name = "job_Id")
private Job job;

}
