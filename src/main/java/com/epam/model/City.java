package com.epam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="`city`")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="country_id")
	private Long country_id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="country_id", insertable =  false, updatable = false)
	private Country country;

	public City(){}
	
	public City(City city) {
		this.id = city.id;
		this.name = city.name;
		this.country_id = city.country_id;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Long country_id) {
		this.country_id = country_id;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", country_id=" + country_id + ", country=" + country + "]";
	}
	
}
