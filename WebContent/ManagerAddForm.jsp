<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
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
				<td>������ID:</td>
				<td><input type="text" name = "managerId"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��й�ȣ:</td>
				<td><input type="password" name = "password"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>�̸�:</td>
				<td><input type="text" name = "name"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>��ȭ��ȣ:</td>
				<td><input type="text" name = "phone"></td>
			</tr>
			<tr bordercolor="#cd853f">
				<td>�ź�����ȣ:</td>
				<td><input type="text" name = "identification"></td>
			</tr>
			<tr>
				<td>�ּ�:</td>
				<td><input type="text" name = "address"></td>
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
					onclick="goAdd()"></td>
			</tr>
		</table>
	</form>
</body>

</html>