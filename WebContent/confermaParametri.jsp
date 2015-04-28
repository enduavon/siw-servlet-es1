<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mostra parametri</title>
</head>
<body>
<h1>Dati inseriti nella form</h1>
<ul>
<li>Nome:<b> ${nomeCorrente} </b></li>
<li>Prezzo:<b> ${prezzoCorrente} </b></li>
<li>Descrizione:<b> ${descrizioneCorrente} </b></li>
<li>Codice:<b> ${codiceCorrente} </b></li>
</ul>
<h2>Scegli:</h2>
<ul>
<li><a href= "<c:url value="/mostraParametri.jsp"/>" >Conferma i dati inseriti</a></li>
<li><a href= "<c:url value="/newProduct.jsp"/>"      >Torna all'inserimento</a></li>
</ul>
</body>
</html>