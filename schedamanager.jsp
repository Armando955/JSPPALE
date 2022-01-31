<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List"
	import="it.contrader.dto.SchedaDTO"
	import="it.contrader.dto.UserDTO"  
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scheda manager</title>
</head>
<body>

	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="homeadmin.jsp">Home</a> <a href="UserServlet?mode=userlist">Users</a>
		<a class="active" href="SchedaServlet?mode=schedalist">Scheda</a>
		<a href="LogoutServlet" id="logout">Logout</a>
	</div>
	
	<div class="main">
		<%
		List<SchedaDTO> list = (List<SchedaDTO>) request.getAttribute("list");
		//List<UserDTO> userList = (List<UserDTO>) request.getAttribute("userList");
		%>

		<br>

		<table>

			<tr>
				<th>Id scheda</th>
				<th>User id</th>
				<th>Tipo esercizio</th>
				<th>Num ripetizioni</th>
								<th></th>
				<th></th>

			</tr>
		<%
		for (SchedaDTO s : list) {
		%>
		<tr>
		    <td><a href=SchedaServlet?mode=read&id=<%=s.getId_scheda()%>><%=s.getId_scheda()%></a></td>
		    <td><%=s.getUser_id()%></td>
			<td><%=s.getTipo_esercizio()%></td>
			<td><%=s.getNum_ripetizioni()%></td>
			<td><a href=SchedaServlet?mode=read&update=true&id=<%=s.getId_scheda()%>>Edit</a></td>
			<td><a href=SchedaServlet?mode=delete&id=<%=s.getId_scheda()%>>Delete</a></td>

		</tr>
		<%
		}
		%>
		</table>
		
		<form id="floatright" action="SchedaServlet?mode=insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="type">Utente</label>
				</div>
				<div class="col-75">
					<input type="text" id="type" name="user_id" placeholder="user_id">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="tipo_esercizio">tipo esercizio</label>
				</div>
				<div class="col-75">
					<input type="text" id="tipo_esercizio" name="tipo_esercizio" placeholder="tipo_esercizio">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="num_ripetizioni">num ripetizioni</label>
				</div>
				<div class="col-75">
					<input type="text" id="num_ripetizioni" name="num_ripetizioni" placeholder="num_ripetizioni">
				</div>
			</div>
			<button type="submit">Insert</button>
			<button type="reset">Reset</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>