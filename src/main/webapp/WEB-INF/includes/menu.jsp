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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="../invoice/">FSC Dokumentacja</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/FSC/supplier/">Dostawcy</a></li>
      <li><a href="/FSC/invoice/">Faktury</a></li>
      <li><a href="/FSC/customer/">Odbiorcy</a></li>
      <li><a href="/FSC/magazine/">Magazyn</a> </li>
      <li><a href="/FSC/woodType/">Gatunki Drewna</a></li>
    </ul>
  </div>
</nav>
</body>
</html>