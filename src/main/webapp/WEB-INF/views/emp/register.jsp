<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="/resources/js/jquery-3.6.0.min.js"></script>
    <title>SB Admin 2 - Register</title>

    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <script type="text/javascript">
    	$(function(){
    		//가입 버튼 클릭시
    		$('#idSubmit').on('click',function(e){
    			// 비밀번호 확인 처리
    			if($('#password').val()==$('#password2').val()){
	    			//폼을 submit함
	    			$('.user').submit();
    			} else {
    				//모달창의 내용을 변경
    				$(".modal-body").html("비밀번호가 다릅니다.");
    				//모달창을 보여주는 구문
    				$('#myModal').modal("show");
    				
    				$('#idFont').css("display","block");				
    			}
    			
    		});
    	});
    </script>
</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">직원 등록</h1>
                            </div>
<!-- 
<폼 태그>
1. path : 폼 항목에 바인딩되는 폼 객체의 프로퍼티를 지정
2. readonly : 폼 항목을 읽기 전용으로 만들지 여부(기본값:false) => 값이 전달됨
3. disabled : 폼 항목을 비 활성화할지 여부(기본값:false) => 값이 전달 안됨
 -->
                            <form:form class="user" method="post" 
                            	modelAttribute="emp" action="/emp/registerPost">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <form:input type="text" path="empNo" class="form-control form-control-user" 
                                        placeholder="직원번호" readonly="true" />
                                        <font color="red" size="1">
                                        	<form:errors path="empNo"></form:errors>
                                        </font>
                                    </div>
                                    <div class="col-sm-6">
                                        <form:input type="text" path="nm" class="form-control form-control-user"
                                            placeholder="이름" />
                                        <font color="red" size="1">
                                        	<form:errors path="nm"></form:errors>
                                        </font>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <form:input type="text" path="hp" class="form-control form-control-user"
                                        placeholder="연락처" />
                                    <font color="red" size="1">
                                        	<form:errors path="hp"></form:errors>
                                    </font>
                                </div>
                                <div class="form-group">
                                    <form:input type="text" path="postNo" class="form-control form-control-user"
                                        placeholder="우편번호" />
                                    <font color="red" size="1">
                                        	<form:errors path="postNo"></form:errors>
                                    </font>
                                </div>
                                <div class="form-group">
                                    <form:input type="text" path="addr" class="form-control form-control-user"
                                        placeholder="주소" />
                                    <font color="red" size="1">
                                        	<form:errors path="addr"></form:errors>
                                    </font>
                                </div>
                                <div class="form-group">
                                    <form:input type="text" path="addr2" class="form-control form-control-user"
                                        placeholder="상세주소" />
                                    <font color="red" size="1">
                                        	<form:errors path="addr2"></form:errors>
                                    </font>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <form:input type="password" path="password" class="form-control form-control-user"
                                             placeholder="비밀번호" />
                                         <font color="red" size="1">
                                        	<form:errors path="password"></form:errors>
                                    	 </font>
                                    </div>
                                    <div class="col-sm-6">
										<input type="password" id="password2" class="form-control form-control-user"
										placeholder="비밀번호 확인" />
										 <font color="red" size="1" id="idFont" style="display:none;">
                                        	비밀번호가 일치하지 않습니다.
                                    	 </font>
									</div>
                                </div>
                                <a href="#" id="idSubmit" class="btn btn-primary btn-user btn-block">
                                    Register Account
                                </a>
                            </form:form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
<!-- Modeal 추가 시작 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">ddit</h4>
			</div>
			<div class="modal-body">처리가 완료되었습니다.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default"
				data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- Modeal 추가 끝 -->
    <!-- Bootstrap core JavaScript-->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin-2.min.js"></script>

</body>

</html>