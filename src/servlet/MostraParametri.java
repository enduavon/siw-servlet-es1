package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraDati")
public class MostraParametri extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	// gestione della RISPOSTA (prima era stata affidata alla classe LeggiParametri) 
	
		// preparo il tipo (HTML)
				response.setContentType("text/html");
			    	// preparo un oggetto su cui scrivere la risposta
			    	PrintWriter out = response.getWriter();

			    	// scrivo il corpo
			    	out.println("<!DOCTYPE html>"); out.println("<html>");
			    	out.println("<head>");
			    	out.println("<meta charset=\"ISO-8859-1\" />");
			    	out.println("<title>mostra dati prodotto</title>");
			    	out.println("</head>");
			    	out.println("<body>");
			    	out.println("<h1>Dati inseriti nella form</h1>");
			    	out.println("<ul>");
			    	out.println("<li>Nome: <b>" + request.getAttribute("NOME")+ "</b></li>");
			    	out.println("<li>Prezzo: <b>" + request.getAttribute("PREZZO")+"</b></li>");
			    	out.println("<li>Descrizione: <b>" + request.getAttribute("DESCRIZIONE")+"</b></li>");
			    	out.println("<li>Codice: <b>" + request.getAttribute("CODICE")+"</b></li>");
			    	out.println("</ul>");
			    	out.println("<h1>Altri dati relativi alla richiesta</h1>");
			    	out.println("<br />IP: <b>" + request.getAttribute("ADDRESS")+"</b>");
			    	out.println("<br />Host: <b>" + request.getAttribute("HOST")+"</b>");
			    	out.println("<br />User Agent: <b>" + request.getAttribute("USERAGENT")+"</b>");
			    	out.println("</body>\n</html> ");
			    	out.println("<h2>mynjnj</h2>");
			}
}
