package kw.raport.model.raportData.owner;

public class Owner {
	private String name;
	private String secondName;
	private String surname;
	private String namesOfParents;
	private long numberOfPesel;
	
	//Constructors.
	public Owner() {
	}
	
	public Owner(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public Owner(String name, String surname, String namesOfParents) {
		this.name = name;
		this.surname = surname;
		this.namesOfParents = namesOfParents;
	}

	public Owner(String name, String surname, String namesOfParents, int numberOfPesel) {
		this.name = name;
		this.surname = surname;
		this.namesOfParents = namesOfParents;
		this.numberOfPesel = numberOfPesel;
	}

	//Getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getNamesOfParents() {
		return namesOfParents;
	}
	public void setNamesOfParents(String namesOfParents) {
		this.namesOfParents = namesOfParents;
	}
	public long getNumberOfPesel() {
		return numberOfPesel;
	}
	public void setNumberOfPesel(long numberOfPesel) {
		this.numberOfPesel = numberOfPesel;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	//For reporting purposes
	public String asString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" - ");
		if (name != null) {
			builder.append(name + " ");
		}
		if (surname != null) {
			builder.append(surname + " ");
		}
		if (namesOfParents != null) {
			builder.append("(");
			builder.append(namesOfParents);
			builder.append("), ");
		}
		if(numberOfPesel != 0) {
		builder.append("PESEL: ");
		builder.append(numberOfPesel);
		}else {
			builder.append("PESEL: -BRAK-");
		}
		return builder.toString();
	}

	//toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Owner [");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (surname != null) {
			builder.append("surname=");
			builder.append(surname);
			builder.append(", ");
		}
		if (namesOfParents != null) {
			builder.append("namesOfParents=");
			builder.append(namesOfParents);
			builder.append(", ");
		}
		builder.append("numberOfPesel=");
		builder.append(numberOfPesel);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
