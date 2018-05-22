package BinarySearch;

class ArrayReader {
	 // get the number at index, return -1 if index is less than zero.
	 public int get(int index) {return 0;};
}
//2*O(log(k))
public class SearchinaBigSortedArray {
	public int searchBigSortedArray(ArrayReader reader, int target) {
		int index = 1;
        while (reader.get(index - 1) < target) {
            index = index * 2;
        }
        
        int start = 0, end = index - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (reader.get(start) == target) {
            return start;
        }
        
        if (reader.get(end) == target) {
            return end;
        }
        
        return -1;
	}
}
