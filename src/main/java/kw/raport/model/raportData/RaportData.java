package kw.raport.model.raportData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kw.raport.model.raportData.limitedRights.LimitedRights;
import kw.raport.model.raportData.owner.Owner;
import kw.raport.model.raportData.owner.EntryBasis;
import kw.raport.model.raportData.plotOfLand.PlotOfLand;

public class RaportData {

	private String voivodenship;
	private String county;
	private String landRegistryUnit;
	private String registrationPrecinct;
	private String courthouse;
	private Date creationDate;
	private String landAndMortgageRegisterNumber;
	private List<String> plotNumbers;
	private String realEstateArea;
	
	private String propertyType;
	private List<EntryBasis> mapInformation;
	private List<Owner> owners;
	private List<EntryBasis> ownersEntryBasis;
	private List<LimitedRights> limitedRights;
	private List<EntryBasis> limitedRightsEntryBasis;
	private String author;
	private String professionalQualificationsNumber;
	private List<PlotOfLand> plotOfLandList;

	public RaportData() {
	}

	public void addPlotOfLand(String plotOfLandNumber) {
		PlotOfLand plotOfLand = new PlotOfLand(plotOfLandNumber);
		if (plotOfLandList == null) {
			plotOfLandList = new ArrayList<PlotOfLand>();

		}
		if (!plotOfLandList.contains(plotOfLand)) {
			plotOfLandList.add(plotOfLand);
		}

	}
	
	public void addPlotOfLandFromList(List<String> plotsNumbers) {
		for (String plotNumber : plotsNumbers) {
			addPlotOfLand(plotNumber);
		}
	}

	public boolean setPlotOfLandLocation(String plotNumber, String plotLocation) {

		for (PlotOfLand plotOfLand : plotOfLandList) {
			if (plotOfLand.getNumber().equals(plotNumber)) {
				plotOfLand.setLocation(plotLocation);
				return true;
			}
		}
		return false;
	}

	public boolean setPlotOfLandWayToUse(String plotNumber, String wayToUse) {
		for (PlotOfLand plotOfLand : plotOfLandList) {
			if (plotOfLand.getNumber().equals(plotNumber)) {
				plotOfLand.setWayToUse(wayToUse);
				return true;
			}
		}
		return false;
	}

	public String getVoivodenship() {
		return voivodenship;
	}

