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
<form name="f" action="BusList" method="post">
	<input type="hidden" name="no" >
	
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td>선로검색</td>
		<td>
			<select name="busNumberId">
					<c:forEach var="bus" items="${BusNumberList}">
						<option value="${bus.busNumberId}">${bus.busNumberId}</option>
					</c:forEach>
			</select>
		</td>
		<td>
			<input type="submit" value="검색">
		</td>
	</tr>
	
</table>	
</form>
</body>
</html>