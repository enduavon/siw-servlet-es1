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


@WebServlet("/productController")
public class ProductController extends HttpServlet {
private static final long serialVersionUID = 1L;
			       
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	
	boolean errori = false;
	String nextPage = "/confermaParametri.jsp";
			
	// gestione della RICHIESTA
	// leggo i parametri 
	String nome = request.getParameter("nomeProdotto");
	String prezzo = request.getParameter("prezzo");
	String descrizione = request.getParameter("descrizione");
	String codice = request.getParameter("codice");
	
	// metto i valori nella sessione (devo metterli nel confermaparametri?)
			HttpSession session = request.getSession();
			session.setAttribute("nomeCorrente", nome);
			session.setAttribute("prezzoCorrente", prezzo);
			session.setAttribute("descrizioneCorrente", descrizione);
			session.setAttribute("codiceCorrente", codice);

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
	
	
	/*Controllo se ogni parametro immesso è valido (non deve essere 
	 * vuoto). Se è così, allora vado alla pagina successiva,
	 * altrimenti, se c'è un errore, torno alla pagina di inserimento.
	 */
	if(nome.isEmpty()) {
		errori=true;
		request.setAttribute("nomeError", "Campo obbligatorio!");
	}
	
	 try {
         Double.parseDouble(prezzo);
     } catch(Exception e) {
         errori=true;
         request.setAttribute("prezzoError","Deve essere un numero.");
     }

     if(descrizione.isEmpty()) {
         errori=true;
         request.setAttribute("descrizioneError","Campo Obbligatorio!");
     }

     if(codice.isEmpty()) {
         errori=true;
         request.setAttribute("codiceError","Campo Obbligatorio!");
     }
     
     if (errori) {
		nextPage = "/newProduct.jsp";
		}
	
	
	//mi faccio ritornare le informazioni di tutta l'applicazione (contesto), e invoco
	//il dispatcher, grazie al quale inoltro la richiesta tramite il metodo forward.
	//Quindi in pratica collego la servlet corrente alla servlet di conferma
	ServletContext application  = getServletContext();
	RequestDispatcher rd = application.getRequestDispatcher(nextPage);
	rd.forward(request, response);
	
		}
}
