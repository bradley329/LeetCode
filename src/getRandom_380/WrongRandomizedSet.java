package getRandom_380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
//��Ȼ��bug Ϊ�˸��Ǹ����͵�bug Ū����������һ��bug
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
    		System.out.print("��"); System.out.print(rem);
    		System.out.print(" removing total size: ");
    		System.out.print(setList.size());
    		System.out.print(" removing index: ");
    		int idx = map.get(val);
    		System.out.println(idx);
        	map.remove(val);
        	//���к����ص�bug��һ����remove�� ��Ӱ��������е�����index
        	//��ô mapget������ԭ��index�Ͳ����ˣ�
        	//setList.remove(idx);
        	//cap--;
			return true;
		}
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        //bug ��ΪΪ�˲���map���index��list���ɾ��ûɾ��
        int n = rand.nextInt(map.size());
        return setList.get(n);
    }
}