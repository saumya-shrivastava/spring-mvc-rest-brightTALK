package com.brighttalk.realms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brighttalk.realms.dao.RealmDAO;
import com.brighttalk.realms.model.Realm;

@Service
@Transactional

public class RealmServiceImpl implements RealmService{

	@Autowired
	private RealmDAO realmDAO;
	
	@Override
	@Transactional
	public Realm get(Long id) {
		return realmDAO.get(id);
	}

	@Transactional
	@Override
	public Realm save(Realm realm) {
		return realmDAO.save(realm);
	}

	@Override
	@Transactional
	public List<Realm> findByName(String name) {
		return realmDAO.findByName(name);
	}
	
	

}
