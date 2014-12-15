<%@ page language = "java" contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import = "com.dmma.askfm.core.configuration.AppProperties" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ASK-FM | Main</title>
</head>

<body>
	<h1><%=AppProperties.environment %></h1>
	<div>
	</div>
	<div>
		<a href='<c:url value="/ws"/>'>Available Services</a>
	</div> 
	<div>
		<a href='<c:url value="/ws/questionRS/questionListGET"/>'>list all accepted questions</a>
	</div> 
		
</body>
</html>
