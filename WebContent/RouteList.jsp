<%@page import="dao.BusStopDAO"%>
<%@page import="entity.BusStopEntity"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
<script type="text/javascript">
	
	function goRouteDelete(no){
		ret = confirm('you sure?');
		if(!ret) return;
		
		f.no.value=no;
		f.action="RouteDelete";
		f.submit();
	}
	function goCancel(no){
		f.no.value=no;
		f.action="BusNumberList";
		f.submit();
	}
</script>
</head>
<body>
<form name="f">
<input type="hidden" name="no">
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td colspan="3" align="right">
			<a href="RouteAddForm">추가</a>
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		
		<th>역 이름</th>
		<th>작업</th>
	</tr>
		<c:forEach var="stop" items="${stopList}">
		<tr bordercolor="#cd853f">
			
			<td>${stop.stopName}</td>
			<td>
				<input type="button" value="삭제" onclick="goRouteDelete('${stop.stopId}')">
			</td></tr>
		</c:forEach>
		
		<tr bordercolor="#cd853f">
			<td colspan="3">
				<input type="submit" value="취소" onclick="goCancel()">
			</td>
		</tr>
</table>
</form>
</body>
</html>