<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.SchedaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Scheda</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
		<a href="homeadmin.jsp">Home</a> <a href="UserServlet?mode=userlist">Users</a>
		<a class="active" href="SchedaServlet?mode=schedalist">Scheda</a>
		<a href="LogoutServlet" id="logout">Logout</a>
</div>
	
<br>

<div class="main">
<%SchedaDTO s = (SchedaDTO) request.getAttribute("dto");%>

<table>
	<tr> 
				<th>id scheda</th>
				<th>user id</th>
				<th>tipo_esercizio</th>
				<th>num_ripetizioni</th>
	</tr>
	<tr>
		<td><%=s.getId_scheda()%></td>
		<td><%=s.getUser_id()%></td>
		<td><%=s.getTipo_esercizio()%></td>
		<td><%=s.getNum_ripetizioni()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>