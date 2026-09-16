package com.aniket.jobtrack.repository;

import com.aniket.jobtrack.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {

//       Page<Job> findByCompanyName(String companyName, Pageable pageable);
//
//       Page<Job> findByJobTitle(String jobTitle, Pageable pageable);
//
//       Page<Job> findByStatus(String status, Pageable pageable);
}
