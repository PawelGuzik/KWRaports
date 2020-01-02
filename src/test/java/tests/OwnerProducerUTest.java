package tests;

import static kw.raport.model.utils.OwnerProducer.produce;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kw.raport.model.raportData.owner.Owner;;

public class OwnerProducerUTest {
	
	private static List<List<String>> rawOwners;
	
	@Before
	public void setRawOwnersList() {
		rawOwners = new ArrayList<List<String>>();
		List<String> user1 = new ArrayList<String>();
		user1.add("Osoba fizyczna (Imię pierwsze imię drugie nazwisko, imię ojca, imię matki)");
		user1.add("JADWIGA JOANNA GÓRNIEWICZ, RYSZARD, WACŁAWA");
		rawOwners.add(user1);
		
		List<String> user2 = new ArrayList<String>();
		user2.add("Osoba fizyczna (Imię pierwsze imię drugie nazwisko, imię ojca, imię matki, PESEL)");
		user2.add("JADWIGA JOANNA GÓRNIEWICZ, RYSZARD, WACŁAWA, 52801100587");
		rawOwners.add(user2);
	}
	
	@Test
	public void shouldReturnOwnersWithProperData() {
		List<Owner> owners = produce(rawOwners);
		assertThat(owners, is(notNullValue()));
		
		assertThat(owners.get(0).getName(), equalTo("JADWIGA"));
		assertThat(owners.get(0).getSecondName(), equalTo("JOANNA"));
		assertThat(owners.get(0).getSurname(), equalTo("GÓRNIEWICZ"));
		assertThat(owners.get(0).getNamesOfParents(), equalTo("RYSZARD, WACŁAWA"));
		assertThat(owners.get(0).getNumberOfPesel(), equalTo(0L));
		
		assertThat(owners.get(1).getName(), equalTo("JADWIGA"));
		assertThat(owners.get(1).getSecondName(), equalTo("JOANNA"));
		assertThat(owners.get(1).getSurname(), equalTo("GÓRNIEWICZ"));
		assertThat(owners.get(1).getNamesOfParents(), equalTo("RYSZARD, WACŁAWA"));
		assertThat(owners.get(1).getNumberOfPesel(), equalTo(52801100587L));
		
		
	}
	
}
