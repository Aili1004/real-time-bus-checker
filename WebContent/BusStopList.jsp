<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
<script type="text/javascript">
	function goDetail(no){
		f.no.value=no;
		f.action="BusStopDetail";
		f.submit();
	}
	
	function goDelete(no){
		ret = confirm('you sure?');
		if(!ret) return;
		
		f.no.value=no;
		f.action="BusStopDelete";
		f.submit();
	}
	function goReturn(){
		
		f.action="TemplatePage.jsp";
		f.submit();
	}
</script>
</head>
<body>
<form name="f" method="post">
	<input type="hidden" name="no">
	
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td colspan="9" align="right">
			<a href="BusStopAddForm">추 가</a>
		</td>
	</tr>

	<tr bordercolor="#cd853f">
		<th>역ID</th>
		<th>이름</th>
		<th>사용여부</th>
		<th>위치(x)</th>
		<th>위치(y)</th>
		<th>설명</th>
		<th>등록시간</th>
		<th>관리자이름</th>
		<th>작업</th>
	</tr>
	
	<c:forEach var="busStop" items="${busStopList}">
		<tr bordercolor="#cd853f">
			<td>${busStop.stopId}</td>
			<td>${busStop.stopName}</td>
			<td>${busStop.usable}</td>
			<td>${busStop.location_x}</td>
			<td>${busStop.location_y}</td>
			<td>${busStop.description}</td>
			<td>${busStop.registerDate}</td>
			<td>${busStop.manager.name}</td>
			<td>
				<input type="button" value="상세정보" onclick="goDetail('${busStop.stopId}')">
				<input type="button" value="삭 제" onclick="goDelete('${busStop.stopId}')">
			</td>
		</tr>
	</c:forEach>
	<tr bordercolor="#cd853f">
		<td colspan="9" align="right">
			<input type="button" value="닫기" onclick="goReturn()">
		</td>
	</tr>
</table>
</form>
</body>
</html>