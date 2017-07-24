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
		<h2>Lista Faktur</h2>
		<table class="table table-hover">
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
						<td><a href="items/${invoice.id}">${invoice.invoiceNumber }</a></td>
						<td>${invoice.supplier.name }</td>
						<td><fmt:formatDate value="${invoice.dateOfIssue }" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${invoice.dateOfPayment }" pattern="yyyy-MM-dd"/></td>

						<td><a href="edit/${invoice.id}">Edytuj</a></td>
						<td><a href="delete/${invoice.id }">Usuń</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add">Dodaj Fakturę</a>
	</div>
	
</body>
</html>