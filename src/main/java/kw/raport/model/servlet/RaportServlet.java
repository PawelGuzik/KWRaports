package kw.raport.model.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kw.raport.model.ParseKWData;
import kw.raport.model.browser.RunHeadlessBrowser;
import kw.raport.model.browser.utils.Buttons;
import kw.raport.model.docxWriter.DocxRaportWriter;
import kw.raport.model.raportData.RaportData;
import kw.raport.model.utils.ContolNumberCalc;

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
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		;
		ParseKWData parseKWData;
		// TODO Auto-generated method stub
		String page = "";
		// Send this to ekw.ms.gov
		String kodWydziału = request.getParameter("kodWydzialu").toString();
		String numerKW = request.getParameter("numerKW").toString();
		String cyfraKontrolna = request.getParameter("cyfraKontrolna").toString();
		// Add this to the Raport object
		String author = request.getParameter("author");
		String voivodeship = request.getParameter("voivodeship");
		String county = request.getParameter("county");
		String landRegUnit = request.getParameter("landRegUnit");
		String regPrecinct = request.getParameter("regPrecinct");
		String regPrecinctNumber = request.getParameter("regPrecinctNumber");
		// Create Raportdata object in ParseKW and get it. Add data received from user
		// to RaportDataObject
		parseKWData = new ParseKWData();
		RaportData raportData = parseKWData.getRaportData();
		
		if(!checkInputValues(kodWydziału, numerKW, cyfraKontrolna)) {
			resp.setContentType("text/xml");
			request.setAttribute("invalidNumber", true);
			request.getRequestDispatcher("/formWithAlert.jsp").forward(request, resp);
			
			return;
			
		}
		
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
			
			if(page.contains("nie została odnaleziona")) {
				request.getRequestDispatcher("/noDataFound.jsp").forward(request, resp);
			}
			
			parseKWData.setInputPageWithString(page);
			parseKWData.parse(1);
			
			page = runningBrowser.goToSection(Buttons.SEC2);
			parseKWData.setInputPageWithString(page);
			parseKWData.parse(2);

			page = runningBrowser.goToSection(Buttons.SEC3);
			parseKWData.setInputPageWithString(page);
			parseKWData.parse(3);
			
			if(raportData.getMapInformation().size()>1) {
				request.getSession().setAttribute("parsingDataObject", parseKWData);
				request.setAttribute("itemsList", parseKWData.getRaportData().getMapInformation());
				request.getRequestDispatcher("/chooseMapInfo.jsp").forward(request, resp);
				return;
			}

			resp.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
			resp.setHeader("Content-disposition", "attachment; filename=Raport.docx");
			
			try (ByteArrayOutputStream in = DocxRaportWriter.createDocument(raportData);
					OutputStream out = resp.getOutputStream()) {

				in.writeTo(out);

			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// resp.getWriter().append("").append("");
	}
	
	

	private boolean checkInputValues(String code, String kwNumber, String controlNumber) {
		if (isDigit(controlNumber)) {
			return ContolNumberCalc.isCorrect(code, kwNumber, Integer.parseInt(controlNumber));
		} else {
			return false;
		}

	}

	private boolean isDigit(String someString) {
		if (someString == null) {
			return false;
		}
		try {
			double d = Integer.parseInt(someString);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
