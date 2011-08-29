package org.codeexample.successiveArray;

public class SuccessiveArray {

	/**
	 * see http://programer-tips.blogspot.com/
	 * 2011/08/is-array-successive.html
	 * <p>
	 * Determine whether the unordered array is logically successive, 0 can be
	 * regarded as any number. For example, [0, 3, 1] is successive, as 0 can be
	 * regarded as 2.
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isArraySuccessive(int[] array) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			int temp = array[i];
			if (temp == 0)
				continue;
			if (temp < min) {
				min = temp;
			}
			if (temp > max) {
				max = temp;
			}
		}
		return (max - min) <= (array.length - 1);
	}
}
