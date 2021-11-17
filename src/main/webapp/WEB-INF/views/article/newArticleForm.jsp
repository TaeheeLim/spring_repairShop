<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/ckeditor/ckeditor.js"></script>
<title>게시글 쓰기(/article/newArticleForm.jsp)</title>

</head>
<body>

<form:form method="post" action="/article/newArticlePost"
	modelAttribute="article">
	<p>
		제목: <br />
		<form:input path="title" />
		<font color="red">
			<form:errors path="title" />
		</font>
	</p>
	<p>
		내용: <br />
		<form:textarea path="articleContentVO.content" rows="6" cols="30" />
		<font color="red">
			<form:errors path="articleContentVO.content" />
		</font>
	</p>
	<form:button name="register">등록</form:button>
</form:form>


<script type="text/javascript">
CKEDITOR.replace("articleContentVO.content");
</script>
</body>
</html>