package tests;


import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import kw.raport.model.ParseKWData;

public class ParseKWDataSectionIUTest {
	static ParseKWData parse;
	
	@BeforeClass
	
	public static void prepareStartingConditions() {
		parse = new ParseKWData("C:\\Users\\Administrator\\Desktop\\dzial1KW.html");
		parse.parse(1);
		System.out.println(parse.getRaportData().toString()); 
	}
	
	@Test
	public void shouldBeSomething() {

		assertTrue(parse.getRaportData().getPlotOfLandList()!=null);
		assertTrue(parse.getRaportData().getPlotOfLandList().size()==2);

		assertTrue(parse.getRaportData().getPlotOfLandList().get(0).getNumber().equals("77/6"));
		assertTrue(parse.getRaportData().getPlotOfLandList().get(1).getNumber().equals("77/7"));	
	}
	
	@Test
	public void shouldReturnKWNumber() {
		assertTrue(parse.getRaportData().getNrKW().equals("PL1Z/00002121/0"));
		
	}
	
	@Test
	public void shouldReturnPlaceOfCourt() {
		assertTrue(parse.getRaportData().getMiejscowoscSadu().equals("ŻYRARDOWIE"));
	}

	@Test
	public void shouldReturnAreaValue(){
		assertTrue(parse.getRaportData().getPolePowierzchni().equals("0,3012 HA"));
	}
	
	@Test
	public void shouldReturnDateOfCreation() throws ParseException {
		assertTrue(parse.getRaportData().getDataUtworzenia().equals(DateUtils.parseDate("2019-12-04", "yyyy-MM-dd")));
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
	public void shouldReturnBasisForTheEntryInRegister() {
		assertTrue(parse.getRaportData().getInfOMapach().size()==9);
		
		
		assertTrue(parse.getRaportData().getInfOMapach().get(0).getName().equals("OPIS I MAPA"));
		assertTrue(parse.getRaportData().getInfOMapach().get(7).getName().equals("MAPA SYTUACYJNA"));
		assertTrue(parse.getRaportData().getInfOMapach().get(7).getDateOfCreation().equals("2004-03-22"));


		

	}
	
	
	
	

}
