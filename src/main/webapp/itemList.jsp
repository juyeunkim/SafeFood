<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Safe Food</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Raleway:300,400,500,700,800|Montserrat:300,400,700"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
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

<!-- Mentor CSS Files -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/imagehover.min.css">
<link rel="stylesheet" type="text/css" href="css/style2.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css" />

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" />

<script>


function findCountry(code){
	//console.log(code)
	var nations = ["가나","가봉","가이아나","감비아","과테말라","그레나다","그리스","기니","기니비사우",//ㄱ
		"나미비아","나우루","나이지리아","남수단","남아프리카","네덜란드","네팔","노르웨이","뉴질랜드","니제르","니카라과","남오세티야",//ㄴ
		"대만","덴마크","도미니카","독일","동티모르",//ㄷ
		"라오스","라이베리아","라트비아","러시아","레바논","레소토","루마니아","룩셈부르크","르완다","리비아","리투아니아","리히텐슈타인",//ㄹ
		"마다가스카르","마셜","말라위","말레이시아","말리","멕시코","모나코","모로코","모리셔스","모리타니","모잠비크","몬테네그로","몰도바","몰디브","몰타","몽골","미국","미얀마","미크로네시아",//ㅁ
		"바누아투","바레인","바베이도스","바티칸","바하마","방글라데시","베냉","베네수엘라","베트남","벨기에","벨라루스","벨리즈","벨라루스","벨리즈","보스니아","보츠와나","볼리비아","부룬디","부르키나파소","부탄","북마케도니아","북키프로스","불가리아","브라질","브루나이",//ㅂ
		"사모아","사우디아라비아","사하라 아랍 민주 공화국","산마리노","상투메 프린시페","세네갈","세르비아","세이셸","세인트루시아","소말리아","수단","스리랑카","스웨덴","스위스","스페인","슬로바키아","슬로베니아","시리아","싱가포르",//ㅅ
		"아랍에미리트","아르헨티나","아이슬란드","아이티","아일랜드","아프가니스탄","알바니아","에스토니아","에콰도르","에티오피아","영국","예멘","오만","오스트레일리아","오스트리아","온두라스","요르단","우간다","우루과이","우즈베키스탄","우크라이나","이라크","이란","이스라엘","이집트","이탈리아","인도","인도네시아","일본",//ㅇ
		"중국","자메이카","잠비아","북한","짐바브웨",//ㅈ
		"체코","칠레",//ㅊ
		"카메룬","카타르","캄보디아","캐나다","콜롬비아","콩고","쿠바","쿠웨이트","크로아티아",//ㅋ
		"타이완","타지키스탄","탄자니아","태국","터키","토고","튀니지",//ㅌ
		"파나마","파라과이","파키스탄","파푸아뉴기니","페루","포르투칼","폴란드","프랑스","피지","핀란드","필리핀",//ㅍ
		"헝가리","호주","홍콩",//ㅎ
		"외국산","수입산", "국내산"//번외
	];

	
	var material =  $("input[name='material"+(code)+"']").val();
	//console.log(material)
	for(var i=0; i<nations.length; i++){
		if(material.includes(nations[i])) {
			console.log(nations[i])
			$("#country"+(code)).append(nations[i]+" ")}
	}
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
<!-- =======================================================
    Theme Name: Reveal
    Theme URL: https://bootstrapmade.com/reveal-bootstrap-corporate-template/
    Author: BootstrapMade.com
    License: https://bootstrapmade.com/license/
  ======================================================= -->
</head>
<style>
/* The Modal (background) */
.ui-datepicker {
	font-size: 12px;
	width: 220px;
}

.ui-datepicker select.ui-datepicker-month {
	width: 30%;
	font-size: 11px;
}

.ui-datepicker select.ui-datepicker-year {
	width: 40%;
	font-size: 11px;
}

.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 50%; /* Could be more or less, depending on screen size */
}
</style>


