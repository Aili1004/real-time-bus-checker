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
<form action="BusUpdate" method="post">
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td>����ID</td>
		<td>${bus.busId}
			<input type="hidden" name="busId" value="${bus.busId}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>��ȣ ��</td>
		<td>
			<input type="text" name="plateNumber" value="${bus.plateNumber}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>��ġ(x)</td>
		<td>
			<input type="text" name="position_x" value="${bus.position_x}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>��ġ(y)</td>
		<td>
			<input type="text" name="position_y" value="${bus.position_y}">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>��ġ����</td>
		<td>
			<input type="text" name="updateTime" value="${bus.updateTime}">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>�μ�ID</td>
		<td>
			<input type="text" name="routeId" value="${bus.routeId}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>����</td>
		<td>
			<input type="radio" value="� ��" name="status" checked>� ��
			<input type="radio" value="����" name="status">����
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>����</td>
		<td>
			<input type="text" name="closestStopId" value="${bus.closestStopId}">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>���ι�ȣ</td>
		<td>
			<input type="text" name="busNumberId" value="${bus.busNumberId}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>������ �̸�</td>
		<td>
		${bus.managerId}
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td colspan="2">
			<input type="submit" value="����">
		</td>
	</tr>
</table>
</form>
</body>
</html>