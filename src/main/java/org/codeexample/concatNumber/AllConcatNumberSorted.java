package org.codeexample.concatNumber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.codeexample.common.OverflowException;
import org.codeexample.common.Utils;
public class AllConcatNumberSorted {
	/**
	 * This method would concatenate each integer value of the list in ascending
	 * order.
	 * 
	 * @param la,
	 *            a list of positive integer numbers
	 * @return all unique concatenate integer numbers from the list in ascending
	 *         order.
	 * @throws IllegalArgumentException,
	 *             if the parameter list contains negative value.
	 * @throws OverflowException,
	 *             it one possible concatenate integer number is greater than
	 *             Integer.MAX_VALUE
	 */
	public static List<Integer> concatNumbersSored(
			List<Integer> la)
			throws IllegalArgumentException,
			OverflowException {
		Collections.sort(la);
		Set<List<Integer>> permutations = concatNumbersSortedImpl(
				la, 0);
		List<Integer> results = new ArrayList<Integer>();
		for (List<Integer> intList : permutations) {
			int result = 0;
			for (int tmpInt : intList) {
				result = Utils.concat(result, tmpInt);
			}
			results.add(result);
		}
		return results;
	}
	private static Set<List<Integer>> concatNumbersSortedImpl(
			List<Integer> la, int level) {
		// use linked hash set to keep the inserted order.
		Set<List<Integer>> permutations = new LinkedHashSet<List<Integer>>();
		// base case
		if (level == la.size() - 1) {
			if (la.get(level) < 0)
				throw new IllegalArgumentException(
						"Invalid number: " + la.get(level));
			List<Integer> result = new LinkedList<Integer>();
			result.add(la.get(level));
			permutations
					.add(new LinkedList<Integer>(result));
			return permutations;
		}
		int head = la.get(level);
		if (head < 0)
			throw new IllegalArgumentException(
					"Invalid number: " + head);
		Set<List<Integer>> subPermutations = concatNumbersSortedImpl(
				la, ++level);
		// first insert head to the first position of the sub result
		for (List<Integer> tmpList : subPermutations) {
			List<Integer> tmp = new LinkedList<Integer>(
					tmpList);
			tmp.add(0, head);
			permutations.add(tmp);
		}
		for (List<Integer> tmpList : subPermutations) {
			// add head to other possible n positions
			for (int i = 1; i <= tmpList.size(); i++) {
				List<Integer> tmp = new LinkedList<Integer>(
						tmpList);
				tmp.add(i, head);
				permutations.add(tmp);
			}
		}
		return permutations;
	}
}
