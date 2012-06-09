package org.aj.testprograms.filteriterator.conditionchecker;

/**
 * @author AJ
 *
 */
public interface ObjectTest<T> {
	
	/**
	 * 
	 * @param input - the object to be tested
	 * @return true if the input T passes
	 * the test implemented 
	 */
	boolean test(T input);
}
