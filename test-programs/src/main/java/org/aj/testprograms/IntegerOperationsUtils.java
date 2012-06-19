package org.aj.testprograms;

public class IntegerOperationsUtils {

	public static int negate(int a) {
		return add(~a, 1);
	}

	public static int add(int a, int b) {
		//
		int sum = a ^ b;
		int carry = a & b;

		while (carry != 0) {
			carry <<= 1;
			a = sum;
			b = carry;
			sum = a ^ b;
			carry = a & b;
		}

		return sum;
	}

	public static int subtract(int a, int b) {
		return add(a, negate(b));
	}

	public static int multiplyUsingBitwise(int a, int b) {
		if (a == 0 || b == 0)
			return 0;

		int signFlag = 0;

		if (a < 0) {
			a = negate(a);
			signFlag ^= 1;
		}
		if (b < 0) {
			b = negate(b);
			signFlag ^= 1;
		}

		int result = 0;

		while (b != 0) {
			if ((b & 1) == 1) {
				result += a;
			}

			a <<= 1;
			b >>= 1;
		}

		if ((signFlag & 1) == 1)
			return negate(result);
		else
			return result;
	}

	public static int multiplyUsingAdd(int a, int b) {
		// multiply using add function
		// check for zeroes
		if (a == 0 || b == 0)
			return 0;

		int signFlag = 0;

		if (a < 0) {
			a = negate(a);
			signFlag ^= 1;
		}
		if (b < 0) {
			b = negate(b);
			signFlag ^= 1;
		}

		int result = 0;
		int count = 1;
		while (count <= b) {
			result = add(result, a);
			count = add(count, 1);
		}
		if ((signFlag & 1) == 1)
			return negate(result);
		else
			return result;
	}
	
	public static int multiplyUsingRecursion(int a, int b){
		if( b == 0 )
			return 0;
		
		if( b == 1)
			return a;
		
		if( b > 0)
			return (a + multiplyUsingRecursion(a, b -1));
		else 
			return (-multiplyUsingRecursion(a, -b));
		
	}
	
	public static int powerOfTwo(int n){
		return 1<<n;
	}
	
	public static int logn(int n){
		int result = 0;
		n>>=1;
		while(n != 0){
			++result;
			n>>=1;
		}
		return result;
	}
}
