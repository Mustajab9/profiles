package com.lawencon.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.test.dto.GetAllProfileDtoRes;
import com.lawencon.test.dto.GetByProfileIdDtoRes;
import com.lawencon.test.dto.InsertProfileDtoReq;
import com.lawencon.test.dto.InsertProfileDtoRes;
import com.lawencon.test.service.ProfileService;

@RestController
@RequestMapping("profiles")
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@GetMapping
	public ResponseEntity<GetAllProfileDtoRes> getAll() throws Exception {
		GetAllProfileDtoRes getAll = profileService.getAll();
		return new ResponseEntity<GetAllProfileDtoRes>(getAll, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<GetByProfileIdDtoRes> getById(@PathVariable Long id) throws Exception {
		GetByProfileIdDtoRes getById = profileService.getById(id);
		return new ResponseEntity<GetByProfileIdDtoRes>(getById, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<InsertProfileDtoRes> insert(@RequestBody @Valid InsertProfileDtoReq data) throws Exception {
		InsertProfileDtoRes insert = profileService.insert(data);
		return new ResponseEntity<InsertProfileDtoRes>(insert, HttpStatus.CREATED);
	}
}
