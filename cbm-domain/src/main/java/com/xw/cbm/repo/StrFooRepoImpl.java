package com.xw.cbm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xw.cbm.entity.StrFoo;

@Transactional
@Repository
public class StrFooRepoImpl implements StrFooRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<StrFoo> findAll() {
		String hql = "FROM StrFoo as str ORDER BY str.name";
		return (List<StrFoo>) this.entityManager.createQuery(hql).getResultList();
	}

	@Override
	public StrFoo findById(String id) {
		return this.entityManager.find(StrFoo.class, id);
	}

	@Override
	public void save(StrFoo u) {
		this.entityManager.persist(u);
	}

	@Override
	public StrFoo findUserByName(String name) {
		String hql = "FROM StrFoo as test WHERE test.name like :myName ";
		Query query = this.entityManager.createQuery(hql);
		query.setParameter("myName", name);
		@SuppressWarnings("unchecked")
		List<StrFoo> list = query.getResultList();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public boolean strFooExit(String name) {
		String hql = "FROM StrFoo as test WHERE test.name = :myName ";
		Query query = this.entityManager.createQuery(hql);
		query.setParameter("myName", name);
		StrFoo strFoo = (StrFoo) query.getSingleResult();
		if (strFoo != null) {
			return true;
		}
		return false;
	}
}
