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
		<form action="/FSC/sale/add" method="post">

			<div class="form-group">
				<label>${errors }</label><br> 
				<label for="number">Numer faktury:</label> 
				<input name="invoiceNumber" id="number" /> 
				<label for="issueDate">Data wystawienia:</label>
				<input name="date"	id="issueDate" />
				<label for="paymentDate">Data płatności</label>
				<input name="dateOfPayment" id="paymentDate" />
			</div>
			<div class="form-group">
				<label for="customer">Odbiorca:</label> 
				<select name="customer">
					<c:forEach items="${customers }" var="customer">
						<option value="${customer.id }">${customer.name }</option>
					</c:forEach>
				</select>

			</div>
			<input type="submit" class="btn btn-default" value="Dodaj pozycję" />
		</form>

		<a href="/FSC/sale/">Powrót do listy</a>
	</div>
</body>
</html>