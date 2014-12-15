package com.dmma.askfm.db.daos;

import org.slf4j.LoggerFactory;

import com.dmma.askfm.db.entities.Question;

public class QuestionDAO extends BaseDAO<Question, Integer> {

	// --- Methods ---
	public QuestionDAO() {
		super(Question.class, LoggerFactory.getLogger(QuestionDAO.class));
	}


}