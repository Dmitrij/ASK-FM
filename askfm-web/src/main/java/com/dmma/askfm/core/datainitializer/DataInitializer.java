package com.dmma.askfm.core.datainitializer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.askfm.core.configuration.AppProperties;
import com.dmma.askfm.db.daos.QuestionDAO;
import com.dmma.askfm.db.entities.Question;

public class DataInitializer {
	private final static Logger LOG = LoggerFactory.getLogger(DataInitializer.class);

	private QuestionDAO questionDAO;

	public DataInitializer() {
		LOG.info("Starting DataInitializer");
	}

	/** 
	 * Checking admin account
	 */
	private void checkDemoQuestions() {
		LOG.info("Checking presetted demo questions ... ");
		if(questionDAO == null){
			LOG.error("questionDAO is null");
			return;
		}
		List<Question> all = questionDAO.findAll();
		
		if(all != null && !all.isEmpty()){
			LOG.info("no need to insert demo questions");
			return;
		}
		
		for(int i = 0; i < 10 ; i ++ ){
			Question entity = genarate(i);
			questionDAO.saveOrUpdate(entity);
		}
		
		LOG.info("DataInitializer success!");
	}


	private Question genarate(int i) {
		Question entity = new Question();
		entity.setAccepted(true);
		entity.setCountryCode(i%2==0?"lv":"be");
		entity.setQuestionText("Question Text "+(i+1));
		return entity;
	}

	// --- Spring Setters ---
	public void setReady(Boolean ready) {
		if(AppProperties.useDataInitializer){
			checkDemoQuestions();
		}
	}

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}
	
}
