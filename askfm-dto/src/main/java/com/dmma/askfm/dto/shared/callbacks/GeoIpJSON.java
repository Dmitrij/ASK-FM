package com.dmma.askfm.dto.shared.callbacks;


/**
 * A class represents JSON Output Schema from Telize.com
 * 
 * @author <a href="dmitrijs.marcenkovs@gmail.com">Dmitrijs Marcenkovs</a>
 */
public class GeoIpJSON {

	// --- Variables ---
	/** Visitor IP address, or IP address specified as parameter */
	private String ip;
	
	/** Two-letter ISO 3166-1 alpha-2 country code */
	private String country_code;
	
	private String country_code3;
	
	private String country;
	
	private String region_code;
	
	private String region;
	
	private String city;
	
	private String postal_code;
	
	private String continent_code;
	
	private String latitude;
	
	private String longitude;
	
	private String dma_code;
	
	private String area_code;
	
	private String asn;
	
	private String isp;
	
	private String timezone;

	// --- Methods ---
	public GeoIpJSON() {
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getCountry_code3() {
		return country_code3;
	}

	public void setCountry_code3(String country_code3) {
		this.country_code3 = country_code3;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion_code() {
		return region_code;
	}

	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getContinent_code() {
		return continent_code;
	}

	public void setContinent_code(String continent_code) {
		this.continent_code = continent_code;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDma_code() {
		return dma_code;
	}

	public void setDma_code(String dma_code) {
		this.dma_code = dma_code;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getAsn() {
		return asn;
	}

	public void setAsn(String asn) {
		this.asn = asn;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	

}
