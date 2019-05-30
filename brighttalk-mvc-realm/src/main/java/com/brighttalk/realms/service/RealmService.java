package com.brighttalk.realms.service;

import java.util.List;
import java.util.Optional;

import com.brighttalk.realms.model.Realm;

public interface RealmService {

		Realm get(Long id);
		Realm save(Realm realm);
		List<Realm> findByName(String name);


}
