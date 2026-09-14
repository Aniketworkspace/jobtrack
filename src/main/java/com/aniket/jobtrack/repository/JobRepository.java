package com.aniket.jobtrack.repository;

import com.aniket.jobtrack.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
