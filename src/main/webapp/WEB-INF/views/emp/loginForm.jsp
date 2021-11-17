<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//요청할 때마다 request객체에 cookie가 함께 던져짐
Cookie[] cookies = request.getCookies();
String empNo = "";
if(cookies != null){
	for(int i = 0; i < cookies.length; i++){
		if(cookies[i].getName().equals("empNo")){
			out.print("쿠키 : " + cookies[i].getName());
			out.print("쿠키값 : " + cookies[i].getValue());
			System.out.println(cookies[i].getName());
			
			empNo = cookies[i].getValue();
		}
	}
}
%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Login</title>

    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">직원회원 로그인</h1>
                                    </div>
                                    <form:form id="frm" class="user" method="post" action="/emp/login" modelAttribute="emp">
                                        <input type="hidden" name="nm" value="0" />
                                        <input type="hidden" name="addr" value="0" />
                                        <input type="hidden" name="hp" value="0" />
                                        <input type="hidden" name="postNo" value="0" />
                                        <div class="form-group">
                                        	<c:if test="${loginFail != ''}">
                                        		<font color="red" size="1">${loginFail}</font>
                                            </c:if>
                                            <c:set var="empNo" value="<%=empNo%>" />
                                            <form:input path="empNo" class="form-control form-control-user"
                                                placeholder="직원아이디" value="${empNo}" />
                                            <font color="red" size="1"><form:errors path="empNo" /></font>
                                        </div>
                                        <div class="form-group">
                                            <form:password path="password" class="form-control form-control-user"
                                                placeholder="비밀번호입력" /> 
                                            <font color="red" size="1"><form:errors path="password" /></font>
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" 
                                                	id="customCheck" name="customCheck">
                                                <label class="custom-control-label" for="customCheck">아이디기억하기</label>
                                            </div>
                                        </div>
                                        <a href="#" class="btn btn-primary btn-user btn-block"
                                        	id="idLogin">
                                            Login
                                        </a>
                                        <hr>
                                        <a href="index.html" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Login with Google
                                        </a>
                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                        </a>
                                    </form:form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">Forgot Password?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="register.html">Create an Account!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin-2.min.js"></script>
<script type="text/javascript">
const idLogin = document.querySelector('#idLogin');
idLogin.addEventListener('click',function(){
	document.querySelector('#frm').submit();
});
</script>
</body>
</html>