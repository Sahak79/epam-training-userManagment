package com.epam.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.model.Job;
import com.epam.repository.JobRepository;

@Controller
public class JobsController {
	
	private static final Logger logger = LogManager.getLogger(JobsController.class);
	
	@Autowired
    private JobRepository jobRepository;
	
	
    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public String login(Model model) {
    	
    	
    	// fetch all jobs list
    	List<Job> jobs = jobRepository.findAll();
    	
    	logger.trace("This is trace log.");
		logger.debug("This is debug log.");
		logger.info("This is info log.");
		logger.warn("This is warn log.");
		logger.error("This is error log.");
		
    	
    	logger.info(jobs.toString());
    	
    	model.addAttribute("classActiveJobs", "active");
    	model.addAttribute("jobs", jobs);
    	
        return "pages/jobs/jobs";
    }
}
