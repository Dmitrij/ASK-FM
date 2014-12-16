<%@ page language = "java" contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import = "com.dmma.askfm.core.configuration.AppProperties" %>
<%@ page import = "com.dmma.askfm.dto.shared.constants.RSPaths" %>
<%@ page import = "com.dmma.askfm.dto.shared.constants.RSParams" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ASK-FM | Question List</title>
</head>

<body>
	<h1><%=AppProperties.environment %></h1>
	
	<c:if test="${not empty questionlist}">
    	<div>Question list</div>
    	<table>
    		<tr>
    			<th>ID</th>
    			<th>Name</th>
    			<th>Country</th>
    			<th>Created</th>
    		</tr>
			<c:forEach items="${questionlist}" var="question">
			<tr>
				<td>${question.id}</td>
    			<td>${question.questionText}</td>
    			<td>${question.countryCode}</td>
    			<td>${question.created}</td>
			</tr>
			</c:forEach>
    		
    	</table>
	</c:if>
	
</body>
</html>
