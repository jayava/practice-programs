package org.aj.testprograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Set;

public class CharsetFun {
	public static void main(String[] args) {
//		String x = "AJ";
//		System.out.println("Code point: " + Integer.toHexString(x.codePointAt(0)));
		System.out.println("Character set: " + Charset.defaultCharset().displayName());
//		
//		Set<Currency> currs = Currency.getAvailableCurrencies();
//		
//		for(Currency c: currs){
//			System.out.println("Name: " + c.getDisplayName());
//			System.out.println("Symbol: " + c.getSymbol());
//			System.out.println("Code: " + c.getCurrencyCode());
//		}
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\AJ\\git\\practice-programs\\test-programs\\src\\main\\java\\org\\aj\\testprograms\\CharsetFun.java");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader isr = new InputStreamReader(fis);
		System.out.println("Encoding: " + isr.getEncoding());
	}
}
