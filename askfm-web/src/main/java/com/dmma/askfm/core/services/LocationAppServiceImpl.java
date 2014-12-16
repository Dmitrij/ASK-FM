package com.dmma.askfm.core.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dmma.askfm.core.configuration.AppProperties;
import com.dmma.askfm.dto.shared.callbacks.GeoIpJSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LocationAppServiceImpl implements LocationAppService{
	// --- Constants ---
	private final static Logger LOG = LoggerFactory.getLogger(LocationAppServiceImpl.class);

	// --- Variables ---

	public LocationAppServiceImpl() {
	}

	@Override
	public String detectCountryCode(String remoteAddr){
		String address = AppProperties.geoipServiceURL+remoteAddr;
		String countryCode = AppProperties.defaultCountryCode;
		
		try {
			URL url = new URL(address);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
				
				InputStreamReader i = new InputStreamReader(conn.getInputStream());
				final BufferedReader reader = new BufferedReader(i);
				GeoIpJSON resultDTO = gson.fromJson(reader, GeoIpJSON.class);
				if(resultDTO != null && resultDTO.getCountry_code() != null)
					countryCode = resultDTO.getCountry_code().toLowerCase();
			}else{
				LOG.warn("Failed to detect country code: HTTP error code : "+ conn.getResponseCode());
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
			LOG.error("Failed to detect country code", e);
		} catch (IOException e) {
			LOG.error("Failed to detect country code", e);
		}

		return countryCode;
	}

}
