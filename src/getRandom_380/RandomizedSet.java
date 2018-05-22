package getRandom_380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
	//private HashSet<Integer> set;
	private ArrayList<Integer> setList;
	private HashMap<Integer, Integer> map;
	private int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
    	//set = new HashSet<>();
    	map = new HashMap<>(); 
    	size = 0;
    	setList = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
        	map.put(val, size);
        	setList.add(val);
        	size++;
			return true;
		}
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if (map.containsKey(val)) {  		
    		int idx = map.get(val);
    		map.remove(val);
    		if (idx < size - 1) {
				//最牛逼的一部：
    			int last = setList.get(size - 1);
    			setList.set(idx, last);    			
    			map.put(last, idx);
			}
    		setList.remove(size - 1);
    		size--;
			return true;
		}
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        //bug 因为为了不动map里的index，list里该删的没删。
        int n = rand.nextInt(size);
        return setList.get(n);
    }
}
