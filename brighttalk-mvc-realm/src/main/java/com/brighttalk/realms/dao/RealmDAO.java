package com.brighttalk.realms.dao;

import java.util.List;
import java.util.Optional;

import com.brighttalk.realms.model.Realm;



public interface RealmDAO {

	   Realm save(Realm realm);
	   Realm get(Long id);
	   List<Realm> findByName(String name);
}
