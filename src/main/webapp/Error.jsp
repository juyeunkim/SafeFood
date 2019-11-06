<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>핸드폰 관리</title>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<br>
	<table width=780 border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td width="20"></td>
			<td>
				<!--contents-->
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 -
								에러</b></td>
					</tr>
				</table> <br> <!-- write Form  -->
				<form method="post" action="savePhone.do">
					<table border="0" cellpadding="0" cellspacing="1" width="590"
						bgcolor="BBBBBB">
						<tr>
							<td width=100 align=center bgcolor="E6ECDE" height="22">처리중
								문제가 발생했습니다.</td>
						</tr>
						<tr>
							<td width=100 align=center height="22">문제 내용 - ${msg}</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>

</body>

</html>