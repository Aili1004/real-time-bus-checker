<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
<script type="text/javascript">
	function goAdd(){
		f.action="RouteAdd";
		f.submit();
	}
</script>
</head>
<body>
<form name="f" method="post">
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td>역 이름</td>
		<td>
			<select name="stopId">
				<c:forEach var="busStop" items="${busStopList}">
					<option value="${busStop.stopId}">${busStop.stopName}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	
	<tr bordercolor="#cd853f">
		<td colspan="2">
			<input type="button" value="추가" onclick="goAdd()">
		</td>
	</tr>
</table>
</form>
</body>
</html>