<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>

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
				<td>������ID:</td>
				<td><input type="hidden" name="managerId" value="${ManagerList.managerId}">${ManagerList.managerId}</td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��й�ȣ:</td>
				<td><input type="text" name="password" value="${ManagerList.password}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>�̸�:</td>
				<td><input type="text" name="name" value="${ManagerList.name}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��ȭ��ȣ:</td>
				<td><input type="text" name="phone" value="${ManagerList.phone}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>�ź�����ȣ:</td>
				<td><input type="text" name="identification" value="${ManagerList.identification}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>�ּ�:</td>
				<td><input type="text" name="address" value="${ManagerList.address}"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��������:</td>
				<td><input type="radio" value="������" name="degree" checked>������<input
					type="radio" value="�Ϲ�" name="degree">�Ϲ�</td>

			</tr>
			<tr bordercolor="#cd853f">
				<td>��뿩��:</td>
				<td><input type="radio" value="���" name="usable" checked>���<input
					type="radio" value="�̻��" name="usable">�̻��</td>
			</tr>

			<tr bordercolor="#cd853f">
				<td colspan="6" align="center"><input type="button" value="�� ��"
					onclick="goUpdate()">
					<input type="button" value="�� ��"
					onclick="goReturn()"></td>
					
			</tr>
		</table>
	</form>
</body>
</html>