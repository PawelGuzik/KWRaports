package kw.raport.model.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kw.raport.model.ParseKWData;
import kw.raport.model.docxWriter.DocxRaportWriter;
import kw.raport.model.raportData.RaportData;
import kw.raport.model.raportData.owner.EntryBasis;

@WebServlet("/ProcessRaportServlet")
public class ProcessRaportServlet extends HttpServlet{

	private static final long serialVersionUID = 828939869049305931L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		resp.setHeader("Content-disposition", "attachment; filename=Raport.docx");
		
		List<String> selectedEntryBasis = Arrays.asList(req.getParameterValues("selectEntryBasis"));
			
		ParseKWData parseKWData = (ParseKWData) req.getSession().getAttribute("parsingDataObject");
		List<EntryBasis> entryBasis = parseKWData.getRaportData().getMapInformation();
		
				entryBasis.removeIf(n -> (!selectedEntryBasis.contains(n.getTitle())));
			
		RaportData raportData = parseKWData.getRaportData();
			
		try (ByteArrayOutputStream in = DocxRaportWriter.createDocument(raportData);
				OutputStream out = resp.getOutputStream()) {
			
			in.writeTo(out);
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		req.getSession().invalidate();
	}

	
	
	
	
}
