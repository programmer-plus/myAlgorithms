package org.codeexample.sameSequence;

import java.util.ArrayList;
import java.util.List;
import org.codeexample.common.Utils;

public class AlgorithmSameSequnce {

	/**
	 * see
	 * http://programer-tips.blogspot.com/2011/08/two-integer-arrays-from-same-sequence.html
	 * <p>
	 * 
	 * @param arrayA
	 * @param arrayB
	 * @return
	 */
	public static boolean isInSameSequnce(int[] arrayA, int[] arrayB) {
		return isInSameSequnce(Utils.toList(arrayA), Utils.toList(arrayB));
	}

	/**
	 * see
	 * http://programer-tips.blogspot.com/2011/08/two-integer-arrays-from-same-sequence.html
	 */
	public static boolean isInSameSequnce(List<Integer> listA,
			List<Integer> listB) {
		List<Integer> listACopy = new ArrayList<Integer>(listA);
		if (isInSameSequnceImpl(listA, listACopy, listB))
			return true;
		List<Integer> listBCopy = new ArrayList<Integer>(listB);
		return isInSameSequnceImpl(listB, listBCopy, listA);
	}

	private static boolean isInSameSequnceImpl(List<Integer> listA,
			List<Integer> interim, List<Integer> listB) {
		List<Integer> previous = getPrevious(interim);
		if (previous.equals(listB))
			return true;
		// meet listA again
		if (previous.equals(listA))
			return false;
		if (previous.isEmpty())
			return false;
		return isInSameSequnceImpl(listA, previous, listB);
	}

	/**
	 * Return the previous array, for example, the previous array of [2, 1]
	 * would be [1, 1], the previous of [1, 2, 1, 1] would be [2, 1]. <br>
	 * If the list is invalid or can't induce its previous array, return one
	 * empty list.
	 * 
	 * @param list
	 * @return
	 */
	private static List<Integer> getPrevious(List<Integer> list) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		// if the list has odd number, return empty list;
		if (list.size() % 2 == 1)
			return result;

		for (int i = 0; i <= list.size() - 2;) {
			int times = list.get(i++);

			// no previous row for input [0, 1],
			if (times == 0)
				return new ArrayList<Integer>();
			int digit = list.get(i++);
			for (int j = 0; j < times; j++) {
				result.add(digit);
			}
		}
		return result;
	}
}
