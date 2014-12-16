package com.dmma.askfm.core.services;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;


public class ProfanityAppServiceImpl implements ProfanityAppService{
	private final static Logger LOG = LoggerFactory.getLogger(ProfanityAppServiceImpl.class);
	private final Set<String> badWords;
	
	public ProfanityAppServiceImpl() {
		badWords = new HashSet<String>();
		try {
			File file = new DefaultResourceLoader().getResource("classpath:profanityFilter.properties").getFile();
			@SuppressWarnings("unchecked")
			List<String> lines = FileUtils.readLines(file, "UTF-8");
			if(lines != null && !lines.isEmpty()){
				for(String l : lines){
					if(l != null && !l.trim().isEmpty()){
						badWords.add(l.trim());
					}
				}
			}
		} catch (IOException e) {
			LOG.error("Can't instatntiate bad word list", e);
		}
		
	}
	
	@Override
	public Boolean validateText(String text){
		LOG.debug("Checking some text:" + text);
		String onlyText = text.replaceAll("[^A-Za-z0-9]", " ");
		String[] wordArr = onlyText.split(" ");
		for(int i = 0; i < wordArr.length; i++){
			if(wordArr[i].length() > 1){
				if(badWords.contains(wordArr[i])){
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	
}
