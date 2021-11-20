<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="/resources/js/jquery-latest.min.js"></script>
<script src="/resources/js/jspdf.min.js"></script>
<script src="/resources/js/html2canvas.min.js"></script>
<script src="/resources/js/html2pdf.bundle.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>직원 게시판</title>

<!-- Custom fonts for this template -->
<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">
   <!-- Page Wrapper -->
   <div id="wrapper">
      <!-- Content Wrapper -->
      <div id="content-wrapper" class="d-flex flex-column">
         <!-- Main Content -->
         <div id="content">

            <!-- Topbar -->
            <jsp:include page="../topbar.jsp" />
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid" id="div0">

               <!-- Page Heading -->
               <h1 class="h3 mb-2 text-gray-800">Tables</h1>
               <p class="mb-4">
                  DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the
                  <a target="_blank" href="https://datatables.net">official DataTables documentation</a>
                  .
               </p>

               <!-- DataTales Example -->
               <div class="card shadow mb-4">
                  <div class="card-header py-3">
                     <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                  </div>
                  <div class="card-body">
            		
            		<select id="select">
            			<option value="a">선택</option>
            			<option value="t">제목</option>
            			<option value="c">내용</option>
            		</select>
            		<input type="text" id="searchInput" placeholder="검색내용을 입력해주세요"/>
                  	
                  	<div style="float:right; margin-bottom: 10px;">
                  		<a href="javascript:makeCkPdf();" class="btn btn-info btn-icon-split">
	                        <span class="icon text-white-50">
	                            <i class="fas fa-info-circle"></i>
	                        </span>
	                        <span class="text">PDF다운로드</span>
                        </a>
                  	</div>
                     <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                           <thead>
                              <tr>
                                 <th>번호</th>
                                 <th>제목</th>
                                 <th>작성자</th>
                                 <th>조회수</th>
                                 <th>게시글번호</th>
                              </tr>
                           </thead>
                           <tbody id="tbody">
                              <c:forEach var="article" items="${articlePage.content}" varStatus="stat">
                                 <tr>
                                    <td>${article.rnum}</td>
                                    <td>
                                    	<a href="/article/seeArticle?id=${article.articleNo}">
                                    		${article.title}
                                    	</a>
                                    </td>
                                    <td>${article.writerVO.writerName}</td>
                                    <td>${article.readCnt}</td>
                                    <td>${article.articleNo}</td>
                                 </tr>
                              </c:forEach>
                           </tbody>
                        </table>
                     </div>

                     <div class="row">
                        <div class="col-sm-12 col-md-5">
                           <div class="dataTables_info" id="dataTable_info" role="status" aria-live="polite">Showing ${param.currentPage*10-9} to ${param.currentPage*10} of ${articlePage.total} entries</div>
                        </div>
                        <div class="col-sm-12 col-md-7">
                           <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
                              <ul class="pagination">
                                 <li class="paginate_button page-item previous <c:if test="${articlePage.startPage<=5}">disabled</c:if>" id="dataTable_previous"><a href="/article/listArticle?currentPage=${articlePage.startPage - 5}" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link"> Previous </a></li>
                                    
                                    <c:forEach var="page" begin="${articlePage.startPage}" end="${articlePage.endPage}">
                                 <li class="paginate_button page-item <c:if test='${param.currentPage eq pNo}'> active</c:if>"> <a href="/article/listArticle?currentPage=${page}" aria-controls="dataTable" data-dt-idx="${page}" tabindex="0" class="page-link"> ${page} </a></li>
                                    
                                    </c:forEach>
                                 
                                 <li class="paginate_button page-item next <c:if test='${articlePage.endPage >= articlePage.totalPages}'>disabled</c:if>" id="dataTable_next"><a href="/article/listArticle?currentPage=${articlePage.startPage + 5}" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link"> Next </a></li>
                              </ul>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <!-- /.container-fluid -->
         </div>
         <!-- End of Main Content -->
      </div>
      <!-- End of Content Wrapper -->
   </div>
   <!-- End of Page Wrapper -->

   <!-- Scroll to Top Button-->
   <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
   </a>

   <!-- Logout Modal-->
   <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
               <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">×</span>
               </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
               <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
               <a class="btn btn-primary" href="login.html">Logout</a>
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

   <!-- Page level plugins -->
   <script src="/resources/vendor/datatables/jquery.dataTables.min.js"></script>
   <script src="/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

   <!-- Page level custom scripts -->
   <script src="/resources/js/demo/datatables-demo.js"></script>


<script type="text/javascript">
// $(function(){
// 	const json = JSON.stringify("");
// 	console.log('json : ' + json);
// });
	
// function makeCkPdf(){
// 	sessionStorage.setItem("key1", new Date());
	
// 	document.getElementById('div1').innerHTML = sessionStorage.getItem("key1");
	
// 	html2canvas($("#div0")[0]).then(function(canvas){
// 		var doc = new jsPDF('1','px',[700,1000]);	//jsPDF객체 생성
// 		var imgData = canvas.toDataURL('image/png');	//캔버스를 이미지로 변환
// 		doc.addImage(imgData,'PNG',0,0);	//이미지 기반으로 pdf 생성
// 		doc.save('sample.pdf');
// 	});
// }

const searchInput = document.querySelector('#searchInput');
const selectOption = document.querySelector('#select');

searchInput.addEventListener('keyup', e => {
	const _keyword = e.target.value
	findArticle(_keyword);
});

selectOption.addEventListener('change', e => {
	const _keyword = searchInput.value;
	findArticle(_keyword);
})

function findArticle(key){
	const _option = document.querySelector('#select').value;
	const _data = {
			keyword : key,
			ption : _option
	}
	
	$.ajax({
		url : '/article/search',
		method : 'post',
		data: _data,
		success (res) {
			const tBody = document.querySelector("#tbody")
			tBody.innerHTML = ''
			let row = ""
			console.log(res)
			for(let item of res) {
				//console.log(item)
				row += `<tr>
                    <td>` + item.articleNo +`</td>
                    <td>
                    	<a href="/article/seeArticle?id=` + item.articleNo + `">
                    		` + item.title + `
                    	</a>
                    </td>
                    <td>` + item.writerName + `</td>
                    <td>` + item.readCnt + `</td>
                    <td>` + item.articleNo + `</td>
                 </tr>`
			}
            tBody.innerHTML = row
		},
		error(e) {
			console.log(e)
		}
	});
}
</script>
</body>
</html>




























