package com.aniket.jobtrack.repository;

import com.aniket.jobtrack.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
