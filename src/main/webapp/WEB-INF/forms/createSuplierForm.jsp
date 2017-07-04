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
	<form:form method="post" modelAttribute="supplier">
	<form:errors path="*"/><br>
	Nazwa: <form:input path="name"/><br>
	Adres: <form:input path="address"/><br>
	Kategoria FSC: <form:input path="fscCategory"/><br>
	Numer certyfikatu FSC<form:input path="fscCertificationCode"/><br>
	Data ostatniej weryfikacji<form:input path="lastVerificationDate"/><br>
	<input type="submit"/>
	</form:form>
	<a href="list">Powrót do listy</a>
</body>
</html>