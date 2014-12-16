package com.dmma.askfm.core.services;

import org.junit.Assert;
import org.junit.Test;

import com.dmma.askfm.core.configuration.AppProperties;
import com.dmma.askfm.dto.shared.callbacks.GeoIpJSON;
import com.google.gson.Gson;

public class LocationAppServiceTest {

	private static final String jsonOutputExample = "{\"longitude\":4.3333,\"latitude\":50.8333,\"asn\":\"AS5432\",\"offset\":\"2\",\"ip\":\"62.4.153.123\",\"area_code\":\"0\",\"continent_code\":\"EU\",\"dma_code\":\"0\",\"city\":\"Brussels\",\"timezone\":\"Europe\\/Brussels\",\"region\":\"Brussels Hoofdstedelijk Gewest\",\"country_code\":\"BE\",\"isp\":\"BELGACOM S.A.\",\"country\":\"Belgium\",\"country_code3\":\"BEL\",\"region_code\":\"11\"}";

	private LocationAppService locationAppService;
	
	public LocationAppServiceTest() {
		this.locationAppService = new LocationAppServiceImpl();
	}
	
	@Test
	public void testGsonParsing(){
		Gson gson = new Gson();
		GeoIpJSON resultDTO = gson.fromJson(jsonOutputExample, GeoIpJSON.class);
		Assert.assertEquals("be", resultDTO.getCountry_code().toLowerCase());
	}
	
	@Test
	public void testCountires(){
		Assert.assertEquals(AppProperties.defaultCountryCode, locationAppService.detectCountryCode("localhost"));
		Assert.assertEquals(AppProperties.defaultCountryCode, locationAppService.detectCountryCode("127.0.0.1"));
		Assert.assertEquals("be", locationAppService.detectCountryCode("62.4.153.123"));
	}
	
	
	
}
