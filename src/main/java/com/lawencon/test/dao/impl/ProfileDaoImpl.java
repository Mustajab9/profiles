package com.lawencon.test.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lawencon.test.dao.ProfileDao;
import com.lawencon.test.model.Profile;

@Repository
public class ProfileDaoImpl implements ProfileDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Profile> findAll() throws Exception {
		List<Profile> data = em.createQuery("FROM Profile", Profile.class).getResultList();
		return data;
	}
	
	@Override
	public Profile findById(Long id) throws Exception {
		Profile data = em.find(Profile.class, id);
		return data;
	}
	
	@Override
	public Profile saveInsert(Profile data) throws Exception {
		em.persist(data);
		return data;
	}
	
	@Override
	public Profile saveUpdate(Profile data) throws Exception {
		Profile dataMerge = em.merge(data);
		em.flush();
		return dataMerge;
	}
	
	@Override
	public void deleteById(Long id) throws Exception {
		Profile removeEntity = em.find(Profile.class, id);
		em.remove(removeEntity);
		
	}
}
