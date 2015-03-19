package com.rateofexchange.parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.rateofexchange.model.CurrencyList;
import com.rateofexchange.parser.vendors.Vendor;

public class CurrencyParser {
	private Vendor vendor;
	
	public CurrencyParser(Vendor vendor) {
		this.vendor = vendor;
	}
	
	public CurrencyList parse() {
		if (vendor == null)
			return null;

		CurrencyList curL = null;
		try {
			JAXBContext context = JAXBContext.newInstance(CurrencyList.class);
			Unmarshaller um = context.createUnmarshaller();
			curL = (CurrencyList) um.unmarshal(vendor.getFile());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return curL;
	}
}