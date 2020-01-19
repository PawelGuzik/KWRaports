package tests;

import static org.junit.Assert.assertThat;

import org.docx4j.openpackaging.exceptions.Docx4JException;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

import kw.raport.model.docxWriter.DocxRaportWriter;

public class DocxRaportWriterUTest {
	
	@Test
	public void ss1() throws Docx4JException {
		DocxRaportWriter w =  new DocxRaportWriter();
		assertThat(DocxRaportWriter.createDocument(), equalTo(0));
	}

}
