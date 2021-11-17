<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 등록 화면</title>
</head>
<body>

<form:form modelAttribute="member" method="post" action="/cus/register">
	<form:hidden path="userId" />
	<table>
		<tr>
			<td><form:label path="userId">유저ID</form:label> </td>
			<td>
				<form:input path="userId" />
				<font color="red"><form:errors path="userId" /></font>
			</td>
		</tr>
		<tr>
			<td><form:label path="password">패스워드</form:label> </td>
			<td>
				<form:password path="password" />
				<font color="red"><form:errors path="password" /></font>
			</td>
		</tr>
		<tr>
			<td><form:label path="userName">이름</form:label> </td>
			<td>
				<form:input path="userName" />
				<font color="red"><form:errors path="userName" /></font>
			</td>
		</tr>
		<tr>
			<td><form:label path="email">E-MAIL</form:label> </td>
			<td>
				<form:input path="email" />
				<font color="red"><form:errors path="email" /></font>
			</td>
		</tr>
		<tr>
			<td><form:label path="dateOfBirth">생년월일</form:label> </td>
			<td>
				<form:input type="date" path="dateOfBirth" />
				<font color="red"><form:errors path="dateOfBirth" /></font>
			</td>
		</tr>
		<tr>
			<td><form:label path="gender">성별</form:label> </td>
			<td>
				<form:radiobutton path="gender" value="male" label="Male" /><br>
				<form:radiobutton path="gender" value="female" label="Female" /><br>
				<form:radiobutton path="gender" value="other" label="Other" /><br>
				<font color="red"><form:errors path="gender" /></font>
			</td>
		</tr>
		<tr>
			<td><form:label path="address.postCode">우편번호</form:label></td>
			<td>
				<form:input path="address.postCode" />
				<font color="red">
					<form:errors path="address.postCode" />
				</font>
			</td>
		</tr>
		<tr>
			<td><form:label path="address.location">주소</form:label></td>
			<td>
				<form:input path="address.location" />
				<font color="red">
					<form:errors path="address.location" />
				</font>
			</td>
		</tr>
		<tr>
			<td><form:label path="cardList[0].no">카드1-번호</form:label></td>
			<td>
				<form:input path="cardList[0].no" />
				<font color="red">
					<form:errors path="cardList[0].no"></form:errors>
				</font>
			</td>
		</tr>
		<tr>
			<td><form:label path="cardList[0].validMonth">카드1-유효년월</form:label></td>
			<td>
				<form:input type="month" path="cardList[0].validMonth" />
				<font color="red">
					<form:errors path="cardList[0].validMonth"></form:errors>
				</font>
			</td>
		</tr>
		<tr>
			<td><form:label path="cardList[1].no">카드2-번호</form:label></td>
			<td>
				<form:input path="cardList[1].no" />
				<font color="red">
					<form:errors path="cardList[1].no"></form:errors>
				</font>
			</td>
		</tr>
		<tr>
			<td><form:label path="cardList[1].validMonth">카드2-유효년월</form:label></td>
			<td>
				<form:input type="month" path="cardList[1].validMonth" />
				<font color="red">
					<form:errors path="cardList[1].validMonth"></form:errors>
				</font>
			</td>
		</tr>
	</table>
	<form:button name="register" class="btn btn-success btn-icon-split">등록</form:button>

</form:form>
</body>
</html>