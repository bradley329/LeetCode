package oa;

import java.io.*;
import java.util.*;

public class Solution {
  public static List<List<String>> create_workflow_stages(List<List<String>> precursor_steps) {
    // IMPLEMENTATION GOES HERE
	  HashMap<String, Integer> map = new HashMap<>();
	  HashMap<Integer, List<String>> revMap = new HashMap<>();
	  if(precursor_steps.size() > 0) {
		  List<List<String>> res = new ArrayList<List<String>>();
		  for (List<String> slist: precursor_steps) {
			  String s1 = slist.get(0);
			  String s2 = slist.get(1);
			  if (map.containsKey(s1)) {
				  if (!map.containsKey(s2)) {
					  map.put(s2, map.get(s1)+1);
				  } else {
					  map.put(s2, Math.max(map.get(s1)+1, map.get(s2)));
				  }				
			  } else if (map.containsKey(s2)) {
				  map.put(s1, map.get(s2)-1);
			  } else {
				  map.put(s1, 1);
				  map.put(s2, 2);
			  }
		}
		  for (String s : map.keySet()) {
			  int priority = map.get(s);
			  if (revMap.containsKey(priority)) {
				  revMap.get(priority).add(s);
			} else {
				List<String> tp = new ArrayList<>();
				tp.add(s);
				revMap.put(priority, tp);
			}			
		  }
		  System.out.println(revMap.size());
		  Integer[] prio_arr = revMap.keySet().toArray(new Integer[revMap.size()]);
		  Arrays.sort(prio_arr);
		  for (Integer prio : prio_arr) {
			  System.out.println(prio);
			res.add(revMap.get(prio));
		}
		  System.out.println(res);
		  return res;
	  }
	  
    return null;
  }

  /* START TEST CASES
   * You can add test cases in the two lists below. Each test case
   * input/expected output should correspond to the same index in the
   * respective lists returned.
   */
  static List<List<List<String>>> testInputs = Arrays.asList(
    Arrays.asList(
      Arrays.asList("clean","build"),
      Arrays.asList("metadata","binary"),
      Arrays.asList("build","link"),
      Arrays.asList("link","binary"),
      Arrays.asList("clean","metadata"),
      Arrays.asList("build","resources")
    ),
    Arrays.asList(
      Arrays.asList("boil","serve"),
      Arrays.asList("chop", "boil"),
      Arrays.asList("stir", "boil"),
      Arrays.asList("set table", "serve")
    )
  );

  static List<List<List<String>>> testOutputs = Arrays.asList(
    Arrays.asList(
      Arrays.asList("clean"),
      Arrays.asList("build","metadata"),
      Arrays.asList("resources","link"),
      Arrays.asList("binary")
    ),
    Arrays.asList(
      Arrays.asList("chop","stir","set table"),
      Arrays.asList("boil"),
      Arrays.asList("serve")
    )
  );
  // END TEST CASES

  // DO NOT MODIFY BELOW THIS LINE
  public static boolean equalOutputs(List<List<String>> a, List<List<String>> b) {
    if (a.size() != b.size()) {
      return false;
    }
    for (int i = 0; i < a.size(); i++) {
      List<String> a1 = a.get(i);
      List<String> b1 = b.get(i);
      a1.sort(null);
      b1.sort(null);
      if (!a1.equals(b1)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    for (int i = 0; i < testInputs.size(); i++) {
      try {
        List<List<String>> result = create_workflow_stages(testInputs.get(i));

        if (equalOutputs(result, testOutputs.get(i))) {
          System.out.println("Pass");
        } else {
          System.out.println("Fail");
        }
      } catch (Exception e) {
        System.out.println("Fail");
        System.out.println(e);
      }
    }
  }
}
