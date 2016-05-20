package com.epam.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="`job`")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="enabled")
	private Boolean enabled;
	
	@Column(name="description")
	private String description;
	
	@Column(name="owner_id")
	private Long owner_id;
	
	@Column(name="category_id")
	private Long category_id;
	
	@Column(name="date_start")
	private Timestamp date_start;
	
	@Column(name="date_end")
	private Timestamp date_end;
	
	@Column(name="emails")
	private String emails;
	
	@Column(name="country_id")
	private Long country_id;
	
	@Column(name="city_id")
	private Long city_id;

	@Column(name="salary_id")
	private Byte salary_id;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name="job_applicant",
        joinColumns=@JoinColumn(name="job_id", referencedColumnName="id"),
        inverseJoinColumns=@JoinColumn(name="applicant_id", referencedColumnName="id"))
    private List<User> applicants;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", insertable =  false, updatable = false)
	private User owner;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "salary_id", insertable =  false, updatable = false)
	private Salary salary;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", insertable =  false, updatable = false)
    private Country country;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="city_id", insertable =  false, updatable = false)
	 private City city;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", insertable =  false, updatable = false)
    private Category category;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="subcategory_id")
	 private Subcategory subcategory;
	
	

	public List<User> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<User> applicants) {
		this.applicants = applicants;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public Timestamp getDate_start() {
		return date_start;
	}

	public void setDate_start(Timestamp date_start) {
		this.date_start = date_start;
	}

	public Timestamp getDate_end() {
		return date_end;
	}

	public void setDate_end(Timestamp date_end) {
		this.date_end = date_end;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public Long getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Long country_id) {
		this.country_id = country_id;
	}

	public Long getCity_id() {
		return city_id;
	}

	public void setCity_id(Long city_id) {
		this.city_id = city_id;
	}

	public Byte getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(Byte salary_id) {
		this.salary_id = salary_id;
	}
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", enabled=" + enabled + ", description=" + description
				+ ", owner_id=" + owner_id + ", category_id=" + category_id + ", date_start=" + date_start
				+ ", date_end=" + date_end + ", emails=" + emails + ", country_id=" + country_id + ", city_id="
				+ city_id + ", salary_id=" + salary_id + "]";
	}
	
}
