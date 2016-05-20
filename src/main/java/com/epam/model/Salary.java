package com.epam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`salary`")
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="sum")
	private String sum;
	
	public Salary(){}

	public Salary(Salary salary) {
		this.id = salary.id;
		this.sum = salary.sum;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}
	
	@Override
	public String toString() {
		return "Salary [id=" + id + ", sum=" + sum + "]";
	}
	
}
