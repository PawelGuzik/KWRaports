package kw.raport.model.raportData.plotOfLand;

public class PlotOfLand {
	
	private String number;
	private String location;
	private String wayToUse;
	
	public PlotOfLand(String number) {
		this.number = number;
	}

	public PlotOfLand(String number, String location, String wayToUse) {
		this.number = number;
		this.location = location;
		this.wayToUse = wayToUse;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWayToUse() {
		return wayToUse;
	}

	public void setWayToUse(String wayToUse) {
		this.wayToUse = wayToUse;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlotOfLand other = (PlotOfLand) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nPlotOfLand [");
		if (number != null) {
			builder.append("nnumber=");
			builder.append(number);
			builder.append(", ");
		}
		if (location != null) {
			builder.append("location=");
			builder.append(location);
			builder.append(", ");
		}
		if (wayToUse != null) {
			builder.append("wayToUse=");
			builder.append(wayToUse);
		}
		builder.append("]");
		return builder.toString();
	}
	
	

}
