<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
<script type="text/javascript">
	function goUpdate(no) {
		f.no.value = no;
		f.action = "AdsUpdate";
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
				<td>${Ads.adsId}<input type="hidden" name="adsId" value="${Ads.adsId}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>업체:</td>
				<td><input type="text" name="company" value="${Ads.company}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>전화번호:</td>
				<td><input type="text" name="phone" value="${Ads.phone}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>사진:</td>
				<td><img src="img/${Ads.photo}">
				<input type="file" name="file" height="50px"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>소개를:</td>
				<td><input type="text" name="introduction" value="${Ads.introduction}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>사용여부:</td>
				<td><input type="radio" value="사용" name="usable" checked>사용<input
					type="radio" value="미사용" name="usable">미사용</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>Weight:</td>
				<td><input type="text" name="weight" value="${Ads.weight}"></td>

			</tr>
			<tr bordercolor="#cd853f">
				<td>하차역:</td>
				<td><input type="text" name="stopName" value="${Ads.stoppedName}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>등록시간:</td>
				<td><input type="text" name="registerDate" value="${Ads.registerDate}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>관리자이름:</td>
				<td><select name="managerId">
				<c:forEach var="manager" items="${ManagerList}"><option value="${manager.managerId}"
				<c:if test="${manager.managerId == Ads.managerId }">selected</c:if>>${manager.managerId}</option>
				</c:forEach>
				</select>
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