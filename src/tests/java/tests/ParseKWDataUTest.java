package tests;


import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import kw.raport.model.ParseKWData;

public class ParseKWDataUTest {
	static ParseKWData parse;
	
	@BeforeClass
	public static void prepareStartingConditions() {
		parse = new ParseKWData("C:\\Users\\Administrator\\Desktop\\dzial1KW.html");
		parse.parse();
	}
	
	@Test
	public void shouldBeSomething() {

		assertTrue(parse.getRaportData().getNryDzialek() !=null);

		assertTrue(parse.getRaportData().getNryDzialek().get(0).equals("77/6"));
		assertTrue(parse.getRaportData().getNryDzialek().get(1).equals("77/7"));	
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
	
	

}
