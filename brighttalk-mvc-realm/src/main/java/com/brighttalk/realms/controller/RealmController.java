package com.brighttalk.realms.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brighttalk.realms.exception.InvalidArgumentException;
import com.brighttalk.realms.exception.RealmNameException;
import com.brighttalk.realms.exception.RealmNotFoundException;
import com.brighttalk.realms.model.Realm;
import com.brighttalk.realms.service.RealmService;

@RestController
public class RealmController {
	
	@Autowired
	private RealmService realmService;
	
	@GetMapping("/realms/{id}")
	public ResponseEntity<Object> retrieveRealm(@PathVariable String id) throws RealmNotFoundException, InvalidArgumentException {
		Long longId ;
		try {
			 longId = Long.parseLong(id);
		}
		catch(NumberFormatException e) {
			throw new InvalidArgumentException("InvalidArgument");
		}
	Realm realm =  realmService.get(longId);
	if(realm== null || realm.getName().isEmpty()) {
		throw new RealmNotFoundException("RealmNotFound");
	}
		return ResponseEntity.ok().body(realm);
	}
	
	@PostMapping("/realms")
	public ResponseEntity<Object> createRealm( @RequestBody Realm realm) throws RealmNameException{
		if(realm.getName()== null || realm.getName().isEmpty()) {
			throw new RealmNameException("InvalidRealmName");
		}
		
		List<Realm> realmretrievedList = realmService.findByName(realm.getName());
		if(realmretrievedList != null && realmretrievedList.size()!=0) {
			throw new RealmNameException("DuplicateRealmName");
		}

		Realm savedrealm =realmService.save(realm);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}").buildAndExpand(savedrealm.getId()).toUri();
		return ResponseEntity.created(location).body(savedrealm);
	}
}
