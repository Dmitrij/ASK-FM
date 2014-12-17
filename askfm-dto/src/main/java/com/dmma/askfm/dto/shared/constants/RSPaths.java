package com.dmma.askfm.dto.shared.constants;

/**
 * This class contains Web service  URI paths constants<br>
 * see {@link RSPaths}
 * 
 * @author <a href="dmitrijs.marcenkovs@gmail.com">Dmitrijs Marcenkovs</a>
 */
public interface RSPaths {
	static final String RS_PublicService_Endpoint = "/questionRS";
	
	static final String RS_PATH_questionListGET  = "/questionListGET";
	static final String RS_PATH_questionListPOST = "/questionList";
	
	static final String RS_PATH_questionListByCountryGET  = "/questionListByCountryGET";
	static final String RS_PATH_questionListByCountryPOST = "/questionListByCountry";
	
	static final String RS_PATH_publishQuestionGET  = "/publishQuestionGET";
	static final String RS_PATH_publishQuestionPOST = "/publishQuestion";

	

}
