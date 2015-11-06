<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
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
			<a href="BusNumberAddForm">�� ��</a>
		</td>
	</tr>

	<tr bordercolor="#cd853f">
		<th>��ȣ��ȣ</th>
		<th>��ȣ�̸�</th>
		<th>ù���ð�</th>
		<th>�����ð�</th>
		<th>��뿩��</th>
		<th>������ID</th>
		<th>��Ͻð�</th>
		<th>�۾�</th>
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
				<input type="button" value="�� ����" onclick="goRouteList('${busNumber.busNumberId}')">
				<input type="button" value="�� ��" onclick="goDelete('${busNumber.busNumberId}')">
			</td>
		</tr>
	</c:forEach>
	<tr bordercolor="#cd853f">
		<td colspan="8" align="right">
			<input type="button" value="�ݱ�" onclick="goReturn()">
		</td>
	</tr>
</table>
</form>
</body>
</html>