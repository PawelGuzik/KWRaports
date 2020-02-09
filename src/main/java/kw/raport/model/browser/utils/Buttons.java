package kw.raport.model.browser.utils;

public enum Buttons {
	ACTKW("//button[@name='przyciskWydrukZwykly']"),
	SEC1O("//input[@value='Dział I-O']"),
	SEC1SP("//input[@value='Dział I-Sp']"),
	SEC2("//input[@value='Dział II']"),
	SEC3("//input[@value='Dział III']");

	private String xPath;

	Buttons(String xPath) {
		this.xPath = xPath;
	}
	
	public String getXPath() {
		return xPath;
	}

}
