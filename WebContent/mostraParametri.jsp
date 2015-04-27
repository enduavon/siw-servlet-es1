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
<li>Nome:<b> ${nomeCorrente} </b></li>
<li>Prezzo:<b> ${prezzoCorrente} </b></li>
<li>Descrizione:<b> ${descrizioneCorrente} </b></li>
<li>Codice:<b> ${codiceCorrente} </b></li>
</ul>
<h1>Altri dati relativi alla richiesta</h1>
<br />IP: <b> ${address} </b>
<br />Host: <b> ${host} </b>
<br />User Agent: <b> ${userAgent} </b>
</body>
</html>