package kw.raport.model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Detainted;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParseKWData {

	private File inputPage;

	private RaportData raportData;

	private Document doc;

	public ParseKWData(String htmlFileToParse) {
		setInputPage(htmlFileToParse);
		raportData = new RaportData();
		try {
			doc = Jsoup.parse(inputPage, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Processes all the data of a particular KW into RaportData object
	public void parse() {
		getPlotsNumbersFromPageSavedAsHtmlFile();
		getKWNumberFromPageSavedAsHtmlFile();
		getPlaceOfCourtFromPageSavedAsHtmlFile();
		getAreaOfProperty();
		getDateWhenRaportWasGenerated();
	}

	// Extracts plots numbers w contained in the land and mortgage register
	private void getPlotsNumbersFromPageSavedAsHtmlFile() {

		raportData.setNryDzialek(findValuesOfAtributesInCurrentlyOpenSection("Numer działki"));

	}

	private void getKWNumberFromPageSavedAsHtmlFile() {
		Elements header = doc.select("h2");
		raportData.setNrKW(header.get(0).text().substring(27, 42));

	}

	private void getPlaceOfCourtFromPageSavedAsHtmlFile() {
		Elements header = doc.select("h4");
		String placeOfCourt = header.get(0).text().split("SĄD REJONOWY W ")[1].split(", ")[0];

		raportData.setMiejscowoscSadu(placeOfCourt);
	}

	private void getDateWhenRaportWasGenerated() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Elements header = doc.select("h2");
		// String dateString = format.format( new Date() );
		Date date = null;
		String dateFromPage = null;
		try {
			dateFromPage = header.get(0).text().split("STAN Z DNIA ")[1].substring(0, 10);
			date = format.parse(dateFromPage);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		raportData.setDataUtworzenia(date);

	}

	private void getAreaOfProperty() {
		findValuesOfAtributesInCurrentlyOpenSection("Obszar całej nieruchomości");
		raportData.setPolePowierzchni(findValuesOfAtributesInCurrentlyOpenSection("Obszar całej nieruchomości").get(0));
	}

	private List<String> findValuesOfAtributesInCurrentlyOpenSection(String atribute) {
		List<String> valuesList = new ArrayList<String>(10);
		Element content = doc.getElementById("contentDzialu");
		Elements tableAtributeNames = content.select("td.csDane");
		for (Element atributeName : tableAtributeNames) {
			if (atributeName.text().contains(atribute)) {
				valuesList.add(atributeName.nextElementSibling().text());
			}
		}
		return valuesList;
	}

	public RaportData getRaportData() {
		return raportData;
	}

	public void setInputPage(String htmlFileToParse) {
		this.inputPage = new File(htmlFileToParse);
	}

}
