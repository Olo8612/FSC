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

	<p>${invoice.id}</p>
	<p>${invoice.invoiceNumber }</p>
	<p>${invoice.dateOfIssue}</p>
	<p>${invoice.supplier.name }</p>
	<table>
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
			<c:forEach items="${existingItems }" var="items">
			<tr>
				<td>${items.description}</td>
				<td>${items.woodType}</td>
				<td>${items.quantityCm3}</td>
				<td>${items.quantityGrams}</td>
				<td>${items.fscCategory}</td>
				<td>${items.priceNet}</td>
			</tr>
			</c:forEach>
			<form:form method="post" modelAttribute="invoiceItem">
				<tr>
					<form:errors path="*" />
					
					<td><form:input path="description" /></td>
					<td><form:input path="woodType" /></td>
					<td><form:input path="quantityCm3" /></td>
					<td><form:input path="quantityGrams" /></td>
					<td><form:input path="fscCategory" /></td>
					<td><form:input path="priceNet" /></td>
					<form:hidden path="invoice.id" value="${invoice.id }" />
					<input type="submit" value="Dodaj pozycję">
				</tr>
				
			</form:form>
		</tbody>
	</table>
	<a href="../">Zakończ dodawanie pozycji</a>

</body>
</html>