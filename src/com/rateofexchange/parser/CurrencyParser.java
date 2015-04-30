package com.rateofexchange.parser;

import java.io.InputStream;

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
			InputStream input = vendor.getInputStream();
			if (input == null)
				return null;
			curL = (CurrencyList) um.unmarshal(input);
		} catch (JAXBException e) {
			System.err.println("Cannot read data received from vendor. Try again later.");
		}
		return curL;
	}
}
