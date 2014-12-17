package com.dmma.askfm.core.services;

/**
 * Location service responsible to detect GeoLocation of a incoming request 
 * @author Dima 
 * */
public interface LocationAppService {
	
	/**
	 * Queries 3d party service to detect country code.<br>
	 * In case of failure fallback to default country code specified in  {@link com.dmma.askfm.core.configuration.AppProperties}
	 * @param remoteAddr is IP address of a requestor
	 * @return country code
	 **/
	String detectCountryCode(String remoteAddr);
	
}
