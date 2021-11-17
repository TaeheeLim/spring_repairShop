<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- 구글 차트 호출을 위한 js 파일 라이브러리 -->
<script src="https://www.google.com/jsapi"></script>
<title>구글멀티차트(JSON)</title>
<script src="/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
//구글 차트 라이브러리
google.load("visualization","1",{
	"packages" : ["corechart"]
});
//불러오는 작업이 완료되어 로딩이 완료되면 drawChart함수 호출
//.responseText : json을 텍스트로 로컬로 읽어들임. console에서 확인 가능
google.setOnLoadCallback(drawChart);
google.setOnLoadCallback(drawChart2);

function drawChart(){
	var jsonData = $.ajax({
		url:"/resources/json/sampleData.json",
		dataType:"json",
		async:false
	}).responseText;
	
	console.log("jsonData : " + jsonData);
	//데이터 테이블 생성
	var data = new google.visualization.DataTable(jsonData);
	
	//어떤 모양으로 출력할지 정해줌
// 	var chart = new google.visualization.ColumnChart(
// 			document.getElementById("chart_div"));
// 	var chart = new google.visualization.PieChart(
// 			document.getElementById("chart_div"));
	var chart = new google.visualization.LineChart(
			document.getElementById("chart_div"));
	
	//chart.draw(데이터테이블, 옵션)
	chart.draw(data,{
		title:"차트 예제",
		width:600,
		height:400
	});
}//end drawChart()

function drawChart2(){
	var jsonData = $.ajax({
		url:"/resources/json/sampleData2.json",
		dataType:"json",
		async:false
	}).responseText;
	
	console.log("jsonData : " + jsonData);
	//데이터 테이블 생성
	var data = new google.visualization.DataTable(jsonData);
	
	//어떤 모양으로 출력할지 정해줌
// 	var chart = new google.visualization.ColumnChart(
// 			document.getElementById("chart_div2"));
	var chart = new google.visualization.PieChart(
			document.getElementById("chart_div2"));
// 	var chart = new google.visualization.LineChart(
// 			document.getElementById("chart_div2"));
	
	//chart.draw(데이터테이블, 옵션)
	chart.draw(data,{
		title:"차트 예제",
		width:600,
		height:400
	});
}//end drawChart2()

</script>
</head>
<body>

<div class="row">
	<div class="col-xl-8 col-lg-7">
	    <!-- Area Chart -->
	    <div class="card shadow mb-4">
	        <div class="card-header py-3">
	            <h6 class="m-0 font-weight-bold text-primary">상품 가격</h6>
	        </div>
	        <div id="chart_div"></div>
	    </div>
	</div>
</div>
<div class="row">
	<div class="col-xl-8 col-lg-7">
	    <!-- Area Chart -->
	    <div class="card shadow mb-4">
	        <div class="card-header py-3">
	            <h6 class="m-0 font-weight-bold text-primary">상품 가격</h6>
	        </div>
	        <div id="chart_div2"></div>
	    </div>
	</div>
</div>

</body>
</html>