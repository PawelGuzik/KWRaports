package kw.raport.model.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kw.raport.model.raportData.owner.Owner;

public class OwnerProducer {

//Creates a list of owners based on raw data
	public static List<Owner> produce(List<List<String>> rawOwners) {
		List<Owner> owners = new ArrayList<Owner>();
		for (List<String> list : rawOwners) {
			Owner owner = new Owner();
			List<String> listOfAttributeNames = new ArrayList<String>(Arrays.asList(list.get(0).split("[,()]")));
			List<String> listOfAttributeValues = Arrays.asList(list.get(1).split("[,()]"));

			if (listOfAttributeNames.get(0).contains("Osoba fizyczna")) {
				listOfAttributeNames.remove(0);
				List<String> nameSecameSurname = Arrays.asList(listOfAttributeValues.get(0).split("[ ]"));

				owner.setName(nameSecameSurname.get(0));
				if (listOfAttributeNames.get(0).contains("Imię pierwsze imię drugie nazwisko")) {
					owner.setSecondName(nameSecameSurname.get(1));
					owner.setSurname(nameSecameSurname.get(2));
				} else if (listOfAttributeNames.get(0).contains("Imię pierwsze nazwisko")) {
					owner.setSurname(nameSecameSurname.get(1));
				}
				if (listOfAttributeNames.get(1).contains("imię ojca")) {
					owner.setNamesOfParents(listOfAttributeValues.get(1).trim());
				}
				if (listOfAttributeNames.get(2).contains("imię matki")) {
					owner.setNamesOfParents(owner.getNamesOfParents() + ", " + listOfAttributeValues.get(2).trim());
				}
				if (listOfAttributeNames.size() == 4 && listOfAttributeNames.get(3).contains("PESEL")) {
					owner.setNumberOfPesel(Long.parseLong((listOfAttributeValues.get(3).trim())));
				}
			}
			owners.add(owner);
		}
		return owners;

	}

}
