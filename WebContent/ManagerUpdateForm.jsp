<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>

<script type="text/javascript">
	function goUpdate() {
		f.action = "ManagerUpdate";
		f.submit();
	}
	function doReturn(){
		f.action = "ManagerList";
		f.submit();
	}
</script>
</head>
<body>
	<form name="f" method="post">
		<table border="1" bordercolor="#cd853f">
			<tr bordercolor="#cd853f">
				<td>관리자ID:</td>
				<td><input type="hidden" name="managerId" value="${ManagerList.managerId}">${ManagerList.managerId}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>비밀번호:</td>
				<td><input type="text" name="password" value="${ManagerList.password}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>이름:</td>
				<td><input type="text" name="name" value="${ManagerList.name}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>전화번호:</td>
				<td><input type="text" name="phone" value="${ManagerList.phone}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>신분증번호:</td>
				<td><input type="text" name="identification" value="${ManagerList.identification}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>주소:</td>
				<td><input type="text" name="address" value="${ManagerList.address}"></td>
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
				<td colspan="6" align="center"><input type="button" value="수 정"
					onclick="goUpdate()">
					<input type="button" value="취 소"
					onclick="goReturn()"></td>
					
			</tr>
		</table>
	</form>
</body>
</html>