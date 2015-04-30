package com.rateofexchange.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.ObservableListBase;

@XmlRootElement(name = "ValCurs")
public class CurrencyList extends ObservableListBase<Currency> {
	@XmlElement(name = "Valute")
	private ArrayList<Currency> container;

	@Override
	public Currency get(int index) {
		return container.get(index);
	}

	@Override
	public int size() {
		return container.size();
	}

}
