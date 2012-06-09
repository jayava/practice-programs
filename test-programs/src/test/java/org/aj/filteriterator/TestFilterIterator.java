package org.aj.filteriterator;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.aj.testprograms.filteriterator.FilteringIterator;
import org.aj.testprograms.filteriterator.conditionchecker.ObjectTest;
import org.junit.Test;

public class TestFilterIterator {

	@Test
	public final void testHasNextWithValidElements() {
		List<String> listUnderTest = new LinkedList<String>();
		listUnderTest.add("Anish");
		listUnderTest.add("Michael");
		listUnderTest.add("Andy");

		ObjectTest<String> m = new ObjectTest<String>() {

			@Override
			public boolean test(String input) {
				if (input.startsWith("A"))
					return true;
				else
					return false;
			}
		};

		FilteringIterator<String> a = new FilteringIterator<String>(
				listUnderTest.iterator(), m);

		// first call should be true
		assertTrue(a.hasNext());
		a.next();
		// should be true
		assertTrue(a.hasNext());
		a.next();
		assertFalse(a.hasNext());
	}

	@Test
	public final void testHasNextWithNoValidElements() {
		List<String> listUnderTest = new LinkedList<String>();
		listUnderTest.add("Anish");
		listUnderTest.add("Michael");
		listUnderTest.add("Andy");

		ObjectTest<String> m = new ObjectTest<String>() {

			@Override
			public boolean test(String input) {
				if (input.startsWith("X"))
					return true;
				else
					return false;
			}
		};

		FilteringIterator<String> a = new FilteringIterator<String>(
				listUnderTest.iterator(), m);

		// should be false
		assertFalse(a.hasNext());
	}

	@Test
	public final void testNextWithValidElements() {
		List<Integer> intListUnderTest = new LinkedList<Integer>();
		intListUnderTest.add(1);
		intListUnderTest.add(5);
		intListUnderTest.add(8);

		ObjectTest<Integer> m = new ObjectTest<Integer>() {

			@Override
			public boolean test(Integer input) {
				if (input > 5)
					return true;
				else
					return false;
			}
		};

		FilteringIterator<Integer> a = new FilteringIterator<Integer>(
				intListUnderTest.iterator(), m);

		Integer i = a.next();
		assertEquals(i, new Integer(8));
	}

	@Test
	public final void testNextWithNoValidElements() {
		List<Integer> intListUnderTest = new LinkedList<Integer>();
		intListUnderTest.add(1);
		intListUnderTest.add(5);
		intListUnderTest.add(8);

		ObjectTest<Integer> m = new ObjectTest<Integer>() {

			@Override
			public boolean test(Integer input) {
				if (input > 10)
					return true;
				else
					return false;
			}
		};

		FilteringIterator<Integer> a = new FilteringIterator<Integer>(
				intListUnderTest.iterator(), m);

		try {
			a.next();
			fail("NoSuchElementException was not thrown");
		} catch (NoSuchElementException ne) {

		} catch (Throwable t) {
			fail("Some other type of throwable was thrown");
			t.printStackTrace();
		}
	}

	@Test
	public final void testRemove() {
		List<Integer> intListUnderTest = new LinkedList<Integer>();
		intListUnderTest.add(1);
		intListUnderTest.add(5);
		intListUnderTest.add(8);

		ObjectTest<Integer> m = new ObjectTest<Integer>() {

			@Override
			public boolean test(Integer input) {
				if (input > 0)
					return true;
				else
					return false;
			}
		};

		FilteringIterator<Integer> a = new FilteringIterator<Integer>(
				intListUnderTest.iterator(), m);

		// None of the below should throw any exception
		try {
			a.next();
			a.remove();
			a.next();
			a.remove();
			a.next();
			a.remove();
			assertEquals(intListUnderTest.size(),0);
		} catch (Throwable t) {
			fail("Exception thrown from next/remove sequential calls");
			t.printStackTrace();
		}
	}

	@Test
	public final void testRepeatedRemoveCalls() {
		List<Integer> intListUnderTest = new LinkedList<Integer>();
		intListUnderTest.add(1);
		intListUnderTest.add(5);
		intListUnderTest.add(8);

		ObjectTest<Integer> m = new ObjectTest<Integer>() {

			@Override
			public boolean test(Integer input) {
				if (input > 0)
					return true;
				else
					return false;
			}
		};

		FilteringIterator<Integer> a = new FilteringIterator<Integer>(
				intListUnderTest.iterator(), m);

		// None of the below should throw any exception
		try {
			a.next();
			a.remove();
			a.remove();
			fail("Second remove should have thrown exception");
		} catch (IllegalStateException ne) {
			
		} catch (Throwable t) {
			fail("Unknown exception thrown from next/remove sequential calls");
			t.printStackTrace();
		}
	}

}
