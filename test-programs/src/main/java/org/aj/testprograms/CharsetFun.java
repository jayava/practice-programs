package org.aj.testprograms;

import java.nio.charset.Charset;
import java.util.Currency;
import java.util.Locale;
import java.util.Set;

public class CharsetFun {
	public static void main(String[] args) {
		String x = "AJ";
		System.out.println("Code point: " + Integer.toHexString(x.codePointAt(0)));
		System.out.println("Character set: " + Charset.defaultCharset().displayName());
		
		Set<Currency> currs = Currency.getAvailableCurrencies();
		
		for(Currency c: currs){
			System.out.println("Name: " + c.getDisplayName());
			System.out.println("Symbol: " + c.getSymbol());
			System.out.println("Code: " + c.getCurrencyCode());
		}
	}
}
