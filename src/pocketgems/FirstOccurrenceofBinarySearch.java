package pocketgems;

public class FirstOccurrenceofBinarySearch {
	public int firstOccurrenceBinarySearch(int[] source, int key) {
		int low = 0;
		int high = source.length - 1;
		int firstOccurrence = Integer.MIN_VALUE;
		while (low <= high) {
			int middle = low + ((high - low) >>> 1);
			if (source[middle] == key) {
				// key found and we want to search an earlier occurrence
				firstOccurrence = middle;
				high = middle - 1;
			} else if (source[middle] < key) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		if (firstOccurrence != Integer.MIN_VALUE) {
			return firstOccurrence;
		}
		return -1; // key not found
	}
}
