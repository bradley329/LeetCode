package PureStorage;

import java.util.*;

public class OA2 {
	public int checkSequence(String[] events){
        if (events == null || events.length < 1){
        	return 0;
        }
        int step = 1;
        Stack<String> lock = new Stack<String>();
        Set<String> records = new HashSet<String>();
        for (String l : events) {
            String[] array = l.split(" ");
            if (array[0].equals("ACQUIRE")) {
                if(records.contains(array[1])) { 
                	return step; 
                }
                records.add(array[1]);
                lock.push(array[1]);
            } else {
                if(lock.isEmpty() || !lock.peek().equals(array[1])){
                	return step;
                }
                lock.pop();
                records.remove(array[1]);
            }
            step++;
        }
        if (!lock.isEmpty()) {
        	return events.length + 1;
        }
        return 0;
	}
}
