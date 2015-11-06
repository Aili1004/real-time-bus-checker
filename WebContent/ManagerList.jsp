<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>

<script type="text/javascript">
	function goUpdate(no) {
		f.no.value = no;
		f.action = "ManagerUpdateForm";
		f.submit();
	}

	function goDelete(no) {
		ret = confirm('you sure?');
		if (!ret)
			return;

		f.no.value = no;
		f.action = "ManagerDelete";
		f.submit();
	}
	
	function goReturn() {
	
		f.action = "TemplatePage.jsp";
		f.submit();
	}
</script>
</head>
<body>



	<form name="f" method="post">
		<input type="hidden" name="no">

		<table border="1" bordercolor="#cd853f">
		
			<tr bordercolor="#cd853f">
				<td colspan="10" align="right"><a href="ManagerAddForm">�� ��</a></td>
			</tr>
			<tr bordercolor="#cd853f">
				
				<th>������ID</th>
				<th>�̸�</th>
				<th>�ź�����ȣ</th>
				<th>��ȭ��ȣ</th>
				<th>�ּ�</th>
				<th>�����ڿ���</th>
				<th>��뿩��</th>
				<th>�۾�</th>
				<th></th>
			</tr>
			<c:forEach var="manager" items="${ManagerList}" >
			
				<tr bordercolor="#cd853f">
					
					<td>${manager.managerId}</td>
					<td>${manager.name}</td>
					<td>${manager.identification}</td>
					<td>${manager.phone}</td>
					<td>${manager.address}</td>
					<td>${manager.degree}</td>
					<td>${manager.usable}</td>
					
					<td colspan="2"><input type="button" value="�� ��" onclick="goUpdate(${manager.managerId})">
						 <input type="button" value="�� ��" onclick="goDelete(${manager.managerId})">
						 </td>
				</tr>
				
			</c:forEach>
			
			<tr bordercolor="#cd853f">
				<td colspan="10" align="right">
					<input type="button" value="�ݱ�" onclick="goReturn()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>