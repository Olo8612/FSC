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

		<h2>Faktura nr: ${invoice.invoiceNumber }</h2>
		<h2>Data wystawienia: ${invoice.dateOfIssue}</h2>
		<h2>Data płatności: ${invoice.dateOfPayment}</h2>
		<h2>Nazwa odbiorcy: ${invoice.customer.name }</h2>
		<table class="table table-hover">
			<label>${errors}</label>
			<thead>
				<tr>
					<td>Typ Produktu</td>
					<td>Rozmiar</td>
					<td>Typ Drewna</td>
					<td>Ilość szt.</td>
					<td>Waga gram</td>
					<td>Kategoria FSC</td>
					<td>Wartość Netto</td>
					<td>Uwagi</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${items }" var="items">
					<tr>
						<td>${items.productType}</td>
						<td>${items.dimension }</td>
						<td>${items.woodType.name}</td>
						<td>${items.quantityPiece}</td>
						<td>${items.quantityGrams}</td>
						<td>${items.fscCategory }</td>
						<td>${items.priceNet}</td>
						<td>${items.additionalInformation }</td>
					</tr>
				</c:forEach>
				<form action="/FSC/sale/add/${invoice.id}/items" method="post">
					<tr>
						<td>
							<select name="productType">
								<option value="boat">Łódki</option>
								<option value="part">Sęki</option>
							</select>
						</td>
						<td><input name="dimension"/></td>
						<td>
							<select name="woodTypeId">
								<c:forEach items="${woodType }" var="type">
									<option value="${type.id }">${type.name }</option>
								</c:forEach>
							</select>
						</td>
						<td><input name="quantityPiece"/></td>
						<td><input name="quantityGrams" /></td>
						<td>
							<select name="fscCategory">
								<option value="25">25%</option>
								<option value="50">50%</option>
								<option value="75">75%</option>
								<option selected value="100">100%</option>
							</select>
						</td>
						<td><input name="priceNet" /></td>
						<td><input name="addInfo"/></td>
						<input type="hidden" name="invoice.id" value="${invoice.id }" />
						<input type="submit" value="Dodaj pozycję">
					</tr>

				</form>
			</tbody>
		</table>
		<a href="../">Zakończ dodawanie pozycji</a>
	</div>
</body>
</html>