<body id="body">
	<section id="topbar" class="d-none d-lg-block">
		<div class="container clearfix">
			<div class="contact-info float-left"></div>
			<div class="social-links float-right">

				<c:choose>
					<c:when test="${not empty id}">
						${id}
						<a href="memberinfo.do" id="memberinfo">회원정보  <i class="fas fa-user"></i></a>
						<a href="logout.do" id="logout">로그아웃 <i class="fas fa-sign-out-alt"></i></a>
					</c:when>
					<c:otherwise>
						<a href="#" data-target="#login" data-toggle="modal">로그인</a>
						<a href="#" data-target="#signup" data-toggle="modal">회원가입 <i class="fas fa-user-plus"></i></a>
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
							<form id="loginForm" method="post" name="loginForm"
								onsubmit="return check()" action="login.do">

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

	<main id="main">
	<section>
		<div class="container" class="text-center">
			<div class="section-header">
			<h2>	<i class="fas fa-apple-alt"></i>상품정보</h2>
				<c:if test="${not empty dangermsg}">
					<!-- Modal content -->
					<div class="modal-content">
						<p style="text-align: center;">
							<span style="font-size: 14pt; color: #0c2e84"><b><span
									style="font-size: 24pt;">※ 주의 성분 안내</span></b></span>
						</p>
						<p
							style="text-align: center; font-size: 14pt; line-height: 1.5; color: #000000">
							<br /> 주의성분 ( <span
								style="color: #ff0000; font-weight: bold; font-size: 15pt;">${dangermsg }</span>
							) 때문에 <span style="color: #6b2103; font-weight: bold;">${foodname }
							</span> 을(를) 섭취할 수 없습니다.</br> </br> <span
								style="color: #0c2e84; font-weight: bold;">주의 성분이 포함된 다른
								음식 : </span><br /> <span style="color: #000000; font-size: 12pt;">${dangerfoodlist}
							</span>
						</p>
						<p>
							<br />
						</p>
						<div
							style="cursor: pointer; background-color: #DDDDDD; text-align: center; padding-bottom: 10px; padding-top: 10px;"
							onClick="close_pop();">
							<span class="pop_bt" style="font-size: 13pt;"> 닫기 </span>
						</div>
					</div>

				</c:if>
			</div>

			<form action="foodList2.do" method="post">
				<div class="row">

					<div class="searchCondition col-lg-3"></div>
					<div class="searchCondition col-lg-2">
						<div align="center">
							<h4 class="title">
								<a style="color: #22659c; font-weight: bold; font-size: 15pt;">검색조건
									&nbsp;&nbsp;</a>
							</h4>
							<select id='searchCondition' size='1' class="form-control"
								name='key' value='asdfasdfasdf'>
								<option value='all'
									<c:if test="${key.equals('all')}">selected</c:if>>검색조건</option>
								<option value='name'
									<c:if test="${key.equals('name')}">selected</c:if>>상품명</option>
								<option value='maker'
									<c:if test="${key.equals('maker')}">selected</c:if>>제조사</option>
								<option value='material'
									<c:if test="${key.equals('material')}">selected</c:if>>첨가물</option>
							</select>
						</div>
					</div>

					<div class="searchWords col-lg-2">
						<div align="center">
							<h4 class="title">
								<a style="color: #22659c; font-weight: bold; font-size: 15pt;">검색단어
									&nbsp;&nbsp;</a>
							</h4>
							<input type="text" class="form-control" id="searchWord"
								name="word" value="${word }"
								onKeyPress="if (event.keyCode==13){searchItem();}">
						</div>
					</div>

					<div class="searchButton col-lg-0.3">
						<div align="center">
							<h4 class="title">
								<a href="">&nbsp;&nbsp;&nbsp; </a>
							</h4>
							<input type='submit' id='searchButton' value='검색하기'
								class="btn btn-primary" style=" font-weight: bold; background-color:#84b6d1; border-color: #84b6d1	; "></input>
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
					<hr style="border: solid 1px #a0b1de; width: 100%" />

					<c:forEach items='${foodList}' var='food' begin="0" end="20"
						step="1" varStatus="status">
						<div class='col-lg-12'>
							<div class=' box2 wow fadeInLeft row'>

								<div class='col-lg-2'>
									<img src='${food.img}' width='150px' style='cursor: pointer'
										onclick="itemInfor(${food.code});">
								</div>

								<div class='col-lg-9'>
									<div class='col-lg-5'>
										<h4 style='cursor: pointer'>

											<a href="itemInfor.do?code=${food.code}"
												style="text-align: center; font-size: 16pt; line-height: 1.5; color: #0c2e84; font-weight: bold;">
												▶ ${food.name} </a>
										</h4>
										<table>
											<tr>
												<td
													style="font-size: 10pt; line-height: 1.5; color: #000000">제조사:
													<span style="color: #0c2e84; font-weight: bold;">${food.maker}
												</span> </br> 하루 적정 섭취량: <span
													style="color: #0c2e84; font-weight: bold;">${food.supportpereat}</span>
													</br> 알러지성분: <span style="color: #0c2e84; font-weight: bold;">${food.allergy}</span>
													<input type="hidden" id="material${status.count}" name="material${status.count}"
														
													value="${food.material}" /> </br>원산지 표시: <span
													style="color: #0c2e84; font-weight: bold;" id="country${status.count}"></span>
													</span>
													<script>findCountry(${status.count})</script>


												</td>
											</tr>

										</table>
									</div>
									<div>
										<input type='hidden' name='code' value="${food.code}" />
										날짜: <input type="text" id="datepicker${status.count}"
											name="datepicker${status.count}" size="10"
											onclick="getDate(${status.count})"> <br/><input
											type="number" class="form-control col-lg-2 btn btn-default"
											id="countInput" placeholder="수량" name="count_btn"/><br />
										<br />
										<button class="form-control col-lg-2 btn btn-primary"
											id="preferButton" value="찜하기"
											onClick="goData('prefer',${food.code},this.parentNode.children[2].value,this.parentNode.children[1].value)">찜</button>
										<button class="form-control col-lg-2 btn btn-primary"
											id="eatButton" value="섭취하기"
											onClick="goData('eat',${food.code},this.parentNode.children[2].value,this.parentNode.children[1].value)">섭취</button>
									</div>
								</div>
								<hr style="border: solid 1px #a0b1de; width: 100%" />
							</div>
						</div>

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
    
    jQuery(document).ready(function() {
          $('#myModal').show();
          //alert({dangermsg})
    });
    function getDate(code){
    	$("input[name='datepicker"+code+"']").datepicker({
    		 dateFormat: 'yy-mm-dd'
    	});
    	console.log(code)
    }
    
    function open(flag) {
        $('#myModal').show();
   };
    //팝업 Close 기능
    function close_pop(flag) {
         $('#myModal').hide();
         window.location.href="list.do";
    };
    
	 function itemInfor(foodno) {
		window.location.href="itemInfor.do?code="+foodno;
	}
	 
	 function goData(mode,foodno,obj,obj2){
		if(mode=="eat") {
			console.log(mode);
			 window.location.href = "insertfood.do?code="+foodno+"&count="+obj+"&date="+obj2;
			//userinput.action ="insertfood.do";
		 }
		 else {
			//userinput.action ="preferfood.do";
			 window.location.href = "preferfood.do?code="+foodno+"&count="+obj;
		}
	 }
	</script>
</body>
</html>
