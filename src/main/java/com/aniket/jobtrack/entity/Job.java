package com.aniket.jobtrack.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "jobs")
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    @Column(nullable = false)
    private String companyName;
    @Column(name = "job_title")
    private String jobTitle;
    private String location;
    private double salary;
    private String status;
}
