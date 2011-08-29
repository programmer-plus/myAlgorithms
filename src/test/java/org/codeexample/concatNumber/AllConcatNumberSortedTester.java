package org.codeexample.concatNumber;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.codeexample.common.OverflowException;
import org.junit.Test;
public class AllConcatNumberSortedTester implements
		Cloneable {
	@Test
	public void testAllNumberComination() {
		List<Integer> la = Arrays
				.asList(new Integer[] { 1 });
		List<Integer> result = AllConcatNumberSorted
				.concatNumbersSored(la);
		assertEquals(1, result.size());
		assertArrayEquals(new Integer[] { 1 }, result
				.toArray(new Integer[] {}));
		// test case 2
		la = Arrays.asList(new Integer[] { 1, 2 });
		result = AllConcatNumberSorted
				.concatNumbersSored(la);
		assertEquals(2, result.size());
		assertArrayEquals(new Integer[] { 12, 21 }, result
				.toArray(new Integer[] {}));
		la = Arrays.asList(new Integer[] { 2, 1 });
		assertArrayEquals(new Integer[] { 12, 21 }, result
				.toArray(new Integer[] {}));
		// test case 3: 1, 23, 45
		la = Arrays.asList(new Integer[] { 1, 23, 45 });
		result = AllConcatNumberSorted
				.concatNumbersSored(la);
		assertEquals(6, result.size());
		assertArrayEquals(new Integer[] { 12345, 14523,
				23145, 23451, 45123, 45231 }, result
				.toArray(new Integer[] {}));
		// different order
		la = Arrays.asList(new Integer[] { 23, 1, 45 });
		assertArrayEquals(new Integer[] { 12345, 14523,
				23145, 23451, 45123, 45231 }, result
				.toArray(new Integer[] {}));
		la = Arrays.asList(new Integer[] { 23, 45, 1 });
		assertArrayEquals(new Integer[] { 12345, 14523,
				23145, 23451, 45123, 45231 }, result
				.toArray(new Integer[] {}));
		// boundary case
		la = Arrays.asList(new Integer[] { 0, 0, 0 });
		result = AllConcatNumberSorted
				.concatNumbersSored(la);
		assertEquals(1, result.size());
		assertArrayEquals(new Integer[] { 0 }, result
				.toArray(new Integer[] {}));
		la = Arrays.asList(new Integer[] { 1, 1, 23 });
		result = AllConcatNumberSorted
				.concatNumbersSored(la);
		assertEquals(3, result.size());
		assertArrayEquals(
				new Integer[] { 1123, 1231, 2311 }, result
						.toArray(new Integer[] {}));
		// different order
		la = Arrays.asList(new Integer[] { 1, 23, 1 });
		assertArrayEquals(
				new Integer[] { 1123, 1231, 2311 }, result
						.toArray(new Integer[] {}));
		la = Arrays.asList(new Integer[] { 23, 1, 1 });
		assertArrayEquals(
				new Integer[] { 1123, 1231, 2311 }, result
						.toArray(new Integer[] {}));
	}
	@Test(expected = IllegalArgumentException.class)
	public void faliHasNegative() {
		List<Integer> la = Arrays.asList(new Integer[] {
				-1, -2, -3 });
		AllConcatNumberSorted.concatNumbersSored(la);
	}
	@Test(expected = OverflowException.class)
	public void faliOverflow() {
		List<Integer> la = Arrays.asList(new Integer[] { 1,
				Integer.MAX_VALUE });
		AllConcatNumberSorted.concatNumbersSored(la);
	}
}
