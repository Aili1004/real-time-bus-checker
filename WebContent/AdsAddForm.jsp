<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
</head>
<body>
<form action="AdsAdd" method="post" enctype="multipart/form-data">
<table border="1" bordercolor="#cd853f">

	<tr bordercolor="#cd853f">
				<td>광고ID:</td>
				<td><input type="text" name="adsId"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>업체:</td>
				<td><input type="text" name="company" ></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>전화번호:</td>
				<td><input type="text" name="phone" ></td>
			</tr>
			<tr bordercolor="#cd853f">
		<td>사진</td>
		<td><input type="file" name="file"></td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>소개글</td>
		<td><textarea name="introduction" rows="10" cols="40"></textarea></td>
	</tr>
	<tr bordercolor="#cd853f">
				<td>사용여부:</td>
				<td><input type="radio" value="사용" name="usable" checked>사용<input
					type="radio" value="미사용" name="usable">미사용</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>Weight:</td>
				<td><input type="text" name="weight"></td>

			</tr>
			<tr bordercolor="#cd853f">
				<td>하차역:</td>
				<td><input type="text" name="stopName" "></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>등록시간:</td>
				<td><input type="text" name="registerDate" "></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>관리자이름:</td>
				<td>${manager.name}
				</td>
			</tr>
	
	<tr bordercolor="#cd853f">
		<td colspan="2">
			<input type="submit" value="전 송">
		</td>
	</tr>
</table>
</form>
</body>
</html>