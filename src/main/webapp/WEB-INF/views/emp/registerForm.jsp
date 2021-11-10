<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Title Here</title>
</head>
<body>
<h2>Spring Form</h2>
<form:form modelAttribute="member" method="post" action="/emp/register">
<table>
	<tr>
		<td>유저ID</td>
		<td>
		<!-- path : 폼 항목에 바인딩되는 폼 객체의 프로퍼티를 지정함 -->
			<form:input path="userId" />
			<font color="red"><form:errors path="userId" /></font>
		</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<form:input path="userName" />
			<font color="red"><form:errors path="userName" /></font>
		</td>
	</tr>
	<tr>
		<td>E-MAIL</td>
		<td>
			<form:input path="email" />
			<font color="red"><form:errors path="email" /></font>
		</td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td>
			<form:password path="password" />
			<font color="red"><form:errors path="password" /></font>
		</td>
	</tr>
</table>
<form:button name="register">등록</form:button>
</form:form>
</body>
</html>