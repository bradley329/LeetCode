package topkfrequentwords_692;

import java.util.*;
import java.util.Map.Entry;

public class TreeSetSolution {
	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        Comparator<Map.Entry<String, Integer>> MyCom = new Comparator<Map.Entry<String,Integer>>() {
			
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				if (o1.getValue() != o2.getValue()) {
                    return  o2.getValue() - o1.getValue();
                } else {
                    return o1.getKey().compareToIgnoreCase(o2.getKey());
                }
			}
		};
        SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<>(MyCom);
        //comparator using lambda:
       /*SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<>(
                (e1, e2) -> {
                    if (e1.getValue() != e2.getValue()) {
                        return e2.getValue() - e1.getValue();
                    } else {
                        return e1.getKey().compareToIgnoreCase(e2.getKey());
                    }
                });*/
        sortedset.addAll(map.entrySet());
        List<String> res = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> iterator = sortedset.iterator();
        while (iterator.hasNext() && k-- > 0) {
            res.add(iterator.next().getKey());
        }
        return res;
    }
}
