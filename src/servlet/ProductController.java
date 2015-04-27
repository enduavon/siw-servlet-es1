package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/processa")
public class LeggiParametriProdotto extends HttpServlet {
private static final long serialVersionUID = 1L;
			       
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

	// gestione della RICHIESTA
	// leggo i parametri e li trasformo tutti in maiuscolo
	String nome = request.getParameter("nome").toUpperCase();
	String prezzo = request.getParameter("prezzo").toUpperCase();
	String descrizione = request.getParameter("descrizione").toUpperCase();
	String codice = request.getParameter("codice").toUpperCase();
	
	// metto i valori nella sessione (devo metterli nel confermaparametri?)
			HttpSession session = request.getSession();
			session.setAttribute("NOME", nome);
			session.setAttribute("PREZZO", prezzo);
			session.setAttribute("DESCRIZIONE", descrizione);
			session.setAttribute("CODICE", codice);

	// leggo (alcune) intestazioni http della richiesta
	String address = (String)request.getRemoteAddr();
	String host = (String)request.getRemoteHost(); 
	String userAgent = request.getHeader("User-Agent");
	
	//e li metto nella sessione anch'essi
	session.setAttribute("address", address);
	session.setAttribute("host", host);
	session.setAttribute("userAgent" , userAgent);
	
	//settare gli attributi, così riesco a richiamarli dall'altra servlet tramite getAttribute??
	//cerca su internet la documentazione
	/*
	 * non serve più metterli nella richiesta, perchè ho messo i dati
	 nella sessione
	request.setAttribute("NOME", nome);
	request.setAttribute("PREZZO", prezzo);
	request.setAttribute("DESCRIZIONE", descrizione);
	request.setAttribute("CODICE", codice);
	request.setAttribute("ADDRESS", address);
	request.setAttribute("HOST", host);
	request.setAttribute("USERAGENT", userAgent);
	*/
	
	//mi faccio ritornare le informazioni di tutta l'applicazione (contesto), e invoco
	//il dispatcher, grazie al quale inoltro la richiesta tramite il metodo forward.
	//Quindi in pratica collego la servlet corrente alla servlet di conferma
	ServletContext application  = getServletContext();
	RequestDispatcher rd = application.getRequestDispatcher("/ConfermaParametri.jsp");
	rd.forward(request, response);
	return; 
 	
		}
}
