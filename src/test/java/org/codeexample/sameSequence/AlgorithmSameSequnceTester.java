package org.codeexample.sameSequence;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlgorithmSameSequnceTester {

	@Test
	public void testSameSequence() {
		assertTrue(AlgorithmSameSequnce.isInSameSequnce(new int[] { 2, 1 },
				new int[] { 3, 1, 2, 2, 1, 1 }));
		assertTrue(AlgorithmSameSequnce.isInSameSequnce(new int[] { 3, 1, 2, 2,
				1, 1 }, new int[] { 2, 1 }));

		assertFalse(AlgorithmSameSequnce.isInSameSequnce(new int[] { 2 },
				new int[] { 3 }));

		assertFalse(AlgorithmSameSequnce.isInSameSequnce(new int[] { 2, 1, 2 },
				new int[] { 3, 1, 3 }));
		assertFalse(AlgorithmSameSequnce.isInSameSequnce(new int[] { 2 },
				new int[] { 3, 1, 2, 2, 1, 1 }));
	}
}
