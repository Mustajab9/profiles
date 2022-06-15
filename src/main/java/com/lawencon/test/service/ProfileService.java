package com.lawencon.test.service;

import com.lawencon.test.dto.GetAllProfileDtoRes;
import com.lawencon.test.dto.GetByProfileIdDtoRes;
import com.lawencon.test.dto.InsertProfileDtoReq;
import com.lawencon.test.dto.InsertProfileDtoRes;

public interface ProfileService {
	GetAllProfileDtoRes getAll() throws Exception;

	GetByProfileIdDtoRes getById(Long id) throws Exception;

	InsertProfileDtoRes insert(InsertProfileDtoReq data) throws Exception;
}
