package com.dmma.askfm.core.configuration;

import org.constretto.ConstrettoBuilder;
import org.constretto.ConstrettoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;

public class AppProperties {
	private final static Logger LOG = LoggerFactory.getLogger(AppProperties.class);
	
	public static final ConstrettoConfiguration constrettoConfiguration;
	public static final String environment;
	public static final Boolean useDataInitializer;
	public static final String defaultCountryCode;
	public static final Double questionsPerSecond;
	public static final String geoipServiceURL;

	static{
		constrettoConfiguration = new ConstrettoBuilder().createPropertiesStore()
				.addResource(new DefaultResourceLoader().getResource("classpath:askfm.properties")).done()
				.getConfiguration();
		
		environment         = constrettoConfiguration.evaluateToString("environment");

		useDataInitializer = constrettoConfiguration.evaluateToBoolean("useDataInitializer");
		defaultCountryCode = constrettoConfiguration.evaluateToString("defaultCountryCode");
		
		questionsPerSecond    = constrettoConfiguration.evaluateToDouble("questionsPerSecond");
		
		geoipServiceURL = constrettoConfiguration.evaluateToString("geoipServiceURL");
	
		LOG.info("AppProperties initialized. Using environment="+environment);
	} 

	public static boolean getUseDataInitializer(){
		if(useDataInitializer == null) 
			return false;
		return useDataInitializer.booleanValue();
	}

}
