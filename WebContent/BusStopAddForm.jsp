<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
<script type="text/javascript">
	function goAdd(){
		f.action="BusStopAdd";
		f.submit();
	}
</script>
</head>
<body>
<form name="f" method="post">
<table border="1" bordercolor="#cd853f">
	<tr bordercolor="#cd853f">
		<td>역ID:</td>
		<td>
			<input type="text" name="stopId">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>역 이름:</td>
		<td>
			<input type="text" name="stopName">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>위치(x):</td>
		<td>
			<input type="text" name="location_x">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>위치(y):</td>
		<td>
			<input type="text" name="location_y">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>주변건물:</td>
		<td>
			<input type="text" name="description">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>등록시간:</td>
		<td>
			<input type="text" name="registerDate">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>관리자 id:</td>
		<%-- <td>
			<select name="managerId">
				<c:forEach var="manager" items="${managerList}">
					<option value="${manager.managerId}">${manager.name}</option>
				</c:forEach>
			</select>
		</td> --%>
		<td>
			<input type="text" name="managerId">
		</td>
	</tr>
	<tr bordercolor="#cd853f">
		<td>사용여부:</td>
		<td>
			<input type="radio" value="사용" name="usable" checked>사용
			<input type="radio" value="미사용" name="usable">미사용
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