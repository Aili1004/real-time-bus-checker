<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
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
				<td>����ID:</td>
				<td>${Ads.adsId}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��ü:</td>
				<td>${Ads.company}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��ȭ��ȣ:</td>
				<td>${Ads.phone}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>����:</td>
				<td><img src="img/${Ads.photo}" height="50px"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>�Ұ���:</td>
				<td>${Ads.introduction}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��뿩��:</td>
				<td>${Ads.usable}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>Weight:</td>
				<td>${Ads.weight}</td>

			</tr>
			<tr bordercolor="#cd853f">
				<td>������:</td>
				<td>${Ads.stoppedName}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��Ͻð�:</td>
				<td>${Ads.registerDate}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>�������̸�:</td>
				<td>${Ads.managerId }
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