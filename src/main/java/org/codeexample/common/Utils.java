package org.codeexample.common;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	/**
	 * Concat two numbers together to generate new number.<br>
	 * For input, 1, 2, return 12.
	 * 
	 * @param ia
	 * @param ib
	 * @throws OverflowException
	 */
	public static int concat(int ia, int ib) throws OverflowException {
		int result = ia;
		int digitNumber = Utils.getNumberOfDigits(ib);
		// result = (10^digitNumber)*ia + ib;
		result = Utils.safeMultiply(new Double(Math.pow(10, digitNumber))
				.intValue(), result);
		result = Utils.safeAdd(result, ib);
		return result;
	}

	/**
	 * @param ia,
	 *            an Integer
	 * @return the digital number of Integer number
	 */
	public static int getNumberOfDigits(int ia) {
		int numberOfDigits = 1;
		ia = Math.abs(ia);
		ia = ia / 10;
		while (ia >= 1) {
			++numberOfDigits;
			ia = ia / 10;
		}
		return numberOfDigits;
	}

	/**
	 * @param ia
	 * @param newDigitalNumber
	 * @return pad the number by the original digital numbers in order. <br>
	 *         For example, for input 98, 5, it would return 98989 - five
	 *         numbers.
	 * @throws IllegalArgumentException,
	 *             if the new digital number is less than the digital number of
	 *             the old integer.
	 * @throws OverflowException,
	 *             if the generated number would be larger than
	 *             Integer.MAX_VALUE
	 */
	public static int rightPadNumber(int ia, int newDigitalNumber)
			throws IllegalArgumentException, OverflowException {
		int oldNumbers = getNumberOfDigits(ia);
		if (oldNumbers > newDigitalNumber) {
			throw new IllegalArgumentException(
					"Invalid parameters: "
							+ ia
							+ " has "
							+ oldNumbers
							+ " digits, its larger than the specified new digit number: "
							+ newDigitalNumber);
		} else if (oldNumbers == newDigitalNumber) {
			return ia; // Improve efficiency.
		}
		// example: to pad 98 to five numbers: 98988.
		boolean negative = ia < 0;
		if (negative) {
			ia = -ia;
		}
		String orginalString = String.valueOf(ia);
		StringBuffer resultString = new StringBuffer(orginalString);
		int diff = newDigitalNumber - oldNumbers;
		while (diff >= oldNumbers) {
			resultString.append(orginalString);
			diff -= oldNumbers;
		}
		// now, result = 9898, diff = 1; we need append addition one number 9.
		if (diff > 0) {
			resultString.append(orginalString.substring(0, diff));
		}
		if (negative) {
			resultString.insert(0, "-");
		}
		try {
			return Integer.valueOf(resultString.toString());
		} catch (NumberFormatException e) {
			throw new OverflowException(e);
		}
	}

	/**
	 * @param ia
	 * @param newDigitalNumber
	 * @return pad the number by the least digital number. <br>
	 *         For example, for input 98, 5, it would return 98888 - five
	 *         numbers, and the right numbers are padded with the least number
	 *         8.
	 * @throws IllegalArgumentException,
	 *             if the new digital number is less than the digital number of
	 *             the old integer.
	 * @throws OverflowException,
	 *             if the generated number would be larger than
	 *             Integer.MAX_VALUE
	 */
	public static int rightPadLeastDigitNumber(int ia, int newDigitalNumber)
			throws IllegalArgumentException, OverflowException {
		int oldNumbers = getNumberOfDigits(ia);
		if (oldNumbers > newDigitalNumber) {
			throw new IllegalArgumentException(
					"Invalid parameters: "
							+ ia
							+ " has "
							+ oldNumbers
							+ " digits, its larger than the specified new digit number: "
							+ newDigitalNumber);
		} else if (oldNumbers == newDigitalNumber) {
			return ia; // Improve efficiency.
		}
		boolean negative = ia < 0;
		if (negative) {
			ia = -ia;
		}
		String orginalString = String.valueOf(ia), leastDigitNumber = orginalString
				.substring(orginalString.length() - 1);
		StringBuffer resultString = new StringBuffer(orginalString);
		int diff = newDigitalNumber - oldNumbers;
		while (diff > 0) {
			resultString.append(leastDigitNumber);
			--diff;
		}
		if (negative) {
			resultString.insert(0, "-");
		}
		try {
			return Integer.valueOf(resultString.toString());
		} catch (NumberFormatException e) {
			throw new OverflowException(e);
		}
	}

	public static List<Integer> toList(int[] ia) {
		List<Integer> la = new ArrayList<Integer>();
		for (int i : ia) {
			la.add(i);
		}
		return la;
	}

	/**
	 * @see http://www.java2s.com/Tutorial/Java/0040__Data-Type/
	 *      Multiplytwolongintegerscheckingforoverflow.htm *
	 * @throws OverflowException
	 */
	public static int safeMultiply(int x, int y) throws OverflowException {
		int ret;
		String msg = "overflow: multiply, " + x + "*" + y;
		if (x > y) {
			ret = safeMultiply(y, x);
		} else {
			if (x < 0) {
				if (y < 0) {
					// check for positive overflow with negative a, negative b
					if (x >= Integer.MAX_VALUE / y) {
						ret = x * y;
					} else {
						throw new OverflowException(msg);
					}
				} else if (y > 0) {
					// check for negative overflow with negative a, positive b
					if (Integer.MIN_VALUE / y <= x) {
						ret = x * y;
					} else {
						throw new OverflowException(msg);
					}
				} else {
					// assert b == 0
					ret = 0;
				}
			} else if (x > 0) {
				// check for positive overflow with positive a, positive b
				if (x <= Integer.MAX_VALUE / y) {
					ret = x * y;
				} else {
					throw new OverflowException(msg);
				}
			} else {
				ret = 0;
			}
		}
		return ret;
	}

	/**
	 * @see http://www.coderanch.com/t/408408/java/java/
	 *      int-Addition-Subtraction-Overflow-Detection
	 * @throws OverflowException
	 */
	public static int safeAdd(int x, int y) throws OverflowException {
		String msg = "overflow: add, " + x + "+" + y;
		final int z = x + y;
		if (x > 0) {
			if (y > 0 && z < 0)
				throw new OverflowException(msg);
		} else if (y < 0 && z > 0) {
			throw new OverflowException(msg);
		}
		return z;
	}
}