package com.epam.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="`country`")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="iso2")
	private String iso2;
	
	@Column(name="name")
	private String name;
	
	@Column(name="long_country_name")
	private String long_country_name;
	
	@Column(name="iso3")
	private String iso3;

	@OneToMany(mappedBy="country")
    @OrderBy("name ASC")
	private List<City> cities;
	
	public Country(){}

    public Country(Country country) {
        this.id = country.id;
        this.iso2 = country.iso2;
        this.name = country.name;
        this.long_country_name = country.long_country_name;
        this.iso3 = country.iso3;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLong_country_name() {
		return long_country_name;
	}

	public void setLong_country_name(String long_country_name) {
		this.long_country_name = long_country_name;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}
	
	@Override
	public String toString() {
		return "Country [id=" + id + ", iso2=" + iso2 + ", name=" + name + ", long_country_name=" + long_country_name
				+ ", iso3=" + iso3 + ", cityes=" + cities + "]";
	}

	public List<City> getCities() {
		return cities;
	}

	public void addCity(City city) {
		 if (!getCities().contains(city)) {
			 getCities().add(city);
            if (city.getCountry() != null) {
            	city.getCountry().getCities().remove(city);
            }
            city.setCountry(this);
        }
	}
	
}
