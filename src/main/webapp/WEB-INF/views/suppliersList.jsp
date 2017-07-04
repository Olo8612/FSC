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
	<h1>Menu Dostawców</h1>
	<table>
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
</body>
</html>