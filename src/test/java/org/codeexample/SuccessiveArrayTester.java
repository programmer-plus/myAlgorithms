package org.codeexample;

import static org.junit.Assert.*;

import org.codeexample.successiveArray.SuccessiveArray;
import org.junit.Test;

public class SuccessiveArrayTester {

	@Test
	public void testIsArraySuccessive() {
		assertTrue(SuccessiveArray.isArraySuccessive(new int[] { 3, 2, 1 }));
		assertTrue(SuccessiveArray.isArraySuccessive(new int[] { 0, 3, 1 }));
		assertTrue(SuccessiveArray.isArraySuccessive(new int[] { 0, 0, 3, 1 }));

		// all negative numbers
		assertTrue(SuccessiveArray.isArraySuccessive(new int[] { -3, -2, -1 }));
		assertTrue(SuccessiveArray.isArraySuccessive(new int[] { 0, -3, -1 }));
		assertTrue(SuccessiveArray
				.isArraySuccessive(new int[] { 0, 0, -3, -1 }));

		// both negative and positive number
		assertTrue(SuccessiveArray.isArraySuccessive(new int[] { 0, 1, 2, -1,
				-2, -3 }));
		assertTrue(SuccessiveArray.isArraySuccessive(new int[] { 0, 0, 2, -1,
				-2, -3 }));
		assertTrue(SuccessiveArray.isArraySuccessive(new int[] { 0, 0, 0, 0,
				-1, -2, -3 }));

		// boundary case
		assertTrue(SuccessiveArray.isArraySuccessive(new int[] { 0, 0, 0 }));

		// false case
		assertFalse(SuccessiveArray.isArraySuccessive(new int[] { 1, 3 }));
		assertFalse(SuccessiveArray.isArraySuccessive(new int[] { 1, 4, 0 }));
		assertFalse(SuccessiveArray.isArraySuccessive(new int[] { 1, 5, 0, 0 }));

	}
}
