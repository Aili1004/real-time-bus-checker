<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
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
				<td>����ID:</td>
				<td>${Ads.adsId}<input type="hidden" name="adsId" value="${Ads.adsId}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��ü:</td>
				<td><input type="text" name="company" value="${Ads.company}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��ȭ��ȣ:</td>
				<td><input type="text" name="phone" value="${Ads.phone}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>����:</td>
				<td><img src="img/${Ads.photo}">
				<input type="file" name="file" height="50px"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>�Ұ���:</td>
				<td><input type="text" name="introduction" value="${Ads.introduction}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��뿩��:</td>
				<td><input type="radio" value="���" name="usable" checked>���<input
					type="radio" value="�̻��" name="usable">�̻��</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>Weight:</td>
				<td><input type="text" name="weight" value="${Ads.weight}"></td>

			</tr>
			<tr bordercolor="#cd853f">
				<td>������:</td>
				<td><input type="text" name="stopName" value="${Ads.stoppedName}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��Ͻð�:</td>
				<td><input type="text" name="registerDate" value="${Ads.registerDate}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>�������̸�:</td>
				<td><select name="managerId">
				<c:forEach var="manager" items="${ManagerList}"><option value="${manager.managerId}"
				<c:if test="${manager.managerId == Ads.managerId }">selected</c:if>>${manager.managerId}</option>
				</c:forEach>
				</select>
				</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td colspan="6" align="center"><input type="button" value="�� ��"
					onclick="goUpdate('${Ads.adsId}')"></td>
			</tr>
		</table>
	</form>
</body>
</html>