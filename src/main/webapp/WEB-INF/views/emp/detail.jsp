<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Register</title>
	<script src="/resources/js/jquery-3.6.0.min.js"></script>
    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
	<script type="text/javascript">
	$(function(){
		//수정 버튼 클릭을 하면 수정모드가 됨
		$('#idUpdate').on('click',function(){
			//수정 가능하도록 함
			$("input").removeAttr("readonly");
			//단, 직원번호는 수정할 수 없음
			$('#empNo').attr("readonly","readonly");
			
			$("#divEdit").css("display","none");
			$("#divConfirm").css("display","block");
		});
			//취소 버튼 클릭을 하면 보기모드가 됨
			$("#idCancel").on('click',function(){
				$("input").attr("readonly","readonly");
			   
			    $("#divEdit").css("display","block");
			    $("#divConfirm").css("display","none");
		    });
			//확인 버튼 클릭 시 직원 정보를 수정
			$("#idOk").on('click',function(){
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
			//퇴직 처리
			$('#idDelete').on('click',function(){
				var yn = confirm("해당 사원을 퇴직처리 하시겠습니까?");
				
				if(yn==true){
					$("#frm").submit();
				}
			});
	});	
	</script>
</head>

<body class="bg-gradient-primary">
	<form id="frm" method="post" action="/emp/deletePost">
		<input type="hidden" name="empNo" value="${param.empNo}" />
	</form>
    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">직원 상세</h1>
                            </div>
                              <form:form class="user" method="post" 
                            	modelAttribute="emp" action="/emp/detailPost">
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
                                            placeholder="이름" readonly="true"/>
                                        <font color="red" size="1">
                                        	<form:errors path="nm"></form:errors>
                                        </font>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <form:input type="text" path="hp" class="form-control form-control-user"
                                        placeholder="연락처" readonly="true"/>
                                    <font color="red" size="1">
                                        	<form:errors path="hp"></form:errors>
                                    </font>
                                </div>
                                <div class="form-group">
                                    <form:input type="text" path="postNo" class="form-control form-control-user"
                                        placeholder="우편번호" readonly="true"/>
                                    <font color="red" size="1">
                                        	<form:errors path="postNo"></form:errors>
                                    </font>
                                </div>
                                <div class="form-group">
                                    <form:input type="text" path="addr" class="form-control form-control-user"
                                        placeholder="주소" readonly="true"/>
                                    <font color="red" size="1">
                                        	<form:errors path="addr"></form:errors>
                                    </font>
                                </div>
                                <div class="form-group">
                                    <form:input type="text" path="addr2" class="form-control form-control-user"
                                        placeholder="상세주소" readonly="true"/>
                                    <font color="red" size="1">
                                        	<form:errors path="addr2"></form:errors>
                                    </font>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <form:hidden path="password" class="form-control form-control-user"
                                             placeholder="비밀번호" readonly="true"/>
                                         <font color="red" size="1">
                                        	<form:errors path="password"></form:errors>
                                    	 </font>
                                    </div>
                                    <div class="col-sm-6">
										<input type="password" id="password2" class="form-control form-control-user"
										placeholder="비밀번호 확인" readonly="true" />
										 <font color="red" size="1" id="idFont" style="display:none;">
                                        	비밀번호가 일치하지 않습니다.
                                    	 </font>
									</div>
                                </div>
                                <div class="form-group row" id="divEdit">
	                                <a href="#" id="idUpdate" style="width:50%;float:left;" class="btn btn-primary btn-user btn-block">
	                                	수정
	                                </a>
	                                <a href="#" id="idDelete" style="width:50%;float:right;" class="btn btn-primary btn-user btn-block">
	                                    삭제
	                                </a>
                                </div>

                                <div class="form-group row" id="divConfirm" style="display:none;">
	                                <a href="#" id="idOk" style="width:50%;float:left;" class="btn btn-primary btn-user btn-block">
	                                	확인
	                                </a>
	                                <a href="#" id="idCancel" style="width:50%;float:right;" class="btn btn-primary btn-user btn-block">
	                                    취소
	                                </a>
                                </div>
                            </form:form>
                            <hr>
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