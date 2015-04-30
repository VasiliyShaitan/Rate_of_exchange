package com.rateofexchange.parser.vendors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileVendor implements Vendor {
	private String filePath;
	
	public FileVendor(String filePath) {
		this.filePath = filePath;
	}
	
	public File getFile() {
		return new File(filePath);
	}
	
	public InputStream getInputStream() {
		try {
			return new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
