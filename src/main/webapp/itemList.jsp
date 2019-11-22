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
</head>

<body id="body">
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
						<li><a href="consumeList.do">내 섭취 정보</a></li>
					</c:if>
					<li><a href="#contact">예상 섭취 정보</a></li>
				</ul>
			</nav>
			<!-- #nav-menu-container -->
		</div>
	</header>

	<main id="main"> 
	<section>
		<div class="container" class="text-center">
			<div class="section-header">
				<br /> <br />
				<h2>상품정보</h2>
			</div>

			<form action="foodList2.do" method="post">
				<div class="row">

					<div class="searchCondition col-lg-3"></div>
					<div class="searchCondition col-lg-2">
						<div align="center">
							<h4 class="title">
								<a href="">검색조건 &nbsp;&nbsp;&nbsp; </a>
							</h4>
							<select id='searchCondition' size='1' class="form-control"
								name='key' value='asdfasdfasdf'>
								<option value='all' <c:if test="${key.equals('all')}">selected</c:if>>검색조건</option>
								<option value='name' <c:if test="${key.equals('name')}">selected</c:if>>상품명</option>
								<option value='maker'<c:if test="${key.equals('maker')}">selected</c:if>>제조사</option>
								<option value='material'<c:if test="${key.equals('material')}">selected</c:if>>첨가물</option>
							</select>
						</div>
					</div>

					<div class="searchWords col-lg-2">
						<div align="center">
							<h4 class="title">
								<a href="">검색단어 &nbsp;&nbsp;</a>
							</h4>
							<input type="text" class="form-control" id="searchWord"
								name="word" value="${word }"onKeyPress="if (event.keyCode==13){searchItem();}">
						</div>
					</div>

					<div class="searchButton col-lg-0.3">
						<div align="center">
							<h4 class="title">
								<a href="">&nbsp;&nbsp;&nbsp; </a>
							</h4>
							<input type='submit' id='searchButton' value='검색하기'
								class="btn btn-primary"></input>
						</div>
					</div>


				</div>

			</form>

		</div>
	</section>

	<!-- #services --> <!--==========================
      Services Section
    ============================-->
	<section id="services">
		<div class="container">
			<div class="row" id="serviceSection">

				<div class='col-lg-12'>
					<c:forEach items='${foodList}' var='food'>
						<form  method='post' name ="userinput">
							<div class='col-lg-12'>
								<div class=' box2 wow fadeInLeft row'>

									<div class='col-lg-3'>
										<img src='${food.img}' width='200px' 
										style= 'cursor: pointer'
											onclick="itemInfor(${food.code});">
									</div>

									<div class='col-lg-8'>
										<h4 style='cursor: pointer'>
											<a> ${food.name} </a>
										</h4>
										<p>${food.material}</p>
										<div class="row ">
											<h4 class="col-lg-7"></h4>
											<input type='hidden' name='code' value="${food.code}">
											<input type="submit" class="form-control col-lg-2 btn btn-primary" id="preferButton" value="찜하기" onClick="goData('prefer')"/>
											<input type="number"
												class="form-control col-lg-2 btn btn-default"
												id="countInput" name = "count"> 
											<input type="submit" class="form-control col-lg-2 btn btn-primary" id="eatButton" value="섭취하기" onClick="goData('eat')"/>
										</div>
									</div>
								</div>
							</div>
						</form>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>

	<!-- #services --> </main>
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
	 function itemInfor(foodno) {
		window.location.href="itemInfor.do?code="+foodno+"&count="+$('#countInput').val();
	}
	 function goData(mode){
		 var form = document.userinput;
		if(mode=="섭취하기") {
			 userinput.action ="insertfood.do";
		 }
		 else userinput.action ="preferfood.do";
		
	 }
	</script>
</body>
</html>
