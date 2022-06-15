package com.lawencon.test.dao;

import java.util.List;

import com.lawencon.test.model.Profile;

public interface ProfileDao {
	List<Profile> findAll() throws Exception;

	Profile findById(Long id) throws Exception;

	Profile saveInsert(Profile data) throws Exception;

	Profile saveUpdate(Profile data) throws Exception;

	void deleteById(Long id) throws Exception;
}
