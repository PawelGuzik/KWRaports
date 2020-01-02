package kw.raport.model.raportData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kw.raport.model.raportData.entryInRegister.BasisForTheEntryInRegister;
import kw.raport.model.raportData.limitedRights.LimitedRights;
import kw.raport.model.raportData.owner.Owner;
import kw.raport.model.raportData.owner.EntryBasis;
import kw.raport.model.raportData.plotOfLand.PlotOfLand;

public class RaportData {

	private String województwo;
	private String powiat;
	private String jednEwid;
	private String obreb;
	private String miejscowoscSadu;
	private Date dataUtworzenia;
	private String nrKW;
	private List<String> nryDzialek;
	private String polePowierzchni;
	
	private String rodzajNieruchomosci;
	private List<BasisForTheEntryInRegister> infOMapach;
	private List<Owner> wlasciciele;
	private List<EntryBasis> podstawaWykazaniaWlascicieli;
	private List<LimitedRights> ograniczonePrawa;
	private List<EntryBasis> ograiczonePrawaPodst;
	private String wykonawca;
	private String nrUprawnien;
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

	public String getWojewództwo() {
		return województwo;
	}

	public void setWojewództwo(String województwo) {
		this.województwo = województwo;
	}

	public String getPowiat() {
		return powiat;
	}

	public void setPowiat(String powiat) {
		this.powiat = powiat;
	}

	public String getJednEwid() {
		return jednEwid;
	}

	public void setJednEwid(String jednEwid) {
		this.jednEwid = jednEwid;
	}

	public String getObreb() {
		return obreb;
	}

	public void setObreb(String obreb) {
		this.obreb = obreb;
	}

	public String getMiejscowoscSadu() {
		return miejscowoscSadu;
	}

	public void setMiejscowoscSadu(String miejscowoscSadu) {
		this.miejscowoscSadu = miejscowoscSadu;
	}

	public Date getDataUtworzenia() {
		return dataUtworzenia;
	}

	public void setDataUtworzenia(Date dataUtworzenia) {
		this.dataUtworzenia = dataUtworzenia;
	}

	public String getNrKW() {
		return nrKW;
	}

	public void setNrKW(String nrKW) {
		this.nrKW = nrKW;
	}

	public List<String> getNryDzialek() {
		return nryDzialek;
	}

	public void setNryDzialek(List<String> nryDzialek) {
		this.nryDzialek = nryDzialek;
	}

	public String getPolePowierzchni() {
		return polePowierzchni;
	}

	public void setPolePowierzchni(String polePowierzchni) {
		this.polePowierzchni = polePowierzchni;
	}



	public String getRodzajNieruchomosci() {
		return rodzajNieruchomosci;
	}

	public void setRodzajNieruchomosci(String rodzajNieruchomosci) {
		this.rodzajNieruchomosci = rodzajNieruchomosci;
	}

	public List<BasisForTheEntryInRegister> getInfOMapach() {
		return infOMapach;
	}

	public void setInfOMapach(List<BasisForTheEntryInRegister> infOMapach) {
		this.infOMapach = infOMapach;
	}

	public List<Owner> getWlasciciele() {
		return wlasciciele;
	}

	public void setWlasciciele(List<Owner> wlasciciele) {
		this.wlasciciele = wlasciciele;
	}

	public List<EntryBasis> getPodstawaWykazaniaWlascicieli() {
		return podstawaWykazaniaWlascicieli;
	}

	public void setPodstawaWykazaniaWlascicieli(List<EntryBasis> podstawaWykazaniaWlascicieli) {
		this.podstawaWykazaniaWlascicieli = podstawaWykazaniaWlascicieli;
	}

	public List<LimitedRights> getOgraniczonePrawa() {
		return ograniczonePrawa;
	}

	public void setOgraniczonePrawa(List<LimitedRights> ograniczonePrawa) {
		this.ograniczonePrawa = ograniczonePrawa;
	}

	public List<EntryBasis> getOgraiczonePrawaPodst() {
		return ograiczonePrawaPodst;
	}

	public void setOgraiczonePrawaPodst(List<EntryBasis> ograiczonePrawaPodst) {
		this.ograiczonePrawaPodst = ograiczonePrawaPodst;
	}

	public String getWykonawca() {
		return wykonawca;
	}

	public void setWykonawca(String wykonawca) {
		this.wykonawca = wykonawca;
	}

	public String getNrUprawnien() {
		return nrUprawnien;
	}

	public void setNrUprawnien(String nrUprawnien) {
		this.nrUprawnien = nrUprawnien;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RaportData [");
		if (województwo != null) {
			builder.append("województwo=");
			builder.append(województwo);
			builder.append(", ");
		}
		if (powiat != null) {
			builder.append("powiat=");
			builder.append(powiat);
			builder.append(", ");
		}
		if (jednEwid != null) {
			builder.append("jednEwid=");
			builder.append(jednEwid);
			builder.append(", ");
		}
		if (obreb != null) {
			builder.append("obreb=");
			builder.append(obreb);
			builder.append(", ");
		}
		if (miejscowoscSadu != null) {
			builder.append("miejscowoscSadu=");
			builder.append(miejscowoscSadu);
			builder.append(", ");
		}
		if (dataUtworzenia != null) {
			builder.append("dataUtworzenia=");
			builder.append(dataUtworzenia);
			builder.append(", ");
		}
		if (nrKW != null) {
			builder.append("nrKW=");
			builder.append(nrKW);
			builder.append(", ");
		}
		if (nryDzialek != null) {
			builder.append("nryDzialek=");
			builder.append(nryDzialek);
			builder.append(", ");
		}
		if (polePowierzchni != null) {
			builder.append("polePowierzchni=");
			builder.append(polePowierzchni);
			builder.append(", ");
		}
		if (rodzajNieruchomosci != null) {
			builder.append("rodzajNieruchomosci=");
			builder.append(rodzajNieruchomosci);
			builder.append(", ");
		}
		if (infOMapach != null) {
			builder.append("infOMapach=");
			builder.append(infOMapach);
			builder.append(", ");
		}
		if (wlasciciele != null) {
			builder.append("wlasciciele=");
			builder.append(wlasciciele);
			builder.append(", ");
		}
		if (podstawaWykazaniaWlascicieli != null) {
			builder.append("podstawaWykazaniaWlascicieli=");
			builder.append(podstawaWykazaniaWlascicieli);
			builder.append(", ");
		}
		if (ograniczonePrawa != null) {
			builder.append("ograniczonePrawa=");
			builder.append(ograniczonePrawa);
			builder.append(", ");
		}
		if (ograiczonePrawaPodst != null) {
			builder.append("ograiczonePrawaPodst=");
			builder.append(ograiczonePrawaPodst);
			builder.append(", ");
		}
		if (wykonawca != null) {
			builder.append("wykonawca=");
			builder.append(wykonawca);
			builder.append(", ");
		}
		if (nrUprawnien != null) {
			builder.append("nrUprawnien=");
			builder.append(nrUprawnien);
			builder.append(", ");
		}
		if (plotOfLandList != null) {
			builder.append("plotOfLandList=");
			builder.append(plotOfLandList);
		}
		builder.append("]");
		return builder.toString();
	}

	public List<PlotOfLand> getPlotOfLandList() {
		return plotOfLandList;
	}

	public void setPlotOfLandList(List<PlotOfLand> plotOfLandList) {
		this.plotOfLandList = plotOfLandList;
	}

}
