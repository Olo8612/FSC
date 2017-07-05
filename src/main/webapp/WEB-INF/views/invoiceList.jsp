<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<h1>Menu Faktur</h1>
	<nav> 
		<a href="add">Dodaj Fakturę</a> 
		<a href="../supplier/">Dostawcy</a>
		<a href="../customer/">Odbiorcy</a>
		<a href="">Magazyn</a> 
		<a href="">Produkcja</a> 
	</nav>
	<table>
		<thead>
			<tr>
				<td>Numer</td>
				<td>Dostawca</td>
				<td>Data wystawienia</td>
				<td>Płatność do</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${invoices }" var="invoice">
				<tr>
					<td>${invoice.invoiceNumber }</td>
					<td>${invoice.supplier.name }</td>
					<td>${invoice.dateOfIssue }</td>
					<td>${invoice.dateOfPayment }</td>
				
					<td><a href="edit/${invoice.id}">Edytuj</a></td>
					<td><a href="delete/${invoice.id }">Usuń</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>