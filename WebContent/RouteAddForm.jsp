<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
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
		<td>�� �̸�</td>
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
			<input type="button" value="�߰�" onclick="goAdd()">
		</td>
	</tr>
</table>
</form>
</body>
</html>