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
<form action="BusStopUpdate" method="post">
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td>역Id</td>
		<td>${busStop.stopId}
			<input type="hidden" name="stopId" value="${busStop.stopId}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>역 이름</td>
		<td>
			<input type="text" name="stopName" value="${busStop.stopName}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>위치(x)</td>
		<td>
			<input type="text" name="location_x" value="${busStop.location_x}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>위치(y)</td>
		<td>
			<input type="text" name="location_y" value="${busStop.location_y}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>주변건물</td>
		<td>
			<input type="text" name="description" value="${busStop.description}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>등록시간</td>
		<td>
			<input type="text" name="registerDate" value="${busStop.registerDate}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>관리자 id</td>
		<td>
		<input type="text" name="managerId" value="${busStop.managerId}" >
		<%-- <select name="managerId">
				<c:forEach var="manager" items="${managerList}">
					<option value="${manager.managerId}"
						<c:if test="${manager.managerId == busStop.managerId}">selected</c:if>
					>${manager.name}</option>
				</c:forEach>
			</select> --%>
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>사용여부</td>
		<td>
			<input type="radio" value="사용" name="usable" checked>사용
			<input type="radio" value="미사용" name="usable">미사용
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td colspan="2">
			<input type="submit" value="확인">
			<input type="submit" value="취소" onclick="location.href='BusStopList'">
		</td>
	</tr>
</table>
</form>
</body>
</html>