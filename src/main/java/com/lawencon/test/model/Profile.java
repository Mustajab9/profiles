package com.lawencon.test.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {
	@Id
	private Long id;
	
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;
	
	@Column(name = "address")
	private Float address;
	
	@Column(name = "birth_day")
	private LocalDate birthDay;
	
	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;
	
	@Column(name = "city", length = 45)
	private String city;

	@Column(name = "country", length = 45)
	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Float getAddress() {
		return address;
	}

	public void setAddress(Float address) {
		this.address = address;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
