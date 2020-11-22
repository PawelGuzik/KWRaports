package kw.raport.model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import kw.raport.model.raportData.RaportData;
import kw.raport.model.raportData.limitedRights.LimitedRights;
import kw.raport.model.raportData.owner.EntryBasis;
import kw.raport.model.raportData.plotOfLand.PlotOfLand;
import kw.raport.model.utils.OwnerProducer;

public class ParseKWData {
	//Web page saved as HTML
	private File inputPage;
	// RaportData collects data extracted from external web page
	private RaportData raportData;
	//Represents web page as Document
	private Document doc;
	
	public ParseKWData() {
		raportData = new RaportData();
	}

	public ParseKWData(File htmlFileToParse) {
		setInputPageWithFile(htmlFileToParse);
		raportData = new RaportData();

	}
	
	public ParseKWData(String stringHtmlToParse) {
		setInputPageWithString(stringHtmlToParse);
		raportData= new RaportData();
		
	}
	

	// Processes all the data of a particular KW into RaportData object
	public void parse(int sectionNumber) {
		if (sectionNumber == 1) {
			getPlotsNumbersLocationsAndWayToUseFromPageSavedAsHtmlFile();
			getKWNumberFromPageSavedAsHtmlFile();
			getPlaceOfCourtFromPageSavedAsHtmlFile();
			getAreaOfProperty();
			getDateWhenRaportWasGenerated();
			getBasisForEntryInRegister2();
		} else if (sectionNumber == 2) {
			getOwners();
			getOwnerEntryBasis();
		} else if (sectionNumber == 3) {
			getLimitedRights();
			getLimitedRightsentryBasis();
		}
	}

	// Extracts plots numbers contained in the land and mortgage register
	private void getPlotsNumbersLocationsAndWayToUseFromPageSavedAsHtmlFile() {

		raportData.setPlotOfLandList(findAllPlotsOfLand());
	}

	// Extracts number of the land and mortgage register
	private void getKWNumberFromPageSavedAsHtmlFile() {
		Elements header = doc.select("h2");
		raportData.setLandAndMortgageRegisterNumber(header.get(0).text().substring(27, 42));

	}

	// Extracts place of court location
	private void getPlaceOfCourtFromPageSavedAsHtmlFile() {
		Elements header = doc.select("h4");
		String placeOfCourt = header.get(0).text().split("SĄD REJONOWY W ")[1].split(", ")[0];

		raportData.setCourthouse(placeOfCourt);
	}