	public void serVoivodenship(String voivodenship) {
		this.voivodenship = voivodenship;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getLandRegistryUnit() {
		return landRegistryUnit;
	}

	public void setLandRegistryUnit(String landRegistryUnit) {
		this.landRegistryUnit = landRegistryUnit;
	}

	public String getRegistrationPrecinct() {
		return registrationPrecinct;
	}

	public void setRegistrationPrecinct(String registrationPrecinct) {
		this.registrationPrecinct = registrationPrecinct;
	}

	public String getCourthouse() {
		return courthouse;
	}

	public void setCourthouse(String courthouse) {
		this.courthouse = courthouse;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getLandAndMortgageRegisterNumber() {
		return landAndMortgageRegisterNumber;
	}

	public void setLandAndMortgageRegisterNumber(String landAndMortgageRegisterNumber) {
		this.landAndMortgageRegisterNumber = landAndMortgageRegisterNumber;
	}

	public List<String> getPlotNumbers() {
		return plotNumbers;
	}

	public void setPlotNumbers(List<String> plotNumbers) {
		this.plotNumbers = plotNumbers;
	}

	public String getRealEstateArea() {
		return realEstateArea;
	}

	public void setRealEstateArea(String realEstateArea) {
		this.realEstateArea = realEstateArea;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void stePropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public List<EntryBasis> getMapInformation() {
		return mapInformation;
	}

	public void setMapInformation(List<EntryBasis> mapInformation) {
		this.mapInformation = mapInformation;
	}

	public List<Owner> getOwners() {
		return owners;
	}

	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}

	public List<EntryBasis> getOwnerEntryBasis() {
		return ownersEntryBasis;
	}

	public void setOwnerEntryBasis(List<EntryBasis> ownersEntryBasis) {
		this.ownersEntryBasis = ownersEntryBasis;
	}

	public List<LimitedRights> getLimitedRights() {
		return limitedRights;
	}

	public void setLimitedRights(List<LimitedRights> limitedRights) {
		this.limitedRights = limitedRights;
	}

	public List<EntryBasis> getLimitedRightsEntryBasis() {
		return limitedRightsEntryBasis;
	}

	public void setLimitedRightsEntryBasis(List<EntryBasis> limitedRightsEntryBasis) {
		this.limitedRightsEntryBasis = limitedRightsEntryBasis;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getprofessionalQualificationsNumber() {
		return professionalQualificationsNumber;
	}

	public void setprofessionalQualificationsNumber(String professionalQualificationsNumber) {
		this.professionalQualificationsNumber = professionalQualificationsNumber;
	}

	public List<PlotOfLand> getPlotOfLandList() {
		return plotOfLandList;
	}

	public void setPlotOfLandList(List<PlotOfLand> plotOfLandList) {
		this.plotOfLandList = plotOfLandList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RaportData [");
		if (voivodenship != null) {
			builder.append("voivodenship=");
			builder.append(voivodenship);
			builder.append(", ");
		}
		if (county != null) {
			builder.append("county=");
			builder.append(county);
			builder.append(", ");
		}
		if (landRegistryUnit != null) {
			builder.append("landRegistryUnit=");
			builder.append(landRegistryUnit);
			builder.append(", ");
		}
		if (registrationPrecinct != null) {
			builder.append("registrationPrecinct=");
			builder.append(registrationPrecinct);
			builder.append(", ");
		}
		if (courthouse != null) {
			builder.append("courthouse=");
			builder.append(courthouse);
			builder.append(", ");
		}
		if (creationDate != null) {
			builder.append("creationDate=");
			builder.append(creationDate);
			builder.append(", ");
		}
		if (landAndMortgageRegisterNumber != null) {
			builder.append("landAndMortgageRegisterNumber=");
			builder.append(landAndMortgageRegisterNumber);
			builder.append(", ");
		}
		if (plotNumbers != null) {
			builder.append("plotNumbers=");
			builder.append(plotNumbers);
			builder.append(", ");
		}
		if (realEstateArea != null) {
			builder.append("realEstateArea=");
			builder.append(realEstateArea);
			builder.append(", ");
		}
		if (propertyType != null) {
			builder.append("propertyType=");
			builder.append(propertyType);
			builder.append(", ");
		}
		if (mapInformation != null) {
			builder.append("mapInformation=");
			builder.append(mapInformation);
			builder.append(", ");
		}
		if (owners != null) {
			builder.append("owners=");
			builder.append(owners);
			builder.append(", ");
		}
		if (ownersEntryBasis != null) {
			builder.append("ownersEntryBasis=");
			builder.append(ownersEntryBasis);
			builder.append(", ");
		}
		if (limitedRights != null) {
			builder.append("limitedRights=");
			builder.append(limitedRights);
			builder.append(", ");
		}
		if (limitedRightsEntryBasis != null) {
			builder.append("limitedRightsEntryBasis=");
			builder.append(limitedRightsEntryBasis);
			builder.append(", ");
		}
		if (author != null) {
			builder.append("author=");
			builder.append(author);
			builder.append(", ");
		}
		if (professionalQualificationsNumber != null) {
			builder.append("professionalQualificationsNumber=");
			builder.append(professionalQualificationsNumber);
			builder.append(", ");
		}
		if (plotOfLandList != null) {
			builder.append("plotOfLandList=");
			builder.append(plotOfLandList);
		}
		builder.append("]");
		return builder.toString();
	}

}
