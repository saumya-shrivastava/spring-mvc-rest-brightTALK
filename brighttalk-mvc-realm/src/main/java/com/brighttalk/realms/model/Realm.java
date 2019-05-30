package com.brighttalk.realms.model;


	

	import java.util.Optional;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;
	

	@Entity
	@Table(name="user_realm")
	public class Realm {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "realm_id")
		private Long id;
		
		@Column(name = "realm_name")
		private String name;
		@Column(name = "realm_description")
		private String description;
		@Column(name = "realm_key")
		private String key;
		
		public Realm() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Realm(Long id, String name, String description, String key) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.key = key;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			//return name;
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		@Override
		public String toString() {
			return "name = "+this.name+" description = "+this.description
					+" key = "+key+" id = "+this.id;
		}
	}


