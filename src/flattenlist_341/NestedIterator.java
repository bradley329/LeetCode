package flattenlist_341;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
interface NestedInteger {
     // @return true if this NestedInteger holds a single integer,
     // rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds,
     // if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds,
     // if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
}
public class NestedIterator implements Iterator<Integer> {	
	Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
    	for (int i = nestedList.size() - 1; i >= 0; i--) {
    		//这样stackpop的顺序就是正的;
			stack.push(nestedList.get(i));
		}
    }
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		while (!stack.isEmpty()) {
			NestedInteger cur = stack.peek();
			if (cur.isInteger()) {
				return true;
			} else {
				stack.pop();
				for(int i = cur.getList().size()-1; i >= 0; i--) {
					stack.push(cur.getList().get(i));
				}
			}
		}
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return stack.pop().getInteger();
	}
}