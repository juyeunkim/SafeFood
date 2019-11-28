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

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" />
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
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
      	  ['Name','Count'],
          [ '${toppreferList[0].fname}',    ${toppreferList[0].count}],
          ['${toppreferList[1].fname}',     ${toppreferList[1].count}],
          ['${toppreferList[2].fname}',     ${toppreferList[2].count}],
          ['${toppreferList[3].fname}',     ${toppreferList[3].count}],
          ['${toppreferList[4].fname}',     ${toppreferList[4].count}]
        ]);

        var options = {
        		 titleTextStyle: {
     		        color: "#001c63",    // any HTML string color ('red', '#cc00cc')
     		        fontSize: '20', // 12, 18 whatever you want (don't specify px)
     		        bold: true    // true or false
     		    },
          title: '◆ 가장 많이 찜한 식품 Top 5',
          colors: ['#2e498f', '#445b96', '#6d81b5', '#8ea1d1', '#b7c6ed'],
        width: 500,
        height:500,
        
        };
        
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);

      }
      function findPW() {
    		//window.location.href="findPassword.do?id="+$('#ffid').val()+"&email?"+$('#ffemail').val();
    		$.ajax({
    			url : 'findPassword.do',
    				type : 'POST',
    				data : {
    					id : $('#ffid').val(),
    					email : $('#ffemail').val()
    				},
    				dataType : 'json', 
    				success : function(data, status, xhr){
    					console.log(data)
    					if(data=='id')
    						alert('존재하지않는 회원입니다');
    					else if(data=='email')
    						alert('이메일이 일치하지않습니다.')
    					else
    						alert(data.id+'님의 비밀번호는 '+data.password+'입니다')
    				},
    				error : function(err){
    					console.log(err);
    				}
    			}) 
    	}
      function check(){
    		if($('#loginid').val()==""){
    			alert("ID를 입력하여 주세요.")
    			loginForm.loginid.focus();
    			return false;
    		}else if($('#loginpsw').val()==""){
    			alert("PassWord를 입력하여 주세요.")
    			loginForm.loginpsw.focus();
    			return false;
    		}else return true;
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
						<span style="margin-right: 10px;">${id}</span>
						<a href="memberinfo.do" id="memberinfo">회원정보 <i
							class="fas fa-user"></i></a>
						<a href="logout.do" id="logout">로그아웃 <i
							class="fas fa-sign-out-alt"></i></a>
					</c:when>
					<c:otherwise>
						<a href="#" data-target="#login" data-toggle="modal">로그인 <i
							class="fas fa-sign-out-alt"></i></a>
						<a href="#" data-target="#signup" data-toggle="modal">회원가입 <i
							class="fas fa-user-plus"></i></a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</section>
	<!--Modal box-->
	<div class="modal fade" id="login" role="dialog" data-backdrop="static">
		<div class="modal-dialog modal-sm">
			<!-- Modal content no 1-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-center form-title">로그인</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>
				<div class="modal-body padtrbl">
					<div class="login-box-body">
						<p class="login-box-msg">아이디와 비밀번호를 입력하세요.</p>
						<c:if test="${msg !=null}">
							<p class="login-box-msg">${msg}</p>
						</c:if>
						<div class="form-group">
							<form id="loginForm" method="post" action="login.do">

								<div class="form-group has-feedback">
									<!----- username -------------->
									<input class="form-control" placeholder="Username" id="loginid"
										type="text" autocomplete="off" name="loginid" /> <span
										style="display: none; font-weight: bold; position: absolute; color: red; position: absolute; padding: 4px; font-size: 11px; background-color: rgba(128, 128, 128, 0.26); z-index: 17; right: 27px; top: 5px;"
										id="span_loginid"></span>
									<!---Alredy exists ! -->
									<span class="glyphicon glyphicon-user form-control-feedback"></span>
								</div>
								<div class="form-group has-feedback">
									<!----- password -------------->
									<input class="form-control" placeholder="Password"
										id="loginpsw" type="password" autocomplete="off"
										name="loginpsw" /> <span
										style="display: none; font-weight: bold; position: absolute; color: grey; position: absolute; padding: 4px; font-size: 11px; background-color: rgba(128, 128, 128, 0.26); z-index: 17; right: 27px; top: 5px;"
										id="span_loginpsw"></span>
									<!---Alredy exists ! -->
									<span class="glyphicon glyphicon-lock form-control-feedback"></span>
								</div>
								<div class="row">
									<div class="col-lg-12">
										<div class="checkbox icheck">
											<label> <input type="checkbox" id="loginrem">
												Remember Me
											</label>
										</div>
									</div>
									<div class="col-lg-12">
										<button type="submit" class="btn btn-green btn-block btn-flat">로그인</button>
										<button type="button" class="btn btn-green btn-block btn-flat"
											data-target="#signup" data-toggle="modal">회원가입</button>
										<button type="button" class="btn btn-green btn-block btn-flat"
											data-target="#findPassword" data-toggle="modal">비밀번호찾기</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!--Modal box-->
	<div class="modal fade" id="signup" role="dialog">
		<div class="modal-dialog modal-sm">

			<!-- Modal content no 2-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-center form-title">회원 가입</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				<div class="modal-body padtrbl">

					<div class="signup-box-body">
						<div class="form-group">

							<form id="memberinsert" method="post" action="memberinsert.do">
								<div class="row marginbox">
									<a class="col-lg-4" align="center"> 아이디 </a> <input type="text"
										class="form-control col-lg-6" name="id" placeholder="id">
								</div>
								<div class="row marginbox">
									<a class="col-lg-4" align="center"> 비밀번호 </a> <input
										type="password" class="form-control col-lg-6" name="password"
										placeholder="Password">
								</div>
								<div class="row marginbox">
									<a class="col-lg-4" align="center"> 이름 </a> <input type="text"
										class="form-control col-lg-6" name="name" placeholder="Name">
								</div>
								<div class="row marginbox">
									<a class="col-lg-4" align="center"> 이메일 </a> <input type="text"
										class="form-control col-lg-6" name="email" placeholder="Email">
								</div>
								<div class="row marginbox">
									<a class="col-lg-4" align="center"> 전화번호 </a> <input
										type="text" class="form-control col-lg-6" name="phone"
										placeholder="phoneNumber">
								</div>
								<div class="row marginbox">
									<a class="col-lg-4" align="center"> 주소 </a> <input type="text"
										class="form-control col-lg-6" name="address"
										placeholder="Address">
								</div>
								<div class="row marginbox">
									<a class="col-lg-4" align="center"> 알레르기 </a>
									<fieldset class="col-lg-8" id="innerFiledSet">
										<input class="from-control marginbox" type="checkbox"
											name="allergy" value="대두"> 대두 <input
											class="from-control marginbox" type="checkbox" name="allergy"
											value="땅콩"> 땅콩 <input class="from-control marginbox"
											type="checkbox" name="allergy" value="우유"> 우유 <input
											class="from-control marginbox" type="checkbox" name="allergy"
											value="새우"> 새우 <input class="from-control marginbox"
											type="checkbox" name="allergy" value="참치"> 참치 <input
											class="from-control marginbox" type="checkbox" name="allergy"
											value="연어"> 연어 <input class="from-control marginbox"
											type="checkbox" name="allergy" value="쑥"> 쑥 <input
											class="from-control marginbox" type="checkbox" name="allergy"
											value="소고기"> 소고기 <input
											class="from-control marginbox" type="checkbox" name="allergy"
											value="닭고기"> 닭고기 <input
											class="from-control marginbox" type="checkbox" name="allergy"
											value="돼지고기"> 돼지고기 <input
											class="from-control marginbox" type="checkbox" name="allergy"
											value="복숭아"> 복숭아 <input
											class="from-control marginbox" type="checkbox" name="allergy"
											value="민들레"> 민들레 <input
											class="from-control marginbox" type="checkbox" name="allergy"
											value="계란"> 계란
									</fieldset>
								</div>
								<div class="row"></div>
								<div class="col-lg-12">
									<button type="submit" class="btn btn-green btn-block btn-flat">가입</button>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>
	<!--/ Modal box-->


	<!--Modal box-->
	<div class="modal fade" id="findPassword" role="dialog">
		<div class="modal-dialog modal-sm">

			<!-- Modal content no 2-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title text-center form-title">비밀번호 찾기</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				<div class="modal-body padtrbl">

					<div class="findPassword-box-body">
						<div class="form-group">


							<div class="row marginbox">
								<a class="col-lg-4" align="center"> 아이디 </a> <input type="text"
									class="form-control col-lg-6" id="ffid" name="id"
									placeholder="id">
							</div>

							<div class="row marginbox">
								<a class="col-lg-4" align="center"> 이메일 </a> <input type="text"
									class="form-control col-lg-6" id="ffemail" name="email"
									placeholder="Email">
							</div>

							<div class="col-lg-12">
								<button onclick="findPW()" id="fidbtn"
									class="btn btn-green btn-block btn-flat">비밀번호 찾기</button>
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>

	</div>
	<!--/ Modal box-->


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
	<main id="main"> <!--==========================
      Search Section
    ============================-->
	<div class="container" class="text-center">
		<div class="section-header">
			<h2 style="margin-top: 20px;">${id }님의
				예상 식품 정보 <i class="fas fa-utensils" style="color: black;"></i>
			</h2>
		</div>
	</div>
	<section id="services">
		<div class="container">

			<c:choose>
				<c:when test="${empty myPreferList}">
					<span>데이터가 존재하지 않아요 <br /> 새로운 상품을 등록해주세요 <br /> <a
						href="list.do">상품 등록하러 가기</a>
					</span>
				</c:when>
				<c:otherwise>
					<div class='col-lg-12'>
						<div class='col-lg-7'>
							<table border="0" cellpadding="0" cellspacing="1" align=center
								width="600px">
								<tr>
									<td width=100 align=center bgcolor="#d5dae6" height=15">식품명</td>
									<td width=100 align=center bgcolor="#d5dae6" height="15">날짜</td>
									<td width=100 align=center bgcolor="#d5dae6" height="15">수량</td>
									<td width=100 align=center bgcolor="#d5dae6" height="15">섭취/삭제</td>
								</tr>
								<c:forEach items='${myPreferList}' var='preferfood'>
									<div class='col-lg-12'>
										<div class=' box2 wow fadeInLeft row'></div>
									</div>

									<tr>
										<td width=100 align=center height="15">${preferfood.fname}</td>
										<td width=100 align=center height="15">${preferfood.preferdate}</td>
										<td width=100 align=center height="15">${preferfood.count}</td>
										<td width=100 align=center height="15"><span
											style="margin-right: 20px;"
											onclick="insertFood(${preferfood.num})"> <i
												class="fas fa-heart" style="color: orange;"></i>
										</span> <span onclick="deleteFood(${preferfood.num})"> <i
												class="far fa-trash-alt"></i>
										</span></td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<div class='col-lg-5'>
							<div id="piechart" style="width: 40%; height: 500px;"></div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>

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
		function insertFood(num) {
			
			window.location.href = "insertconsume.do?num=" + num;
    	}
	
		function deleteFood(num) {
			/* console.log(num) */
			window.location.href = "deletePrefer.do?num=" + num;
		}
		
	
	</script>
</body>
</html>
