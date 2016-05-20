package com.epam.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="`job_applicant`")
public class JobApplicant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	@Column(name="job_id", insertable =  false, updatable = false)
	private Long job_id;
	
	@Column(name="applicant_id")
	private Long applicant_id;
	
	@OneToMany
	private List<User> applicants;
	
	@OneToOne
	private Job job;
	
	public JobApplicant(){}
	
	public JobApplicant(JobApplicant jobApplicant) {
		this.job_id = jobApplicant.job_id;
		this.applicant_id = jobApplicant.applicant_id;
	}

	public Long getJob_id() {
		return job_id;
	}

	public void setJob_id(Long job_id) {
		this.job_id = job_id;
	}

	public Long getApplicant_id() {
		return applicant_id;
	}

	public void setApplicant_id(Long applicant_id) {
		this.applicant_id = applicant_id;
	}
	
	public List<User> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<User> applicants) {
		this.applicants = applicants;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
