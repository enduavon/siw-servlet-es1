<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dati Prodotto</title>
</head>
<body>
<h1>Dati inseriti nella form</h1>
<ul>
<li>Nome:<b> <% out.println(session.getAttribute("NOME"));%> </b></li>
<li>Prezzo:<b> <% out.println(session.getAttribute("PREZZO"));%> </b></li>
<li>Descrizione:<b> <% out.println(session.getAttribute("DESCRIZIONE"));%> </b></li>
<li>Codice:<b> <% out.println(session.getAttribute("CODICE"));%> </b></li>
</ul>
<h1>Altri dati relativi alla richiesta</h1>
<br />IP: <b> <% out.println(session.getAttribute("address"));%> </b>
<br />Host: <b> <% out.println(session.getAttribute("host"));%> </b>
<br />User Agent: <b> <% out.println(session.getAttribute("userAgent"));%> </b>
</body>
</html>