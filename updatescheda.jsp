<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.SchedaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Scheda</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>
	<div class="navbar">
		<a href="homeadmin.jsp">Home</a> <a href="UserServlet?mode=userlist">Users</a>
		<a class="active" href="SchedaServlet?mode=schedalist">Scheda</a>
		<a href="LogoutServlet" id="logout">Logout</a>
</div>
	<br>
	<div class="main">

		<%SchedaDTO s = (SchedaDTO) request.getAttribute("dto");%>


		<form id="floatleft" action="SchedaServlet?mode=update&id=<%=s.getId_scheda()%>"method="post">
			<div class="row">
				<div class="col-25">
					<label for="id_scheda">Id scheda</label>
				</div>
				<div class="col-75">
					<input readonly="readonly" type="text" id ="id" name="id" placeholder="Id scheda" value="<%=s.getId_scheda()%>">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="user_id">User id</label>
				</div>
				<div class="col-75">
					<input type="text" id ="user_id" name="user_id" placeholder="User id" value="<%=s.getUser_id()%>">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="nome">Tipo_esercizio</label>
				</div>
				<div class="col-75">
					<input type="text" id ="tipo_esercizio" name="tipo_esercizio" placeholder="tipo_esercizio" value="<%=s.getTipo_esercizio()%>">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="cognome">Num_ripetizioni</label>
				</div>
				<div class="col-75">
					<input type="text" id ="num_ripetizioni" name="num_ripetizioni" placeholder="num_ripetizioni" value="<%=s.getNum_ripetizioni()%>">
				</div>
			</div>
			<button type="submit">Salva</button>
		</form>


	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>