<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserimento prodotto</title>
</head>
<body>
	<form action="productController" method="get">
		<div>
			Nome Prodotto: <input type="text" name="nomeProdotto"
				value="${nomeCorrente}" /> ${nomeError}
		</div>
		<div>
			Prezzo : <input type="text" name="prezzo" value="${prezzoCorrente}" 
			/>  ${prezzoError}
		</div>
		<div>
			Descrizione : <input type="text" name="descrizione" value="${descrizioneCorrente}"
			 /> ${descrizioneError}
		</div>
		<div>
			Codice : <input type="text" name="codice" value="${codiceCorrente}" 
			/> ${codiceError}
		</div>
		<div>
			<input type="submit" name="submit" value="inserisci" />
		</div>
	</form>
</body>
</html>