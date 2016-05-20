package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.model.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
	
}
