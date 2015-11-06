<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
</head>

<script type="text/javascript">
	function goAdd() {
		f.action = "ManagerAdd";
		f.submit();
	}
</script>

<body>
	<form name="f" method="post">
		<table border="1" bordercolor="#cd853f">
			<tr bordercolor="#cd853f">
				<td>관리자ID:</td>
				<td><input type="text" name = "managerId"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>비밀번호:</td>
				<td><input type="password" name = "password"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>이름:</td>
				<td><input type="text" name = "name"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>전화번호:</td>
				<td><input type="text" name = "phone"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>신분증번호:</td>
				<td><input type="text" name = "identification"></td>
			</tr>
			<tr>
				<td>주소:</td>
				<td><input type="text" name = "address"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>관리여부:</td>
				<td><input type="radio" value="마스터" name="degree" checked>마스터<input
					type="radio" value="일반" name="degree">일반</td>

			</tr>
			<tr bordercolor="#cd853f">
				<td>사용여부:</td>
				<td><input type="radio" value="사용" name="usable" checked>사용<input
					type="radio" value="미사용" name="usable">미사용</td>
			</tr>

			<tr bordercolor="#cd853f">
				<td colspan="6" align="center"><input type="button" value="추 가"
					onclick="goAdd()"></td>
			</tr>
		</table>
	</form>
</body>

</html>