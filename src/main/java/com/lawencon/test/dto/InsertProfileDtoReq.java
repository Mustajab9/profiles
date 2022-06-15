package com.lawencon.test.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InsertProfileDtoReq {
	@NotNull(message = "ID is Null")
	private Long id;

	@NotEmpty(message = "First Name Is Empty")
	@Size(max = 50, message = "First Name Max 50 Character")
	private String firstName;

	@Size(max = 50, message = "Last Name Max 50 Character")
	private String lastName;
	private Float address;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDay;

	@NotEmpty(message = "Email Is Empty")
	@Size(max = 100, message = "Email Max 100 Character")
	private String email;

	@Size(max = 45, message = "City Max 45 Character")
	private String city;

	@Size(max = 45, message = "Country Max 45 Character")
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

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
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
