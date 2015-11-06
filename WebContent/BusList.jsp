<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
<script language="JavaScript">

function myrefresh(){
window.location.reload();

}

setTimeout('myrefresh()',3000);

</script>

<script type="text/javascript">




	function goBusUpdate(no){
		f.no.value=no;
		f.action="BusUpdateForm";
		f.submit();
	}
	
	function goBusDelete(no){
		ret = confirm('you sure?');
		if(!ret) return;
		
		f.no.value=no;
		f.action="BusDelete";
		f.submit();
	}
	
	function goBusAdd(){
		f.action="BusAddForm";
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
	</form>
	<table border="1" bordercolor="#cd853f">
		<tr bordercolor="#cd853f">
			<th>����ID</th>
			<th>��ȣ��</th>
			<th>����</th>
			<th>��ġ(x)</th>
			<th>��ġ(y)</th>
			<th>updateTime</th>
			<th>routeId</th>
			<th>���ι�ȣ</th>
			<th>�۾�</th>
		</tr>

		<c:forEach var="bus" items="${searchList}">
			<tr bordercolor="#cd853f">
				<td>${bus.busId}</td>
				<td>${bus.plateNumber}</td>
				<td>${bus.status}</td>
				<td>${bus.position_x}</td>
				<td>${bus.position_y}</td>
				<td>${bus.updateTime}</td>
				<td>${bus.routeId}</td>
				<td>${bus.busNumberId}</td>
				<td><input type="button" value="����"
					onclick="goBusUpdate(${bus.busId})"> <input type="button"
					value="����" onclick="goBusDelete(${bus.busId})"></td>
		</c:forEach>

		<tr bordercolor="#cd853f">
			<td colspan="10" align="center"><input type="button" value="�߰�"
				onclick="goBusAdd()"> <input type="button" value="�ݱ�"
				onclick="goReturn()"></td>
		</tr>

	</table>
</body>
</html>