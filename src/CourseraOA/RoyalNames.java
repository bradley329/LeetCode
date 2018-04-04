package CourseraOA;

import java.util.*;

class Person {
    String name;
    int num;
    Person(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
  
        
public class RoyalNames {
	String[] getSortedList(String[] names) {
	    if (names.length < 2) {
	        return names;
	    }
	    Person[] persons = new Person[names.length];
	    HashMap<Person, String> personName = new HashMap<>();
	    String[] ans = new String[names.length];
	    
	    for (int i=0; i<names.length; i++) {
	        String[] name = names[i].split(" ");
	        int num = romantoint(name[1]);
	        Person p = new Person(name[0], num);
	        persons[i] = p;
	        personName.put(p, names[i]);
	    }
	       
	    Arrays.sort(persons, new Comparator<Person>() {
	        @Override
	        public int compare(Person p1, Person p2) {
	            String s1 = p1.name;
	            String s2 = p2.name;
	            if (s1.compareTo(s2) != 0) {
	                return s1.compareTo(s2);
	            } else {
	                return p1.num - p2.num;
	            }
	        }
	    });
	    
	    for (int i=0; i<persons.length; i++) {
	        ans[i] = personName.get(persons[i]);
	    }
	    return ans;
	}

	private static int romantoint(String s) {
	    if (s==null || s.length()==0) {
	        return 0;
	    }
	    Map<Character, Integer> m = new HashMap<Character, Integer>();
	    m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50); 
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);
	    
	    int length = s.length();
	    int result = m.get(s.charAt(length-1));
	    for (int i=length-2; i>=0; i--) {
	        if (m.get(s.charAt(i+1)) <= m.get(s.charAt(i))) {
	            result += m.get(s.charAt(i));
	        } else {
	            result -= m.get(s.charAt(i));
	        }
	    }
	    return result;
	}
}
