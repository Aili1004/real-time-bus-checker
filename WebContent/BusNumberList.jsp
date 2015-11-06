<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
<script type="text/javascript">
	function goRouteList(busNumberId){
		f.no.value=busNumberId;
		f.action="RouteList";
		f.submit();
	}
	
	function goDelete(no){
		ret = confirm('you sure?');
		if(!ret) return;
		
		f.no.value=no;
		f.action="BusNumberDelete";
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
		<td colspan="8" align="right">
			<a href="BusNumberAddForm">추 가</a>
		</td>
	</tr>

	<tr bordercolor="#cd853f">
		<th>선호번호</th>
		<th>선호이름</th>
		<th>첫차시간</th>
		<th>막차시간</th>
		<th>사용여부</th>
		<th>관리자ID</th>
		<th>등록시간</th>
		<th>작업</th>
	</tr>
	
	<c:forEach var="busNumber" items="${busNumberList}">
		<tr bordercolor="#cd853f">
			<td>${busNumber.busNumberId}</td>
			<td>${busNumber.busNumberName}</td>
			<td>${busNumber.firstTime}</td>
			<td>${busNumber.lastTime}</td>
			<td>${busNumber.usable}</td>
			<td>${busNumber.managerId}</td>
			<td>${busNumber.registerDate}</td>
			<td>
				<input type="button" value="역 보기" onclick="goRouteList('${busNumber.busNumberId}')">
				<input type="button" value="삭 제" onclick="goDelete('${busNumber.busNumberId}')">
			</td>
		</tr>
	</c:forEach>
	<tr bordercolor="#cd853f">
		<td colspan="8" align="right">
			<input type="button" value="닫기" onclick="goReturn()">
		</td>
	</tr>
</table>
</form>
</body>
</html>