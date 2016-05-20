<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/main.css'/>" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IT Bank</title>
</head>
<body>
<div id="mainDiv">
<div id="textDiv">
<div id="imgDiv">
	<img src="<c:url value="/resources/logoBank.png"/>" alt="Bank Logo" id="bankLogo" height="200" width="400">
</div>
<div id="formDiv">
	<form:form action="login.do" method="post"  modelAttribute="loginBean">
		<table id="formTable">
			<tr>
				<td><form:input type="text"  class="login-inp" path="username" /></td>
			</tr>
			<tr>
				<td><form:input type="password" value="" class="login-inp" path="password"/></td>
			</tr>
		</table>
	</form:form>
	<div id="loginButtonDiv">
		<a id="loginBtn" href="javascript:{}" onclick="document.getElementById('loginBean').submit(); return false;" class="btn blue">Login</a>
	</div>
</div>
<c:if test="${error}">
		<span id="errorMessageDiv">
			${msg}
		</span>
</c:if>
</div>
</div>
</body>
</html>

