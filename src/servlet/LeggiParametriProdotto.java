package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/processaDati")
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

	// leggo (alcune) intestazioni http della richiesta
	String address = (String)request.getRemoteAddr();
	String host = (String)request.getRemoteHost(); 
	String userAgent = request.getHeader("User-Agent");
	
	//settare gli attributi, così riesco a richiamarli dall'altra servlet tramite getAttribute??
	//cerca su internet la documentazione
	request.setAttribute("NOME", nome);
	request.setAttribute("PREZZO", prezzo);
	request.setAttribute("DESCRIZIONE", descrizione);
	request.setAttribute("CODICE", codice);
	request.setAttribute("ADDRESS", address);
	request.setAttribute("HOST", host);
	request.setAttribute("USERAGENT", userAgent);
	
	//mi faccio ritornare le informazioni di tutta l'applicazione (contesto), e invoco
	//il dispatcher, grazie al quale inoltro la richiesta tramite il metodo forward.
	//Quindi in pratica collego le due servlet LeggiParametri e MostraParametri
	ServletContext application  = getServletContext();
	RequestDispatcher rd = application.getRequestDispatcher("/mostraDati");
	rd.forward(request, response);
	return; 
 	
		}
}
