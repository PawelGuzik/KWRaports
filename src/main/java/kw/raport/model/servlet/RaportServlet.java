package kw.raport.model.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.mail.util.ByteArrayDataSource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kw.raport.model.ParseKWData;
import kw.raport.model.browser.RunHeadlessBrowser;
import kw.raport.model.browser.utils.Buttons;
import kw.raport.model.docxWriter.DocxRaportWriter;
import kw.raport.model.emailSender.SendAttachment;
import kw.raport.model.raportData.RaportData;

/**
 * Servlet implementation class RaportServlet
 */
@WebServlet("/RaportServlet")
public class RaportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ParseKWData parseKWData;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		// TODO Auto-generated method stub
		String page = "";
		//Send this to ekw.ms.gov
		String kodWydziału = request.getParameter("kodWydzialu").toString();
		String numerKW = request.getParameter("numerKW").toString();
		String cyfraKontrolna = request.getParameter("cyfraKontrolna").toString();
		//Add this to the Raport object
		String author = request.getParameter("author");
		String voivodeship = request.getParameter("voivodeship");
		String county = request.getParameter("county");
		String landRegUnit = request.getParameter("landRegUnit");
		String regPrecinct = request.getParameter("regPrecinct");
		String regPrecinctNumber = request.getParameter("regPrecinctNumber");
		//Create Raportdata object in ParseKW and get it. Add data received from user to RaportDataObject
		parseKWData = new ParseKWData();
		RaportData raportData = parseKWData.getRaportData();
		
		raportData.setAuthor(author);
		raportData.setVoivodenship(voivodeship);
		raportData.setCounty(county);
		raportData.setLandRegistryUnit(landRegUnit);
		raportData.setRegistrationPrecinct(regPrecinct);
		raportData.setRegistrationPrecinctNumber(regPrecinctNumber);
		
		try {
			RunHeadlessBrowser runningBrowser = new RunHeadlessBrowser();
			runningBrowser.runHeadlessBrowser();
			page = runningBrowser.sendValuesToExternalKWForm(kodWydziału, numerKW, cyfraKontrolna);
			
			parseKWData.setInputPageWithString(page);
			parseKWData.parse(1);

			page = runningBrowser.goToSection(Buttons.SEC2);
			parseKWData.setInputPageWithString(page);
			parseKWData.parse(2);

			page = runningBrowser.goToSection(Buttons.SEC3);
			parseKWData.setInputPageWithString(page);
			parseKWData.parse(3);
			
			
			ByteArrayOutputStream byteArrayOutputStream = DocxRaportWriter.createDocument(raportData);
			
			SendAttachment.sendEmailTo("pawel-g2808@wp.pl", byteArrayOutputStream);

			//raportResult = raportData.toString();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("").append("");
	}
	


}
