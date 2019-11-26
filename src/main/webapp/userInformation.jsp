<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
<link
	href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap"
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

<!-- Main Stylesheet File -->
<link href="css/style.css" rel="stylesheet">
<link href="css/taemin.css" rel="stylesheet">
<!-- =======================================================
    Theme Name: Reveal
    Theme URL: https://bootstrapmade.com/reveal-bootstrap-corporate-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
  <script type="text/javascript">
	function userdelete(){
		window.location.href="userdelete.do"
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
<c:if test="${not empty msg}">
	<script>
		alert('${msg}');
	</script>
</c:if>
<body id="body">

	<!--==========================
    Top Bar
  ============================-->
	<section id="topbar" class="d-none d-lg-block">
		<div class="container clearfix">
			<div class="contact-info float-left">
				
			</div>
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
							<form id="loginForm" method="post"
								action="login.do">

								<div class="form-group has-feedback">
									<!----- username -------------->
									<input class="form-control" placeholder="Username" id="loginid"
										type="text" autocomplete="off" name="id" /> <span
										style="display: none; font-weight: bold; position: absolute; color: red; position: absolute; padding: 4px; font-size: 11px; background-color: rgba(128, 128, 128, 0.26); z-index: 17; right: 27px; top: 5px;"
										id="span_loginid"></span>
									<!---Alredy exists ! -->
									<span class="glyphicon glyphicon-user form-control-feedback"></span>
								</div>
								<div class="form-group has-feedback">
									<!----- password -------------->
									<input class="form-control" placeholder="Password"
										id="loginpsw" type="password" autocomplete="off" name="pw" />
									<span
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

							<form id="memberinsert" method="post"
								action="memberinsert.do">
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
										class="form-control col-lg-6" id = "ffid" name="id" placeholder="id">
								</div>
								
								<div class="row marginbox">
									<a class="col-lg-4" align="center"> 이메일 </a> <input type="text"
										class="form-control col-lg-6" id = "ffemail" name="email" placeholder="Email">
								</div>
								
								<div class="col-lg-12">
									<button 
									onclick="findPW()" id = "fidbtn" class="btn btn-green btn-block btn-flat">비밀번호 찾기</button>
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
				 <a href="mainform.do"><img src="https://lab.ssafy.com/uploads/-/system/appearance/header_logo/1/ssafy_logo.png"  alt="" title="" /></a>
			</div>

			<nav id="nav-menu-container">
				<ul class="nav-menu">
					<li><a href="./qna.jsp">QnA</a></li>
					<li><a href="list.do">상품 정보</a></li>
					<c:if test="${not empty id}">
						<li><a href="preferList.do">예상 섭취  정보</a></li>
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
	<!-- #header -->


	<!-- #intro -->

	<main id="main"> <!--==========================
     userInformation Section
    ============================-->
	<section id="userInformation">
		<div class="container">
			<div class="section-header">
				</br> </br>
				<h2>내 정보 보기</h2>
			</div>

			<form id="memberupdate" method="post" action="userupdate.do">

				<div class="row marginbox">
					<h4 class="col-lg-4" align="center">아이디</h4>
					<input type="id" class="form-control col-lg-8" name="id"
						placeholder="Id" value="${member.id}">
				</div>
				<hr>
				<div class="row marginbox">
					<h4 class="col-lg-4" align="center">비밀번호</h4>
					<input type="password" class="form-control col-lg-8" name="password"
						placeholder="Password" value="${member.password}">
				</div>
				<hr>
				<div class="row marginbox">
					<h4 class="col-lg-4" align="center">이름</h4>
					<input type="text" class="form-control col-lg-8" name="name"
						placeholder="Name" value="${member.name}">
				</div>
				<hr>
				<div class="row marginbox">
					<h4 class="col-lg-4" align="center">이메일</h4>
					<input type="text" class="form-control col-lg-8" name="email"
						placeholder="Email" value="${member.email}">
				</div>
				<hr>
				<div class="row marginbox">
					<h4 class="col-lg-4" align="center">전화번호</h4>
					<input type="text" class="form-control col-lg-8" name="phone"
						placeholder="phoneNumber" value="${member.phone}">
				</div>
				<hr>
				<div class="row marginbox">
					<h4 class="col-lg-4" align="center">주소</h4>
					<input type="text" class="form-control col-lg-8" name="address"
						placeholder="Address" value="${member.address}">
				</div>
				<hr>
				<div class="row marginbox">
					<h4 class="col-lg-4" align="center">알레르기</h4>
					<input type="text" class="form-control col-lg-8" name="allergy"
							placeholder="Allergy" value="${member.allergy}">
				</div>
				<hr>
				<div class="row marginbox">
					<h4 class="col-lg-9"></h4>
					<input type="submit"  class="form-control col-lg-1 btn btn-primary" id="editButton"
						value="수정" >
			</form>
					<input type="submit" class="form-control col-lg-1 btn btn-primary"
						id="submitButton" value="탈퇴" onclick="userdelete()">
				
				</div>
						


		</div>

	</section>


	<!-- #services --> </main>

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
	
</body>
</html>
