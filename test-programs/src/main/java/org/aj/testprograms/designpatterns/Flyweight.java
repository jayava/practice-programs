package org.aj.testprograms.designpatterns;

public class Flyweight {

	void x(){
		int y;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "Anish";
		String b = "Anish";
		
		String c = (a + b).intern();
		
		System.out.println(a==b);
		System.out.println(c=="AnishAnish");
	}

}
