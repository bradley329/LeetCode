package getRandom_380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
//仍然有bug 为了改那个典型的bug 弄得有了另外一个bug
public class WrongRandomizedSet {
	
	//private HashSet<Integer> set;
	private ArrayList<Integer> setList;
	private HashMap<Integer, Integer> map;
	private int cap;
	private int rem = 0;
    /** Initialize your data structure here. */
    public WrongRandomizedSet() {
    	//set = new HashSet<>();
    	map = new HashMap<>(); 
    	cap = 0;
    	setList = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
        	map.put(val, cap);
        	setList.add(val);
        	cap++;
			return true;
		}
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	rem++;
    	if (map.containsKey(val)) {
    		System.out.print("第"); System.out.print(rem);
    		System.out.print(" removing total size: ");
    		System.out.print(setList.size());
    		System.out.print(" removing index: ");
    		int idx = map.get(val);
    		System.out.println(idx);
        	map.remove(val);
        	//这有很严重的bug，一旦这remove调 会影响后面所有的数的index
        	//那么 mapget出来的原有index就不对了！
        	//setList.remove(idx);
        	//cap--;
			return true;
		}
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        //bug 因为为了不动map里的index，list里该删的没删。
        int n = rand.nextInt(map.size());
        return setList.get(n);
    }
}