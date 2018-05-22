package flatten2D;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
	
	private List<List<Integer>> vec2d; 
	private int idx;
	//private List<Integer> nested;
	private int nestedidx;
	public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
		this.vec2d = vec2d;
		idx = 0;
		nestedidx = 0;
		//nested = vec2d.get(0);
    }

    public Integer next() {
        // Write your code here
    	Integer res = vec2d.get(idx).get(nestedidx);
    	if (nestedidx >= vec2d.get(idx).size() - 1) {
    		idx++;
			nestedidx = 0;
		} else {
			nestedidx++;
		} 
    	return res;
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        if (idx >= vec2d.size() || nestedidx >= vec2d.get(idx).size()) {
			return false;
		}
    	return true;
    }

    @Override
    public void remove() {
    }
}
