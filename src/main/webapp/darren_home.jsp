<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Allowed</title>
</head>
<body>
	<h1>You are allowed ${logged_in_user}</h1>

	<!--   <h1>These are your lucky numbers ${param.lucky_numbers}</h1>-->

	<h1>
		These are your lucky numbers:
		<c:forEach items="${lucky_numbers}" var="individual_number">
	${individual_number} 
	</c:forEach>
	</h1>

</body>
</html>