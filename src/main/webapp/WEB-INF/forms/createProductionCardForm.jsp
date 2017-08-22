<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FSC Dokumentacja</title>
<link
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>
	<div class="container">
		<form action="/FSC/production/add" method="post">

			<div class="form-group">
				<label for="date">Data:</label>
				<input name="date" id="number" />
			</div>
			<div class="form-group">
				<label>${errors }</label><br>
				<label for="mag">Pozycja Magazynu:</label>
				<table class="table table-hover" id="mag">
					<thead>
						<tr>
							<td></td>
							<td>Numer Pozycji</td>
							<td>Numer Faktury</td>
							<td>Typ Drewna</td>
							<td>Ilość w kilogramach</td>
							<td>Ilość w metrach</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${magazines }" var="magazine">
							<tr>
								<td><input type="radio" name="magazine" value="${magazine.id }"/></td>
								<td>${magazine.id }</td>
								<td>${magazine.invoice.invoiceNumber }</td>
								<td>${magazine.woodType.name }</td>
								<td>${magazine.quantityGrams }</td>
								<td>${magazine.quantityCm3 }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<label for="ntm">Pobrany materiał m3:</label> 
				<input name="ndtrimetrs" id="ntm" /> 
				<label for="nkg">Pobrany materiał kg:</label> 
				<input name="ndkg" id="nkg" />
			</div>
			<input type="submit" class="btn btn-default" value="Dodaj pozycję" />
		</form>

		<a href="/FSC/production/">Powrót do listy</a>
	</div>
</body>
</html>