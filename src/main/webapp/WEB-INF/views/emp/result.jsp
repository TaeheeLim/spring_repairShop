<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Title Here</title>
</head>
<body>

<h3>Result</h3>

<table>
	<tr>
		<th>유저ID</th>
		<td>${member.userId}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${member.userName}</td>
	</tr>
	<tr>
		<th>E-MAIL</th>
		<td>${member.email}</td>
	</tr>
	<tr>
		<th>패스워드</th>
		<td>${member.password}</td>
	</tr>
</table>
</body>
</html>