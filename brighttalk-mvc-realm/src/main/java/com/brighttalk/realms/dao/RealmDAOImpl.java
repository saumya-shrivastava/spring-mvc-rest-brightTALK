package com.brighttalk.realms.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brighttalk.realms.model.Realm;

@Repository
public class RealmDAOImpl implements RealmDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Realm save(Realm realm) {
		System.out.println("REalmDAOIMpl saverealm "+realm);
		sessionFactory.getCurrentSession().save(realm);
		System.out.println("REalmDAOIMpl saverealm 2"+realm);
		return realm;
	}

	@Override
	public Realm get(Long id) {
		return sessionFactory.getCurrentSession().get(Realm.class, id);
	}

	@Override
	public List<Realm> findByName(String name_inReq) {
		/*
		 * Realm realm = (Realm) this.sessionFactory.getCurrentSession()
		 * .createQuery("SELECT  realm_id,realm_name,description,realm_key FROM Realm WHERE realm_name = :req_name"
		 * ) .setParameter("req_name", name_inReq);
		 */
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Realm> query = builder.createQuery(Realm.class);
        Root<Realm> root = query.from(Realm.class);
        query.select(root).where(builder.equal(root.get("name"),name_inReq ));
        Query<Realm> q=sessionFactory.getCurrentSession().createQuery(query);
        List<Realm> retrievedRealmList=q.getResultList();
        System.out.println("size in RealmDAO IMPL "+retrievedRealmList);
		return retrievedRealmList;

	}

}
