<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Reveal Bootstrap Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Raleway:300,400,500,700,800|Montserrat:300,400,700"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/magnific-popup/magnific-popup.css" rel="stylesheet">
<link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">

<!-- Mentor CSS Files -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/imagehover.min.css">
<link rel="stylesheet" type="text/css" href="css/style2.css">

<!-- Main Stylesheet File -->
<link href="css/style.css" rel="stylesheet">
<link href="css/taemin.css" rel="stylesheet">

<!-- =======================================================
    Theme Name: Reveal
    Theme URL: https://bootstrapmade.com/reveal-bootstrap-corporate-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
<style>
.row {
	float: right;
}
</style>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      google.charts.setOnLoadCallback(drawChart2);
      function drawChart() {
    	  var data = google.visualization.arrayToDataTable([
          ['Name','Count'],
          ['${topList[0].fname}',    ${topList[0].count}],
          ['${topList[1].fname}',     ${topList[1].count}],
          ['${topList[2].fname}',     ${topList[2].count}],
          ['${topList[3].fname}',     ${topList[3].count}],
          ['${topList[4].fname}',     ${topList[4].count}]
        ]);

        var options = {
          title: '가장 많이 섭취한 식품 Top 5',
          colors: ['#2e498f', '#445b96', '#6d81b5', '#8ea1d1', '#b7c6ed'],
        width: 700,
        height: 600,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
        
        
      }
      function drawChart2(){
    	  var data = google.visualization.arrayToDataTable([
              ['Name','Count',{ role: 'style' } ],
              ['칼로리',    ${calory},'#f0533e'],
              ['탄수화물',     ${carbo},'#f09c48'],
              ['단백질',     ${protein},'#f0e73e'],
              ['지방',     ${fat},'#b7f54c'],
              ['당류',     ${sugar},'#5ad645'],
              ['나트륨',     ${natrium},'#45b9d6'],
              ['콜레스테롤',     ${chole},'#4291db'],
              ['지방산',     ${fattyacid},'#4268db'],
              ['트랜스지방',     ${transfat},'#7d42db'],
             
            ]);
            var view = new google.visualization.DataView(data);
        /*     view.setColumns([0, 1,
                             { calc: "stringify",
                               sourceColumn: 1,
                               type: "string",
                               role: "annotation" },
                             2]); */
            var options = {
              title: '일주일간 섭취한 식품 영양소별 정보',
              width: 1000,
              height: 400,
              bar: {groupWidth: "95%"},
              legend: { position: "none" },
            };

            var chart = new google.visualization.BarChart(document.getElementById('barchart'));
            chart.draw(data, options);
      }
    </script>
</head>
<body id="body">


	<!--==========================
    Top Bar 
  ============================-->
	<section id="topbar" class="d-none d-lg-block">
		<div class="container clearfix">
			<div class="contact-info float-left"></div>
			<div class="social-links float-right">

				<c:choose>
					<c:when test="${not empty id}">
						${id}
						<a href="memberinfo.do" id="memberinfo">회원정보</a>
						<a href="logout.do" id="logout">로그아웃</a>
					</c:when>
					<c:otherwise>
						<a href="#" data-target="#login" data-toggle="modal">로그인</a>
						<a href="#" data-target="#signup" data-toggle="modal">회원가입</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</section>

	<!--==========================
    Header
  ============================-->
	<header id="header">
		<div class="container">
			<div id="logo" class="pull-left">
				<a href="mainform.do"><img
					src="https://lab.ssafy.com/uploads/-/system/appearance/header_logo/1/ssafy_logo.png"
					alt="" title="" /></a>
			</div>

			<nav id="nav-menu-container">
				<ul class="nav-menu">
					<!-- <li class="menu-active"><a href="#body">Home</a></li> -->
					<li><a href="./qna.jsp">QnA</a></li>
					<li><a href="list.do">상품 정보</a></li>
					<c:if test="${not empty id}">
						<li><a href="preferList.do">예상 섭취 정보</a></li>
					</c:if>
					<c:if test="${not empty id}">
						<li><a href="consumeList.do">내 섭취 정보</a></li>
					</c:if>
					<li><a href="searchengine.do">검색 히스토리</a></li>

				</ul>
			</nav>
			<!-- #nav-menu-container -->
		</div>
	</header>
	<div id="main">
		<!--==========================
      Search Section
    ============================-->
		<div class="container" class="text-center">
			<div class="section-header">
				<br /> <br />
				<h2>${id }님의 섭취 정보</h2>
			</div>
		</div>

		<section id="services">
			<div class="container">
				<div class="col-lg-12">
					<div class='col-lg-6'>
						<table border="0" cellpadding="0" cellspacing="1" align=center
							style="width: 500px;">
							<tr>
								<td width=100 align=center bgcolor="#d5dae6" height="15">섭취식품</td>
								<td width=100 align=center bgcolor="#d5dae6" height="15">섭취날짜</td>
								<td width=100 align=center bgcolor="#d5dae6" height="15">섭취수량</td>
								<td width=100 align=center bgcolor="#d5dae6" height="15">삭제</td>
							</tr>
							<c:forEach items='${myList}' var='consume'>

								<div class='col-lg-12'>
									<div class=' box2 wow fadeInLeft row'></div>
								</div>

								<tr>
									<td width=100 align=center height=15>${consume.fname}</td>
									<td width=100 align=center height="15">${consume.eatdate}</td>
									<td width=100 align=center height="15">${consume.count}</td>
									<td width=100 align=center height="15"><button
											onclick="deleteFood(${consume.num})">삭제</button></td>
								</tr>

							</c:forEach>
						</table>
					</div>

					<div id="piechart" style="width: 40%; height: 500px; float: left;"
						class='col-lg-5'>
				</div>
				</div>
				<div class="col-lg-12">
					<div id="barchart" style="" width=800px></div>
				</div>
			</div>
		</section>


	</div>
	<!-- #services -->
	<br />
	<!--==========================
    Footer
  ============================-->
	<footer id="footer">
		<div class="container">
			<div class="copyright">
				&copy; Copyright <strong>Reveal</strong>. All Rights Reserved
			</div>
			<div class="credits">
				<!--
          All the links in the footer should remain intact.
          You can delete the links only if you purchased the pro version.
          Licensing information: https://bootstrapmade.com/license/
          Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Reveal
        -->
				Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
			</div>
		</div>
	</footer>
	<!-- #footer -->

	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/jquery/jquery-migrate.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/superfish/hoverIntent.js"></script>
	<script src="lib/superfish/superfish.min.js"></script>
	<script src="lib/wow/wow.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="lib/magnific-popup/magnific-popup.min.js"></script>
	<script src="lib/sticky/sticky.js"></script>

	<!-- Contact Form JavaScript File -->
	<script src="contactform/contactform.js"></script>

	<!-- Template Main Javascript File -->
	<script src="js/main.js"></script>

	<script type="text/javascript">
	function deleteFood(num) {
		/* console.log(num) */
		window.location.href = "deleteConsume.do?num=" + num;
	}
		
	
	</script>
</body>
</html>
