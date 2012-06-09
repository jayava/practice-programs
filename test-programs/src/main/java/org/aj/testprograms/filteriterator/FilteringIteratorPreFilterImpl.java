package org.aj.testprograms.filteriterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.aj.testprograms.filteriterator.conditionchecker.ObjectTest;

/**
 * @author AJ
 *
 */
public class FilteringIteratorPreFilterImpl<E> implements Iterator<E> {

	private final List<E> preFilteredList = new LinkedList<E>();
	private final Iterator<E> filterIte;
	
	/**
	 * 
	 * @param orig - the underlying iterator
	 * @param objChecker - the condition checker object
	 */
	public FilteringIteratorPreFilterImpl(Iterator<E> orig, ObjectTest<E> objChecker){
		//build and pre-filter
		while(orig.hasNext()){
			E temp = orig.next();
			if(objChecker.test(temp))
				preFilteredList.add(temp);
		}
		
		filterIte = preFilteredList.iterator();
	}
	
	@Override
	public boolean hasNext() {
		return filterIte.hasNext();
	}

	@Override
	public E next() {
		return filterIte.next();
	}

	@Override
	public void remove() {
		filterIte.remove();
	}

}
