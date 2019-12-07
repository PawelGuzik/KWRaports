package kw.raport.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kw.raport.model.browser.RunHeadlessBrowser;

/**
 * Servlet implementation class RaportServlet
 */
@WebServlet("/RaportServlet")
public class RaportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = "";
		String kodWydziału = request.getParameter("kodWydzialu").toString();
		String numerKW = request.getParameter("numerKW").toString();
		String cyfraKontrolna = request.getParameter("cyfraKontrolna").toString();
		try {
			RunHeadlessBrowser runningBrowser = new RunHeadlessBrowser();
			runningBrowser.runHeadlessBrowser();
			page = runningBrowser.sendValuesToExternalKWForm(kodWydziału, numerKW, cyfraKontrolna);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("").append(page);
	}

}
