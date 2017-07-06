<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		<form:form method="post" modelAttribute="invoice">

			<div class="form-group">
				<form:errors path="*" />
				<label for="number">Numer Faktury:</label>
				<form:input path="invoiceNumber" id="number" />
			</div>
			<div class="form-group">
				<label for="di">Data wystawienia:</label>
				<form:input path="dateOfIssue" id="di" />
				<label for="dp">Data płatności:</label>
				<form:input path="dateOfPayment" id="dp" />
				<label for="sup">Nazwa dostawcy:</label>
				<form:select path="supplier.id" items="${suppliers }"
					itemLabel="name" itemValue="id" id="sup"></form:select>
			</div>
			<input type="submit" class="btn btn-default" value="Dodaj pozycję" />
		</form:form>

		<a href="../invoice/">Powrót do listy</a>
	</div>
</body>
</html>