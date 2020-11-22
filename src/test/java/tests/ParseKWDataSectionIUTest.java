package tests;


import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.ParseException;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import kw.raport.model.ParseKWData;

public class ParseKWDataSectionIUTest {
	static ParseKWData parse;
	
	
	@BeforeClass
	
	public static void prepareStartingConditions() {
		File file = new File("C:\\Users\\Administrator\\Desktop\\dzial1KW.html");
		parse = new ParseKWData(file);
		
		parse.parse(1);
		System.out.println(parse.getRaportData().toString()); 
	}
	
	@Test
	public void shouldReturnProperSizeOfPoltOfLandList() {

		assertTrue(parse.getRaportData().getPlotOfLandList()!=null);
		assertTrue(parse.getRaportData().getPlotOfLandList().size()==2);

		assertTrue(parse.getRaportData().getPlotOfLandList().get(0).getNumber().equals("77/6"));
		assertTrue(parse.getRaportData().getPlotOfLandList().get(1).getNumber().equals("77/7"));	
	}
	
	@Test
	public void shouldReturnKWNumber() {
		assertTrue(parse.getRaportData().getLandAndMortgageRegisterNumber().equals("PL1Z/00002121/0"));
	}
	
	@Test
	public void shouldReturnPlaceOfCourt() {
		assertTrue(parse.getRaportData().getCourthouse().equals("ŻYRARDOWIE"));
	}

	@Test
	public void shouldReturnAreaValue(){
		assertTrue(parse.getRaportData().getRealEstateArea().equals("0,3012 HA"));
	}
	
	@Test
	public void shouldReturnDateOfCreation() throws ParseException {
		assertTrue(parse.getRaportData().getCreationDate().equals(DateUtils.parseDate("2019-12-04", "yyyy-MM-dd")));
	}
	
	@Test
	public void shouldReturnLocationOfProperty(){
		
		assertTrue(parse.getRaportData().getPlotOfLandList().get(0).getLocation().equals("MAZOWIECKIE, GRODZISKI, ŻABIA WOLA, HUTA ŻABIOWOLSKA"));
		assertTrue(parse.getRaportData().getPlotOfLandList().get(1).getLocation().equals("MAZOWIECKIE, GRODZISKI, ŻABIA WOLA, HUTA ŻABIOWOLSKA"));
	}
	
	@Test 
	public void shouldReturnWayToUseOfProperty() {
		assertTrue(parse.getRaportData().getPlotOfLandList()!=null);
		assertTrue(parse.getRaportData().getPlotOfLandList().get(0).getWayToUse().equals("ZABUDOWANA NIERUCHOMOŚĆ ROLNA"));
		assertTrue(parse.getRaportData().getPlotOfLandList().get(1).getWayToUse().equals("ZABUDOWANA NIERUCHOMOŚĆ ROLNA"));
	}
	
	@Test
	public void shouldReturnBasisForTheEntryInRegister() throws ParseException {
	
		
		assertThat(parse.getRaportData().getMapInformation().size(), equalTo(9));

		assertTrue(parse.getRaportData().getMapInformation().get(0).getTitle().equals("OPIS I MAPA"));
		assertTrue(parse.getRaportData().getMapInformation().get(7).getTitle().equals("MAPA SYTUACYJNA"));
		assertTrue(parse.getRaportData().getMapInformation().get(7).getCreationDate().equals(DateUtils.parseDate("2004-03-22", "yyyy-MM-dd")));
	}
}
