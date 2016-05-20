<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IT Bank - Main Page</title>
</head>
<body>
<div>
<p>Welcome ${client.firstname} ${client.lastname}</p>
<table>
	<c:forEach items="${client.accounts}" var="account">
		<tr><td>Account</td></tr>
		<tr><td>${account.id}</td><td>${account.balance}</td></tr>
		
			<tr><td>Cards</td></tr>
			<c:forEach items="${account.cards}" var="card">
				<tr><td>${card.id}</td><td>${card.accountId}</td></tr>
			</c:forEach>
		
	</c:forEach>
</table>
<a href="loginPage">LogOut</a>

</div>	
</body>
</html>