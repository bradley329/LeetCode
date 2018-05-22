package minimumwindowsubstring_76;

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if(target.length()==0) return "";
        int b = 0, e = 0, rb = 0, rlen = Integer.MAX_VALUE;
        int map[] = new int[256], missing = target.length();
        for (char c : target.toCharArray()) map[c]--; // map[c] < 0 means c is missing
        while (e < source.length() || missing==0) {
            if (missing <= 0) {
                if (e - b < rlen) {
                	rlen = e - b;
                	rb = b;
                }
                //现在不想要b，可是这个b如果是我们想要的一个char呢？
                //就要复原；
                //since missing == 0, so b>0 means we could discard that b and no effect on missing;
                if (map[source.charAt(b)] == 0) {
                	missing++;
                }
                map[source.charAt(b)]--;
                b++;
            } else {
            	if (map[source.charAt(e)] < 0) {
            		missing--;
            	}
            	map[source.charAt(e)]++;
            	e++;
            }
        } 
        return rlen > source.length() ? "" : source.substring(rb, rb + rlen);
    }
}