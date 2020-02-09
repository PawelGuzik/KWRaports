package tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.ParseException;

import org.apache.commons.lang3.time.DateUtils;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import kw.raport.model.ParseKWData;
import kw.raport.model.raportData.owner.Owner;
import kw.raport.model.raportData.owner.EntryBasis;

public class ParseKWDataSectionIITest {
static ParseKWData parse;
	
	@BeforeClass
	public static void prepareStartingConditions() {
		File file = new File("C:\\Users\\Administrator\\Desktop\\dzial2KW.html");
		parse = new ParseKWData(file);
		parse.parse(2);
	}
	
	@Test
	public void shouldReturnRawOwnersData() {
		assertTrue(parse.getRaportData().toString()!=null);
		assertThat(parse.getRaportData().getOwners().get(0).getName(), equalTo("JADWIGA"));
	}
	 
	@Test 
	public void shouldReturnProperOwnersData() {
		
		Owner owner1 = parse.getRaportData().getOwners().get(0);
		assertThat(owner1.getName(), equalTo("JADWIGA"));
		assertThat(owner1.getSecondName(), equalTo("JOLANTA"));
		assertThat(owner1.getSurname(), equalTo("GÓRNIEWSKA"));
		assertThat(owner1.getNamesOfParents(), equalTo("RYSZARD, WACŁAWA"));
		assertThat(owner1.getNumberOfPesel(), equalTo(0L));

		Owner owner4 = parse.getRaportData().getOwners().get(3);
		assertThat(owner4.getName(), equalTo("MARIUSZ"));
		assertThat(owner4.getSecondName(), equalTo("ŁUKASZ"));
		assertThat(owner4.getSurname(), equalTo("GÓRNIEWSKI"));
		assertThat(owner4.getNamesOfParents(), equalTo("STANISŁAW, JADWIGA"));
		assertThat(owner4.getNumberOfPesel(), equalTo(83012206958L));

	}
	
	@Test
	public void sizeOfOwnersListShouldBe4() {
		assertThat(parse.getRaportData().getOwners().size(), equalTo(4));
	}
	
	@Test 
	public void sizeOfOwnerEntryBasisListShouldBe2(){
		assertThat(parse.getRaportData().getOwnerEntryBasis().size(), equalTo(2));
	}
	
	@Test
	public void shouldReturnProperDataFromsavedPage() throws ParseException {
		
		EntryBasis ownerEntryBasis = parse.getRaportData().getOwnerEntryBasis().get(0);
		assertThat(ownerEntryBasis.getTitle(), equalTo("UMOWA PRZEKAZANIA GOSPODARSTWA ROLNEGO"));
		assertThat(ownerEntryBasis.getRep(), equalTo("348/88"));
		assertThat(ownerEntryBasis.getCreationDate(), equalTo(DateUtils.parseDate("1988-01-27", "yyyy-MM-dd")));
		
		EntryBasis ownerEntryBasis2 = parse.getRaportData().getOwnerEntryBasis().get(1);
		assertThat(ownerEntryBasis2.getTitle(), equalTo("AKT POŚWIADCZENIA DZIEDZICZENIA"));
		assertThat(ownerEntryBasis2.getRep(), equalTo("REPRTORIUM A NR 2582/2018"));
		assertThat(ownerEntryBasis2.getCreationDate(), equalTo(DateUtils.parseDate("2018-08-09", "yyyy-MM-dd")));

	}
	
}
