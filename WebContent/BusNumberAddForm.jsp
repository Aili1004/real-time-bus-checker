<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
<script type="text/javascript">
	function goAdd(){
		f.action="BusNumberAdd";
		f.submit();
	}
</script>
</head>
<body>
<form name="f" method="post">
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td>���ι�ȣ:</td>
		<td>
			<input type="text" name="busNumberId">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>ù���ð�:</td>
		<td>
			<input type="text" name="firstTime">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>�����ð�:</td>
		<td>
			<input type="text" name="lastTime">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>��Ͻð�:</td>
		<td>
			<input type="text" name="registerDate">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>�������̸�:</td>
		<td>
			<select name="managerId">
				<c:forEach var="manager" items="${managerList}">
					<option value="${manager.managerId}">${manager.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>��뿩��:</td>
		<td>
			<input type="radio" value="���" name="usable" checked>���
			<input type="radio" value="�̻��" name="usable">�̻��
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td colspan="2">
			<input type="button" value="�߰�" onclick="goAdd()">
		</td>
	</tr>
</table>
</form>
</body>
</html>