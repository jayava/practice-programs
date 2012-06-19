package org.aj.testprograms;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestIntegerOperationsUtils {

	@Test
	public void testNegation() {
		assertEquals(IntegerOperationsUtils.negate(4), -4);
		assertEquals(IntegerOperationsUtils.negate(-4), 4);
		assertEquals(IntegerOperationsUtils.negate(0), 0);
		assertEquals(IntegerOperationsUtils.negate(-0), 0);
	}
	
	@Test
	public void testAddition() {
		assertEquals(IntegerOperationsUtils.add(3, 4),7);
		assertEquals(IntegerOperationsUtils.add(4, 5),9);
		assertEquals(IntegerOperationsUtils.add(-4, 5),1);
		assertEquals(IntegerOperationsUtils.add(-4, -5),-9);
		assertEquals(IntegerOperationsUtils.add(-5, 4),-1);
		assertEquals(IntegerOperationsUtils.add(0, 0),0);
		assertEquals(IntegerOperationsUtils.add(0, 3),3);
	}

	@Test
	public void testSubtraction() {
		assertEquals(IntegerOperationsUtils.subtract(5, 4), 1);
		assertEquals(IntegerOperationsUtils.subtract(4, 5), -1);
		assertEquals(IntegerOperationsUtils.subtract(4, 0), 4);
		assertEquals(IntegerOperationsUtils.subtract(0, 4), -4);
		assertEquals(IntegerOperationsUtils.subtract(0, 0), 0);
		assertEquals(IntegerOperationsUtils.subtract(0, -0), 0);
		assertEquals(IntegerOperationsUtils.subtract(-4, 0), -4);
		assertEquals(IntegerOperationsUtils.subtract(-4, 4), -8);
		assertEquals(IntegerOperationsUtils.subtract(-4, 5), -9);
		assertEquals(IntegerOperationsUtils.subtract(-4, -4), 0);
		assertEquals(IntegerOperationsUtils.subtract(6, -4), 10);
	}
	
	@Test
	public void testMultiplyUsingAdd() {
		assertEquals(IntegerOperationsUtils.multiplyUsingAdd(3, 4),12);
		assertEquals(IntegerOperationsUtils.multiplyUsingAdd(-4, -5),20);
		assertEquals(IntegerOperationsUtils.multiplyUsingAdd(-4, 4),-16);
		assertEquals(IntegerOperationsUtils.multiplyUsingAdd(-4, 0),0);
		assertEquals(IntegerOperationsUtils.multiplyUsingAdd(4, 0),0);
		assertEquals(IntegerOperationsUtils.multiplyUsingAdd(0, 0),0);
		assertEquals(IntegerOperationsUtils.multiplyUsingAdd(4, -7),-28);
	}
	
	@Test
	public void testMultiplyUsingBitwise() {
		assertEquals(IntegerOperationsUtils.multiplyUsingBitwise(3, 4),12);
		assertEquals(IntegerOperationsUtils.multiplyUsingBitwise(-4, -5),20);
		assertEquals(IntegerOperationsUtils.multiplyUsingBitwise(-4, 4),-16);
		assertEquals(IntegerOperationsUtils.multiplyUsingBitwise(-4, 0),0);
		assertEquals(IntegerOperationsUtils.multiplyUsingBitwise(4, 0),0);
		assertEquals(IntegerOperationsUtils.multiplyUsingBitwise(0, 0),0);
		assertEquals(IntegerOperationsUtils.multiplyUsingBitwise(4, -7),-28);
	}
	
	@Test
	public void testMultiplyUsingRecursion() {
		assertEquals(IntegerOperationsUtils.multiplyUsingRecursion(3, 4),12);
		assertEquals(IntegerOperationsUtils.multiplyUsingRecursion(-4, -5),20);
		assertEquals(IntegerOperationsUtils.multiplyUsingRecursion(-4, 4),-16);
		assertEquals(IntegerOperationsUtils.multiplyUsingRecursion(-4, 0),0);
		assertEquals(IntegerOperationsUtils.multiplyUsingRecursion(4, 0),0);
		assertEquals(IntegerOperationsUtils.multiplyUsingRecursion(0, 0),0);
		assertEquals(IntegerOperationsUtils.multiplyUsingRecursion(4, -7),-28);
	}
	
	@Test
	public void testPowerOfTwo() {
		assertEquals(IntegerOperationsUtils.powerOfTwo(0),1);
		assertEquals(IntegerOperationsUtils.powerOfTwo(1),2);
		assertEquals(IntegerOperationsUtils.powerOfTwo(10),1024);
	}
	
	@Test
	public void testLogN() {
		assertEquals(IntegerOperationsUtils.logn(1),0);
		assertEquals(IntegerOperationsUtils.logn(2),1);
		assertEquals(IntegerOperationsUtils.logn(4),2);
		assertEquals(IntegerOperationsUtils.logn(128),7);
	}

}
