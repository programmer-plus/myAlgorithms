package org.codeexample.common;
import java.util.HashMap;
public class ArrayUtils {
	public static <T> boolean equalsIgnoreOrder(T[] ta,
			T[] tb) {
		if (ta == tb)
			return true;
		if (ta.length != tb.length)
			return false;
		HashMap<T, Integer> taMap = tTimes(ta), tbMap = tTimes(tb);
		if (taMap.size() != tbMap.size())
			return false;
		for (T key : taMap.keySet()) {
			if (!tbMap.containsKey(key))
				return false;
			if (taMap.get(key) != tbMap.get(key))
				return false;
		}
		return true;
	}
	private static <T> HashMap<T, Integer> tTimes(T[] ta) {
		HashMap<T, Integer> resultMap = new HashMap<T, Integer>();
		for (T tmp : ta) {
			int times = 0;
			if (resultMap.containsKey(tmp)) {
				times = resultMap.get(ta) + 1;
			}
			resultMap.put(tmp, times);
		}
		return resultMap;
	}
}
