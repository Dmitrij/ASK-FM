package com.dmma.askfm.core.services;

import org.junit.Assert;
import org.junit.Test;

public class ProfanityAppServiceTest {

	private ProfanityAppService profanityAppService;
	
	public ProfanityAppServiceTest() {
		profanityAppService = new ProfanityAppServiceImpl();
	}
	
	@Test
	public void testGoodWords(){
		Assert.assertTrue(profanityAppService.validateText("Hello!"));
	}
	
	@Test
	public void testBadWords(){
		Assert.assertFalse(profanityAppService.validateText("bad!"));
		Assert.assertFalse(profanityAppService.validateText("This sentance contain 'bad' word!"));
	}
	
}
