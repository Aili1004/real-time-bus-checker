<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
</head>
<body>
<table border="2" width="100%" bgcolor="#ffe4b5" bordercolor="#cd853f">
	<tr height="70px"  bordercolor="#cd853f" >
		<td colspan="2">
			<!-- Header�� ���� ���� -->
			<font face="HY��������M" size="6pt" color="#4169e1">�����ڽý���</font>
			<div style="color:Blue; font-size:30pt"></div>
		<font face="HY��������M" size="6pt" color="#4169e1">������ �̸�: ${manager.name}</font>
		</td>
	</tr>
	<tr height="650px"  bordercolor="#cd853f">
		<td width="200px" align="center" >
			<!-- �޴��� ���� ���� -->
			
			
			<img src="img/a1.png"><br><br><br>
			<a href="ManagerList" ><font face="HY��������M" size="6pt" color="#4169e1">�����ڰ���</font></a>
			<br><br><br><br><br>
			<a href="BusStopList"><font face="HY��������M" size="6pt" color="#4169e1">������</font></a>
			
			<br><br><br><br><br>
			<a href="BusNumberList"><font face="HY��������M" size="6pt" color="#4169e1">���ΰ���</font></a>
			<br><br><br><br>
			<a href="BusListSearch"><font face="HY��������M" size="6pt" color="#4169e1">��������</font></a>
			<br><br><br><br>
			<a href="AdsList"><font face="HY��������M" size="6pt" color="#4169e1">�������</font></a>
			<br><br><br><br>
			
		</td>
		<td valign="top" width="100%" align="center">
			<!-- ������ ���� ���� -->
			<br><br><c:if test="${!empty content}">
				<c:import url="${content}"/>
			</c:if>
			<c:if test="${empty content}">
				
				<p><img src="img/yy.png">
			</c:if>
		</td>
	</tr>
	<tr height="50px"  bordercolor="#cd853f">
		<td colspan="2" align="center" bgcolor="#000000"><font color="#ffffff">
			<!-- Footer�� ���� ���� -->
			�ּ�: �߱� �渲�� ����� �ϻ갡 ������б���п� IT������ 2��4��<br>
			������ ����ó: 4ever_Rocket(go100c@gmail.com, 151-0433-7054)</font>
		</td>
	</tr>
</table>
</body>
</html>