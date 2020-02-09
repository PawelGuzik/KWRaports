package tests;


import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

import java.io.File;
import java.text.ParseException;

import org.apache.commons.lang3.time.DateUtils;

import static org.hamcrest.MatcherAssert.assertThat;

import kw.raport.model.ParseKWData;

public class ParseKWDataSectionIIIUTest {
	static ParseKWData parse;

	@BeforeClass

	public static void prepareStartingConditions() {
		File file = new File("C:\\Users\\Administrator\\Desktop\\dzial3KW.html");
		parse = new ParseKWData(file);
		
		parse.parse(3);
		
	}

	@Test
	public void sizeOfLimitedRightsShouldBe2() {
		assertThat(parse.getRaportData().getLimitedRights().size(), equalTo(2));
	}
	
	@Test
	public void shouldReturnProperTypeOfLaw() {
		assertThat(parse.getRaportData().getLimitedRights().get(0).getRightsType(), equalTo("INNY WPIS"));
		assertThat(parse.getRaportData().getLimitedRights().get(1).getRightsType(), equalTo("INNY WPIS"));

	}
	
	@Test
	public void shouldReturnProperContentOfLaw() {
		assertThat(parse.getRaportData().getLimitedRights().get(0).getContent(), equalTo("WSZYSTKIE CIĘŻARY" +
				" CIĄŻĄCE NA LOKALACH WYDZIELONYCH Z NIERUCHOMOŚCI CIĄŻĄ NA PRZYNALEŻNYCH DO NICH UDZIAŁACH WE WSPÓŁWŁASNOŚCI"));
		assertThat(parse.getRaportData().getLimitedRights().get(1).getContent(), equalTo("ZARZĄD WSPÓLNĄ NIERUCHOMOŚCIĄ SPRAWOWAĆ BĘDZIE WŁAŚCICIEL LOKALU NR 2"));
	}
	
	@Test
	public void shouldReturnProperBasisForLimitedRights() throws ParseException {
		assertThat(parse.getRaportData().getLimitedRightsEntryBasis().get(0).getTitle(), equalTo("UMOWA"));
		assertThat(parse.getRaportData().getLimitedRightsEntryBasis().get(0).getRep(), equalTo("897/81"));
		assertThat(parse.getRaportData().getLimitedRightsEntryBasis().get(0).getCreationDate(), equalTo(DateUtils.parseDate("1981-04-16", "yyyy-MM-dd")));
	
	}
}