	// Extracts date when the report was created
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
		raportData.setCreationDate(date);

	}

	// Extracts area of the entire property
	private void getAreaOfProperty() {
		raportData.setRealEstateArea(
				findValuesOfAtributesInCurrentlyOpenSection("Obszar całej nieruchomości", 0).get(0));
	}

	// Finds cells with given attribute name and extracts it's values from
	// neighboring cells in the table
	// columnDistance=0 finds values in the next column, columnDistance=1 finds
	// values in the second column and so on
	private List<String> findValuesOfAtributesInCurrentlyOpenSection(String atribute, int columnDistance) {
		List<String> valuesList = new ArrayList<String>(10);
		Element content = doc.getElementById("contentDzialu");
		Elements tableAtributeNames = content.select("td.csDane");

		for (Element atributeName : tableAtributeNames) {
			if (atributeName.text().contains(atribute)) {
				for (int i = 0; i <= columnDistance; i++) {

					atributeName = atributeName.nextElementSibling();

				}
				valuesList.add(atributeName.text());
			}
		}
		return valuesList;
	}

	private List<PlotOfLand> findAllPlotsOfLand() {
		List<PlotOfLand> plotOfLandList = new ArrayList<PlotOfLand>(10);
		Element content = doc.getElementById("contentDzialu");
		Elements tableAtributeNames = content.select("td.csDane");

		String number = null;
		String location = null;
		String wayToUse = null;
		for (Element atributeName : tableAtributeNames) {

			if (atributeName.text().contains("Numer działki")) {
				number = atributeName.nextElementSibling().text();
				//location = atributeName.parent().nextElementSibling().child(3).text();
				wayToUse = atributeName.parent().nextElementSiblings().get(1).child(1).text();
			}

			if (number != null) {
				PlotOfLand plotOfLand = new PlotOfLand(number, location, wayToUse);
				plotOfLandList.add(plotOfLand);
				number = null;
				location = null;
				wayToUse = null;
			}
		}
		return plotOfLandList;
	}


	@SuppressWarnings("unchecked")
	private <T> void getEntryBasis(List<T> entryBasisList, Elements tableAttributeNames) {

		for (Element element : tableAttributeNames) {

			String[] entryRow = element.text().split("[(]");

			String entryBasisData = entryRow[0];
			List<String> entryBasisDataList = Arrays.asList(entryBasisData.split("[,;]"));

			String entryBasisDescription = entryRow[1];
			List<String> entryBasisDescList = Arrays.asList(entryBasisDescription.split("[,;]"));
			EntryBasis newOwnerEntryBasis = null;

			for (int i = 0; i < entryBasisDescList.size(); i++) {
				String entryDesc = entryBasisDescList.get(i);

				if (entryDesc.contains("tytuł aktu") || entryDesc.contains("wskazanie podstawy") || entryDesc.contains("podstawa oznaczenia")) {

					newOwnerEntryBasis = new EntryBasis(entryBasisDataList.get(i).trim());
				}
				if (newOwnerEntryBasis != null) {
					if (entryDesc.contains("numer rep") || entryDesc.contains("sygnatura")) {
						newOwnerEntryBasis.setRep(entryBasisDataList.get(i).trim());
					}
					if (entryDesc.contains("data sporządzenia") || entryDesc.contains("data wydania")) {
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
						try {
							newOwnerEntryBasis
									.setCreationDate(simpleDateFormat.parse(entryBasisDataList.get(i).trim()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			entryBasisList.add((T) newOwnerEntryBasis);
		}

	}
	
	private Elements getTableAttributeNames() {
		Element content = doc.getElementById("contentDzialu");
		Elements tableAtributeNames = content.select("td.csNDBDane");
		return tableAtributeNames;
		
	}
	
	private void getBasisForEntryInRegister2() {
		List<EntryBasis> lrEntryBasis = new ArrayList<>();
		Elements tableAtributeNames = getTableAttributeNames();
		
		getEntryBasis(lrEntryBasis, tableAtributeNames);
		for (int i =0; i< lrEntryBasis.size(); i++) {
			
			if(!lrEntryBasis.get(i).getTitle().contains("MAPA")) {
				
				lrEntryBasis.remove(i);
				i--;
			}
			
		}
		raportData.setMapInformation(lrEntryBasis);
		
	}

	private void getLimitedRightsentryBasis() {
		List<EntryBasis> lrEntryBasis = new ArrayList<>();
		Elements tableAtributeNames = getTableAttributeNames();

		getEntryBasis(lrEntryBasis, tableAtributeNames);

		raportData.setLimitedRightsEntryBasis(lrEntryBasis);
	}

	private void getOwnerEntryBasis() {
		List<EntryBasis> ownerEntryBasis = new ArrayList<>();
		Elements tableAtributeNames = getTableAttributeNames();

		getEntryBasis(ownerEntryBasis, tableAtributeNames);

		raportData.setOwnerEntryBasis(ownerEntryBasis);
	}

	private void getLimitedRights() {
		List<LimitedRights> limitedRightsList = new ArrayList<LimitedRights>();
		List<String> limitedRightsTypes = findValuesOfAtributesInCurrentlyOpenSection("Rodzaj wpisu", 0);// new
																											// ArrayList<String>();
		List<String> limitedRightsContent = findValuesOfAtributesInCurrentlyOpenSection("Treść wpisu", 0);
		for (int i = 0; i < limitedRightsTypes.size(); i++) {
			LimitedRights limitedRights = new LimitedRights(limitedRightsTypes.get(i), limitedRightsContent.get(i));
			limitedRightsList.add(limitedRights);
		}
		raportData.setLimitedRights(limitedRightsList);
		//System.out.println(findValuesOfAtributesInCurrentlyOpenSection("Rodzaj wpisu", 0).get(0).toString());

	}

	// Returns List with two Strings, first with names of attributes and second with
	// attributes of Owners. Main list represents Owners.
	private List<List<String>> getRawOwnersData() {
		List<List<String>> rawOwnersData = new ArrayList<List<String>>();
		Element content = doc.getElementById("contentDzialu");
		Elements tableContent = content.getElementsContainingOwnText("Właściciele");
		Elements elementsOfTable = tableContent.get(0).parent().parent().parent().nextElementSibling()
				.nextElementSibling().child(0).children();
		for (Element element : elementsOfTable) {
			Element elementLp = element.getElementsContainingOwnText("Lp. ").first();
			if (elementLp != null && !(element.text().contains("Lista ws"))) {
				String description = element.nextElementSibling().nextElementSibling().children().get(0).text();

				String valuesOfOwner = element.nextElementSibling().nextElementSibling().children().get(1).text();

				List<String> ownerData = new ArrayList<String>(2);
				ownerData.add(description);
				ownerData.add(valuesOfOwner);
				rawOwnersData.add(ownerData);
			}

		}
		return rawOwnersData;
	}

	private void getOwners() {
		raportData.setOwners(OwnerProducer.produce(getRawOwnersData()));
	}

	public RaportData getRaportData() {
		return raportData;
	}

	public void setInputPageWithFile(File htmlFileToParse) {
		this.inputPage = htmlFileToParse;
		try {
			doc = Jsoup.parse(inputPage, "UTF-8");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setInputPageWithString(String htmlPage) {
		if(doc!=null) {
			doc=null;
		}
		doc = Jsoup.parse(htmlPage);
		
	}

}
