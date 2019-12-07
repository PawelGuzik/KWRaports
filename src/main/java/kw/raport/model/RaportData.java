package kw.raport.model;

import java.util.Date;
import java.util.List;

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
	private String polozenieIInfOSposobieWykorzystania;
	private String rodzajNieruchomosci;
	private String infOMapach;
	private String wlasciciele;
	private String podstawaWykazaniaWlascicieli;
	private String ograniczonePrawa;
	private String wykonawca;
	private String nrUprawnien;
	
	public RaportData() {
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

	public String getPolozenieIInfOSposobieWykorzystania() {
		return polozenieIInfOSposobieWykorzystania;
	}

	public void setPolozenieIInfOSposobieWykorzystania(String polozenieIInfOSposobieWykorzystania) {
		this.polozenieIInfOSposobieWykorzystania = polozenieIInfOSposobieWykorzystania;
	}

	public String getRodzajNieruchomosci() {
		return rodzajNieruchomosci;
	}

	public void setRodzajNieruchomosci(String rodzajNieruchomosci) {
		this.rodzajNieruchomosci = rodzajNieruchomosci;
	}

	public String getInfOMapach() {
		return infOMapach;
	}

	public void setInfOMapach(String infOMapach) {
		this.infOMapach = infOMapach;
	}

	public String getWlasciciele() {
		return wlasciciele;
	}

	public void setWlasciciele(String wlasciciele) {
		this.wlasciciele = wlasciciele;
	}

	public String getPodstawaWykazaniaWlascicieli() {
		return podstawaWykazaniaWlascicieli;
	}

	public void setPodstawaWykazaniaWlascicieli(String podstawaWykazaniaWlascicieli) {
		this.podstawaWykazaniaWlascicieli = podstawaWykazaniaWlascicieli;
	}

	public String getOgraniczonePrawa() {
		return ograniczonePrawa;
	}

	public void setOgraniczonePrawa(String ograniczonePrawa) {
		this.ograniczonePrawa = ograniczonePrawa;
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
		return "RaportData [województwo=" + województwo + ", powiat=" + powiat + ", jednEwid=" + jednEwid + ", obreb="
				+ obreb + ", miejscowoscSadu=" + miejscowoscSadu + ", dataUtworzenia=" + dataUtworzenia + ", nrKW="
				+ nrKW + ", nryDzialek=" + nryDzialek + ", polePowierzchni=" + polePowierzchni
				+ ", polozenieIInfOSposobieWykorzystania=" + polozenieIInfOSposobieWykorzystania
				+ ", rodzajNieruchomosci=" + rodzajNieruchomosci + ", infOMapach=" + infOMapach + ", wlasciciele="
				+ wlasciciele + ", podstawaWykazaniaWlascicieli=" + podstawaWykazaniaWlascicieli + ", ograniczonePrawa="
				+ ograniczonePrawa + ", wykonawca=" + wykonawca + ", nrUprawnien=" + nrUprawnien + "]";
	}
	
	
	

	
	
	
	
	

}
