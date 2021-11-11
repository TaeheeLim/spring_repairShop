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
	<tr>
		<th>소개</th>
		<td>${member.introduction}</td>
	</tr>
	<tr>
		<th>취미</th>
		<td>
			<c:forEach var="hobby" items="${member.hobbyList}">
				<c:out value="${hobby}" /><br />
			</c:forEach>
		</td>
	</tr>
	<tr>
		<th>개발자여부</th>
		<td>${member.developer}</td>
	</tr>
	<tr>
		<th>외국인여부</th>
		<td>${member.foreigner}</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>
		<c:choose>
			<c:when test="${member.gender eq '01'}">남성</c:when>
			<c:when test="${member.gender eq '02'}">여성</c:when>
			<c:otherwise>기타</c:otherwise>
		</c:choose>
		</td>
	</tr>
	<tr>
		<th>국적</th>
		<td>
		<c:choose>
			<c:when test="${member.nationality eq '01'}">한국</c:when>
			<c:when test="${member.nationality eq '02'}">독일</c:when>
			<c:when test="${member.nationality eq '03'}">호주</c:when>
		</c:choose>
		</td>
	</tr>
	<tr>
		<th>소유자동차</th>
		<td>
			<c:forEach var="car" items="${member.carList}">
				<c:choose>
					<c:when test="${car eq '01'}">르노삼성</c:when>
					<c:when test="${car eq '02'}">현대</c:when>
					<c:otherwise>쌍용</c:otherwise>
				</c:choose>
			</c:forEach>
		</td>
	</tr>
	
</table>
</body>
</html>