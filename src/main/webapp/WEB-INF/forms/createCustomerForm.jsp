<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="customer">
	<form:errors path="*"/><br>
	Nazwa: <form:input path="name"/><br>
	Adres: <form:input path="address"/><br>
	Nip: <form:input path="taxIdentificationNumber"/><br>
	Dodatkowe informacje: <form:input path="additionalInformation"/><br>
	<input type="submit"/>
	</form:form>
	<a href="../customer/">Powrót do listy</a>
</body>
</html>