<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
</head>
<body>
<script type="text/javascript">
	function goUpdate(no) {
		f.no.value = no;
		f.action = "AdsUpdateForm";
		f.submit();
	}

	
</script>
</head>
<body>
	<form name="f" method="post">
		<input type="hidden" name="no">
		<table border="1" bordercolor="#cd853f">
			<tr bordercolor="#cd853f">
				<td>광고ID:</td>
				<td>${Ads.adsId}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>업체:</td>
				<td>${Ads.company}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>전화번호:</td>
				<td>${Ads.phone}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>사진:</td>
				<td><img src="img/${Ads.photo}" height="50px"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>소개를:</td>
				<td>${Ads.introduction}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>사용여부:</td>
				<td>${Ads.usable}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>Weight:</td>
				<td>${Ads.weight}</td>

			</tr>
			<tr bordercolor="#cd853f">
				<td>하차역:</td>
				<td>${Ads.stoppedName}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>등록시간:</td>
				<td>${Ads.registerDate}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>관리자이름:</td>
				<td>${Ads.managerId }
				</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td colspan="6" align="center"><input type="button" value="수 정"
					onclick="goUpdate('${Ads.adsId}')"></td>
			</tr>
		</table>
	</form>


</body>
</html>