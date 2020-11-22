package kw.raport.model.raportData.limitedRights;

public class LimitedRights {
	
	private String rightsType;
	private String content;
	
	
	public LimitedRights() {
	}
	
	
	
	public LimitedRights(String rightsType, String content) {
		this.rightsType = rightsType;
		this.content = content;
	}



	public String getRightsType() {
		return rightsType;
	}
	public void setRightsType(String rightsType) {
		this.rightsType = rightsType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	//For the purpose of producing reports
	public String asString() {
		StringBuilder builder = new StringBuilder();
	
		if (rightsType != null) {
			builder.append("Typ prawa=");
			builder.append(rightsType);
			builder.append(", ");
		}
		if (content != null) {
			builder.append("treść=");
			builder.append(content);
		}
	
		return builder.toString();
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LimitedRights [");
		if (rightsType != null) {
			builder.append("rightsType=");
			builder.append(rightsType);
			builder.append(", ");
		}
		if (content != null) {
			builder.append("content=");
			builder.append(content);
		}
		builder.append("]");
		return builder.toString();
	}
	

	
}
