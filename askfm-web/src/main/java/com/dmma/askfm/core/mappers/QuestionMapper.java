package com.dmma.askfm.core.mappers;

import java.util.ArrayList;
import java.util.List;

import com.dmma.askfm.db.entities.Question;
import com.dmma.askfm.dto.shared.dtos.QuestionDTO;

/**
 * 
 * 
 * @author <a href="mailto:dmitrijs.marcenkovs@gmail.com">Dmitrijs Marcenkovs</a>
 */
public class QuestionMapper{ 

	public static QuestionDTO toDTO(Question source){
		if(source == null) 
			return null;
		QuestionDTO target = new QuestionDTO();
		target.setId(source.getId());
		target.setQuestionText(source.getQuestionText());
		target.setCountryCode(source.getCountryCode());
		target.setAccepted(source.getAccepted());
		target.setCreated(source.getCreated());
		
		return target;
	}

	public static ArrayList<QuestionDTO> toDTOs(List<Question> entities){
		if(entities == null) 
			return null;
		ArrayList<QuestionDTO> retVal = new ArrayList<QuestionDTO>(entities.size());
		for(Question entity:entities){
			retVal.add(toDTO(entity));
		}
		return retVal;
	}
	
	public static Question toEntity(QuestionDTO source, Question target){
		if(target==null){
			target = new Question();
		}
		target.setId(source.getId());
		target.setQuestionText(source.getQuestionText());
		target.setCountryCode(source.getCountryCode());
		target.setAccepted(source.getAccepted());
		target.setCreated(source.getCreated());
		return target;
	}
}
