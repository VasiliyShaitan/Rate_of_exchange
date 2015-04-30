package com.rateofexchange.parser.vendors;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class CBRVendor implements Vendor {
	
	public static final String address = "http://www.cbr.ru/scripts/XML_daily.asp";

	@Override
	public InputStream getInputStream() {
		InputStream result = null;
		try {
			URLConnection con = new URL(address).openConnection();
			result = con.getInputStream();
		} catch (Exception e) {
			System.err.println("Cannot connect to data vendor. Check your internet connection.");
		} 
		return result;
	}

}
