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


	<p>${invoice.invoiceNumber }</p>
	<p>${invoice.dateOfIssue}</p>
	<p>${invoice.supplier.name }</p>
	<form:form method="post" modelAttribute="invoiceItem">
		<form:errors path="*" />
			Opis: <form:input path="description" />
			Typ drewna: <form:input path="woodType" />
			Objętość m3: <form:input path="quantityCm3" />
			Waga: <form:input path="quantityGrams" />
			Kategoria Fsc: <form:input path="fscCategory" />
			
			Wartość: <form:input path="priceNet" />

		<input type="submit">
	</form:form>

</body>
</html>