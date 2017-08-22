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
		<form:form method="post" modelAttribute="woodType">

			<div class="form-group">
				<form:errors path="*" />
				<label for="name">Nazwa:</label>
				<form:input path="name" id="name" />
			</div>
			<div class="form-group">
				<label for="efficiencyKnots">Wydajność Sęków(/m3):</label>
				<form:input path="efficiencyKnots" id="efficiencyKnots" />

				<label for="efficiencyBoats">Wydajność Łódek(/m3):</label>
				<form:input path="efficiencyBoats" id="efficiencyBoats" />
			</div>


			<input type="submit" class="btn btn-default" value="Dodaj pozycję" />
		</form:form>
		<a href="/FSC/woodType/">Powrót do listy</a>
	</div>

</body>
</html>