<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
</head>
<body>
<form action="AdsAdd" method="post" enctype="multipart/form-data">
<table border="1" bordercolor="#cd853f">

	<tr bordercolor="#cd853f">
				<td>����ID:</td>
				<td><input type="text" name="adsId"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��ü:</td>
				<td><input type="text" name="company" ></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��ȭ��ȣ:</td>
				<td><input type="text" name="phone" ></td>
			</tr>
			<tr bordercolor="#cd853f">
		<td>����</td>
		<td><input type="file" name="file"></td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>�Ұ���</td>
		<td><textarea name="introduction" rows="10" cols="40"></textarea></td>
	</tr>
	<tr bordercolor="#cd853f">
				<td>��뿩��:</td>
				<td><input type="radio" value="���" name="usable" checked>���<input
					type="radio" value="�̻��" name="usable">�̻��</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>Weight:</td>
				<td><input type="text" name="weight"></td>

			</tr>
			<tr bordercolor="#cd853f">
				<td>������:</td>
				<td><input type="text" name="stopName" "></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��Ͻð�:</td>
				<td><input type="text" name="registerDate" "></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>�������̸�:</td>
				<td>${manager.name}
				</td>
			</tr>
	
	<tr bordercolor="#cd853f">
		<td colspan="2">
			<input type="submit" value="�� ��">
		</td>
	</tr>
</table>
</form>
</body>
</html>