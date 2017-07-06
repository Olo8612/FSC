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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container">
		<h2>Lista Dostawców</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<td>Nazwa</td>
					<td>Adres</td>
					<td>Kategoria FSC</td>
					<td>Kod Certyfikatu FSC</td>
					<td>Data Ostatniej Weryfikacji</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${suppliers }" var="supplier">
				<tr>
					<td>${supplier.name }</td>
					<td>${supplier.address }</td>
					<td>${supplier.fscCategory }</td>
					<td>${supplier.fscCertificationCode }</td>
					<td>${supplier.lastVerificationDate }</td>
					<td><a href="edit/${supplier.id}">Edytuj</a></td>
					<td><a href="delete/${supplier.id }">Usuń</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="add">Dodaj Dostawcę</a>
	</div>
</body>
</html>