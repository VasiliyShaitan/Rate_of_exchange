package com.rateofexchange;

import java.util.ArrayList;
import java.util.Arrays;

import com.rateofexchange.model.Currency;
import com.rateofexchange.model.CurrencyList;
import com.rateofexchange.parser.CurrencyParser;
import com.rateofexchange.parser.vendors.CBRVendor;
import com.rateofexchange.parser.vendors.Vendor;


public class AppMain {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage currency CURCODE [CURCODE ...]");
			return;
		}
		Vendor cbr = new CBRVendor();
		CurrencyParser parser = new CurrencyParser(cbr);
		ArrayList<String> selectedCurrs = new ArrayList<String>(Arrays.asList(args));
		CurrencyList list = parser.parse();
		if (list == null)
			return;
		for (Currency cur : list) {
			if (selectedCurrs.contains(cur.getCharCode()))
				System.out.println(cur.getDisplayName() + " (" + cur.getCharCode() + ")\t" + cur.getCurRate());		
		}

	}
}