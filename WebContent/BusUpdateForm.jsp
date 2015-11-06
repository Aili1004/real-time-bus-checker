<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>

</head>
<body>
<form action="BusUpdate" method="post">
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td>버스ID</td>
		<td>${bus.busId}
			<input type="hidden" name="busId" value="${bus.busId}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>번호 판</td>
		<td>
			<input type="text" name="plateNumber" value="${bus.plateNumber}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>위치(x)</td>
		<td>
			<input type="text" name="position_x" value="${bus.position_x}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>위치(y)</td>
		<td>
			<input type="text" name="position_y" value="${bus.position_y}">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>위치변경</td>
		<td>
			<input type="text" name="updateTime" value="${bus.updateTime}">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>로선ID</td>
		<td>
			<input type="text" name="routeId" value="${bus.routeId}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>상태</td>
		<td>
			<input type="radio" value="운영 중" name="status" checked>운영 중
			<input type="radio" value="중지" name="status">중지
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>가까운역</td>
		<td>
			<input type="text" name="closestStopId" value="${bus.closestStopId}">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>선로번호</td>
		<td>
			<input type="text" name="busNumberId" value="${bus.busNumberId}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>관리자 이름</td>
		<td>
		${bus.managerId}
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td colspan="2">
			<input type="submit" value="수정">
		</td>
	</tr>
</table>
</form>
</body>
</html>