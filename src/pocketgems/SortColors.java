package pocketgems;

public class SortColors {
	public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        
        int pl = 0;
        int pr = a.length - 1;
        int i = 0;
        //note: all the elements before i could only be 0 or 1
        while (i <= pr) {
            if (a[i] == 0) {
                swap(a, pl, i); // since all 2s are swaped to the tail
                // only could be 1 swaped to i
                pl++;
                // thus we could i++
                i++;
            } else if(a[i] == 1) {
                i++;
            } else {
                swap(a, pr, i);
                pr--;
            }
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
