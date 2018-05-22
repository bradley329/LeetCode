package flatten2D;

import java.util.Iterator;
import java.util.List;

public class Vector2Dii implements Iterator<Integer> {

	private Iterator<List<Integer>> i;
	private Iterator<Integer> j;
	public Vector2Dii(List<List<Integer>> vec2d) {
        // Initialize your data structure here
		this.i = vec2d.iterator();
		this.j = null;
		//nested = vec2d.get(0);
    }
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return j.next();
	}

}
