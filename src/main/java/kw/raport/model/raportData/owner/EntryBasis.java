package kw.raport.model.raportData.owner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class EntryBasis {
	private String title;
	private String rep;
	private Date creationDate;

	public EntryBasis(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	// Simple String representation for reporting purpose
	public String asString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder result = new StringBuilder();
		result.append(" - ");
		if(title != null) {
			result.append(title);
			result.append(", ");
		}
		if(rep != null) {
			result.append(rep);
			result.append(", ");
		}
		if (creationDate != null) {
			result.append(sdf.format(creationDate));
			result.append(";");
		}
		result.append("<w:br/>");
		
		return result.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OwnerEntryBasis [");
		if (title != null) {
			builder.append("title=");
			builder.append(title);
			builder.append(", ");
		}
		if (rep != null) {
			builder.append("rep=");
			builder.append(rep);
			builder.append(", ");
		}
		if (creationDate != null) {
			builder.append("creationDate=");
			builder.append(creationDate);
		}
		builder.append("]");
		return builder.toString();
	}

}
