package com.dmma.askfm.db.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;

import com.dmma.askfm.db.entities.Question;

public class QuestionDAO extends BaseDAO<Question, Long> {

	// --- Methods ---
	public QuestionDAO() {
		super(Question.class, LoggerFactory.getLogger(QuestionDAO.class));
	}

	@SuppressWarnings("unchecked")
	public List<Question> findByCountryCode(String countryCode) {
		log.debug("findByCountryCode = "+ countryCode); 
		
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery("from Question where countryCode = ?");
			query.setString(0, countryCode);
			return query.list();
		}finally{
			session.close();
		}
	}
	
	
}