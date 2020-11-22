package tests;

import static org.junit.Assert.assertThat;

import java.io.File;

import org.docx4j.openpackaging.exceptions.Docx4JException;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

import kw.raport.model.ParseKWData;
import kw.raport.model.docxWriter.DocxRaportWriter;
import kw.raport.model.raportData.RaportData;

public class DocxRaportWriterUTest {
	
	@Test
	public void ss1() throws Docx4JException {
		File file = new File("C:\\Users\\Administrator\\Desktop\\dzial1KW.html");
		ParseKWData parseKWData = new ParseKWData(file);
		parseKWData.parse(1);
		RaportData raportData = parseKWData.getRaportData();
		
		assertThat(DocxRaportWriter.createDocument(raportData), equalTo(0));
	}

}
