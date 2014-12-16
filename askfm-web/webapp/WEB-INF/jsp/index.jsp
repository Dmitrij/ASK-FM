<%@ page language = "java" contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import = "com.dmma.askfm.core.configuration.AppProperties" %>
<%@ page import = "com.dmma.askfm.dto.shared.constants.RSPaths" %>
<%@ page import = "com.dmma.askfm.dto.shared.constants.RSParams" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ASK-FM | Main</title>
</head>

<body>
	<h1><%=AppProperties.environment %></h1>
	<div>
		<a href='<c:url value="/ws"/>'>Available Services</a>
	</div> 
	
	<table>
		<tr>
			<th>Goal</th>
			<th>Path param</th>
			<th>Form param</th>
			<th>Web view</th>
		</tr>
		<tr>
			<td>List of all accepted questions</td>
			<td>
				<a href="ws<%=RSPaths.RS_PublicService_Endpoint + RSPaths.RS_PATH_questionListGET%>">click here</a>
			</td>
			<td>
				<form action="ws<%=RSPaths.RS_PublicService_Endpoint + RSPaths.RS_PATH_questionListPOST %>" method="post">
					<input type="submit">
 				</form> 
			</td>
			<td>
				<a href="questionlist.do">click to all</a>
			</td>
		</tr>
		<tr>
			<td>List of accepted questions in </td>
			<td>
				<a href="ws<%=RSPaths.RS_PublicService_Endpoint + RSPaths.RS_PATH_questionListByCountryGET%>/lv">Latvia</a>
			</td>
			<td>
				<form action="ws<%=RSPaths.RS_PublicService_Endpoint + RSPaths.RS_PATH_questionListByCountryPOST%>" method="post">
					<input type="text" name="<%=RSParams.countryCode%>" value="be">
					<input type="submit">
 				</form> 
			</td>
			<td>
				<a href="questionlistbycountry.do?country=be">click to see BE</a>
			</td>
		</tr>
		<tr>
			<td>Publish questions</td>
			<td>
				<a href="ws<%=RSPaths.RS_PublicService_Endpoint + RSPaths.RS_PATH_publishQuestionGET%>/Whatsapp%20folks%3F">Whatsapp folks?</a>
			</td>
			<td>
				<form action="ws<%=RSPaths.RS_PublicService_Endpoint + RSPaths.RS_PATH_publishQuestionPOST%>" method="post">
					<input type="text" name="<%=RSParams.questionText%>" value="Why the sky is blue?">
					<input type="submit">
 				</form> 
			</td>
			<td>
			</td>
		</tr>
	</table>
	
</body>
</html>
