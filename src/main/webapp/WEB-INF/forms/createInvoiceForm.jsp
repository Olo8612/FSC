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
	<form:form method="post" modelAttribute="invoice">
		<form:errors path="*" />
		<br>
	Numer Faktury: <form:input path="invoiceNumber" />
		<br>
	Data wystawienia: <form:input path="dateOfIssue" />
		<br>
	Data płatności: <form:input path="dateOfPayment" />
		<br>
	Dostawca: <form:select path="supplier.id" items="${suppliers }"
			itemLabel="name" itemValue="id"></form:select>
		<br>
		<input type="submit" />
	</form:form>
	<a href="../">Powrót do listy</a>
</body>
</html>