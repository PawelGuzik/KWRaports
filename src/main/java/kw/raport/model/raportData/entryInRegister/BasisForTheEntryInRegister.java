package kw.raport.model.raportData.entryInRegister;

public class BasisForTheEntryInRegister {
	private String name;
	private String dateOfCreation;
	
	
	
	
	public BasisForTheEntryInRegister(String name, String dateOfCreation) {
		this.name = name;
		this.dateOfCreation = dateOfCreation;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n[name=");
		builder.append(name);
		builder.append(", dateOfCreation=");
		builder.append(dateOfCreation);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
