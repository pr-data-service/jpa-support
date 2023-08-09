package com.jpasupport.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DBQueryExecuter {

	@PersistenceContext
	private EntityManager entityManager;
	
	public <T> List<T> executeQuery(QueryMaker<T> queryMaker) {
		
		Query query = entityManager.createQuery(queryMaker.getQuery());
		queryMaker.setParams(query);
		List<?> queryRows = query.getResultList();
		
		List<T> list = queryMaker.convertData(queryRows);
		
		
		return list;		
	}
	
	
	
	
	
	
	
	
}
