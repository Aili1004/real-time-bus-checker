<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
<script type="text/javascript">
	function goBusAdd(){
		f.action="BusAdd";
		f.submit();
	}
</script>
</head>
<body>
<form name="f" method="post">
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td>����id:</td>
		<td>
			<input type="text" name="busId">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>��ȣ ��:</td>
		<td>
			<input type="text" name="plateNumber">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>����:</td>
		<td>
			<input type="radio" value="� ��" name="status" checked>� ��
			<input type="radio" value="����" name="status">����
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>��ġ(x):</td>
		<td>
			<input type="text" name="position_x">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>��ġ(y):</td>
		<td>
			<input type="text" name="position_y">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>�ֱ� ��ġ(x):</td>
		<td>
			<input type="text" name="updateTime">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>�ֱ� ��ġ(y):</td>
		<td>
			<input type="text" name="routeId">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>��Ͻð�:</td>
		<td>
			<input type="text" name="closestStopId">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>���ι�ȣ:</td>
		<td>
			<input type="text" name="busNumberId">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>������ �̸�:</td>
		<td>
			<select name="managerId">
				<c:forEach var="manager" items="${managerList}">
					<option value="${manager.managerId}">${manager.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td colspan="2">
			<input type="button" value="Ȯ��" onclick="goBusAdd()">
		</td>
	</tr>
</table>
</form>
</body>
</html>