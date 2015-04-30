package com.rateofexchange.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Valute")
public class Currency {
	private String charCode;
	private int nominal;
	private String displayName;
	private double curRate;
	
	public Currency() {}
	public Currency(String charCode, int nominal, 
			String displayName, double curRate) {
		this.charCode = charCode;
		this.nominal = nominal;
		this.displayName = displayName;
		this.curRate = curRate;
	}
	
	public String getCharCode() {
		return charCode;
	}
	@XmlElement(name = "CharCode")
	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}
	public int getNominal() {
		return nominal;
	}
	@XmlElement(name = "Nominal")
	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
	public String getDisplayName() {
		return displayName;
	}
	@XmlElement(name = "Name")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public double getCurRate() {
		return curRate;
	}
	public void setCurRate(double curRate) {
		this.curRate = curRate;
	}
	@XmlElement(name = "Value")
	private void setCurRateStr(String curRate) throws ParseException {
		//Add support of xx,xxx format
		NumberFormat fmt = NumberFormat.getInstance(Locale.FRANCE);
		this.curRate = fmt.parse(curRate).doubleValue();
	}

}
