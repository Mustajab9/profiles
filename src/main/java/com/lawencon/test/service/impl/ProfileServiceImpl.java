package com.lawencon.test.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.test.dao.ProfileDao;
import com.lawencon.test.dto.GetAllProfileDtoDataRes;
import com.lawencon.test.dto.GetAllProfileDtoRes;
import com.lawencon.test.dto.GetByProfileIdDtoDataRes;
import com.lawencon.test.dto.GetByProfileIdDtoRes;
import com.lawencon.test.dto.InsertProfileDtoDataRes;
import com.lawencon.test.dto.InsertProfileDtoReq;
import com.lawencon.test.dto.InsertProfileDtoRes;
import com.lawencon.test.model.Profile;
import com.lawencon.test.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;

	@Override
	public GetAllProfileDtoRes getAll() throws Exception {
		GetAllProfileDtoRes getAll = new GetAllProfileDtoRes();
		
		List<Profile> profiles = profileDao.findAll();
		List<GetAllProfileDtoDataRes> listProfile = new ArrayList<>();
		
		int length = profiles.size();
		for(int i = 0; i < length; i++) {
			Profile profile = profiles.get(i);
			GetAllProfileDtoDataRes data = new GetAllProfileDtoDataRes();
			
			data.setId(profile.getId());
			data.setFirstName(profile.getFirstName());
			
			if(profile.getLastName() != null) {
				data.setLastName(profile.getLastName());
			}
			
			if(profile.getAddress() != null) {
				data.setAddress(profile.getAddress());
			}
			
			if(profile.getBirthDay() != null) {
				data.setBirthDay(profile.getBirthDay());
			}
			
			data.setEmail(profile.getEmail());
			
			if(profile.getCity() != null) {
				data.setCity(profile.getCity());
			}
			
			if(profile.getCountry() != null) {
				data.setCountry(profile.getCountry());
			}
			
			listProfile.add(data);
		}
		
		getAll.setData(listProfile);
		getAll.setMsg(null);
		
		return getAll;
	}

	@Override
	public GetByProfileIdDtoRes getById(Long id) throws Exception {
		GetByProfileIdDtoRes getById = new GetByProfileIdDtoRes();
		
		Profile profile = profileDao.findById(id);
		
		if(profile == null) {
			throw new Exception("Profile with Id " + id + " Not Found");
		}
		
		GetByProfileIdDtoDataRes data = new GetByProfileIdDtoDataRes();
		
		data.setId(profile.getId());
		data.setFirstName(profile.getFirstName());
		
		if(profile.getLastName() != null) {
			data.setLastName(profile.getLastName());
		}
		
		if(profile.getAddress() != null) {
			data.setAddress(profile.getAddress());
		}
		
		if(profile.getBirthDay() != null) {
			data.setBirthDay(profile.getBirthDay());
		}
		
		data.setEmail(profile.getEmail());
		
		if(profile.getCity() != null) {
			data.setCity(profile.getCity());
		}
		
		if(profile.getCountry() != null) {
			data.setCountry(profile.getCountry());
		}
		
		getById.setData(data);
		getById.setMsg(null);
		
		return getById;
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public InsertProfileDtoRes insert(InsertProfileDtoReq data) throws Exception {
		InsertProfileDtoRes response = new InsertProfileDtoRes();
		
		Profile profile = new Profile();
		
		profile.setId(data.getId());
		profile.setFirstName(data.getFirstName());
		
		if(data.getLastName() != null) {
			profile.setLastName(data.getLastName());
		}
		
		if(data.getAddress() != null) {
			profile.setAddress(data.getAddress());
		}
		
		if(data.getBirthDay() != null) {
			profile.setBirthDay(convertDateToLocalDate(data.getBirthDay()));
		}
		
		profile.setEmail(data.getEmail());
		
		if(data.getCity() != null) {
			profile.setCity(data.getCity());
		}
		
		if(data.getCountry() != null) {
			profile.setCountry(data.getCountry());
		}
		
		Profile profileInsert = profileDao.saveInsert(profile);
		
		InsertProfileDtoDataRes dataRes = new InsertProfileDtoDataRes();
		dataRes.setId(profileInsert.getId());
		
		response.setData(dataRes);
		response.setMsg("Insert Success");
		
		return response;
	}
	
	private LocalDate convertDateToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
