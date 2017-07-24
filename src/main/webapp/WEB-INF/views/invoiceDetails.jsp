<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>FSC Dokumentacja</title>
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>
	
	<div class="container">
		<h2>Faktura nr: ${invoice.invoiceNumber }</h2>
		<h2>Data wystawienia: <fmt:formatDate value="${invoice.dateOfIssue}" pattern="yyyy-MM-dd"/></h2>
		<h2>Płatność do: <fmt:formatDate value="${invoice.dateOfPayment}" pattern="yyyy-MM-dd"/></h2>
		<h2>Nazwa dostawcy: ${invoice.supplier.name }</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<td>Opis</td>
					<td>Typ Drewna</td>
					<td>Objętość cm3</td>
					<td>Waga gram</td>
					<td>Kategoria FSC</td>
					<td>Wartość Netto</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${invoiceItems }" var="items">
					<tr>
						<td>${items.description}</td>
						<td>${items.woodType.name}</td>
						<td>${items.quantityCm3}</td>
						<td>${items.quantityGrams}</td>
						<td>${items.fscCategory}</td>
						<td>${items.priceNet}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="../">Powrót do listy</a>
	</div>
</body>
</html>