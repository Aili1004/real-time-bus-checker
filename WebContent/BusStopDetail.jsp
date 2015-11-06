<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
<script type="text/javascript">
	function goUpdate(no){
		f.no.value=no;
		f.action="BusStopUpdateForm";
		f.submit();
	}
	
	function goCancel(no){
		f.no.value=no;
		f.action="BusStopList";
		f.submit();
	}
</script>
</head>
<body>
<form name="f" >
	<input type="hidden" name="no">
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td>역ID</td>
		<td>${busStop.stopId}
			<input type="hidden" name="stopId" value="${busStop.stopId}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>역 이름</td>
		<td>${busStop.stopName}
			<input type="hidden" name="stopName" value="${busStop.stopName}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>위치(x)</td>
		<td>${busStop.location_x}
			<input type="hidden" name="location_x" value="${busStop.location_x}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>위치(y)</td>
		<td>${busStop.location_y}
			<input type="hidden" name="location_y" value="${busStop.location_y}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>주변건물</td>
		<td>${busStop.description}
			<input type="hidden" name="description" value="${busStop.description}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>등록시간</td>
		<td>${busStop.registerDate}
			<input type="hidden" name="registerDate" value="${busStop.registerDate}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>관리자 이름</td>
		<td>${busStop.manager.name}
			<input type="hidden" name="managerName" value="${busStop.manager.name}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td>사용여부</td>
		<td>${busStop.usable}
			<input type="hidden" name="usable" value="${busStop.usable}">
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td colspan="2">
			<input type="button" value="수정" onclick="goUpdate(${busStop.stopId})">
			<input type="button" value="취소" onclick="goCancel()">
		</td>
	</tr>
</table>
</form>
</body>
</html>