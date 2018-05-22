import java.io.*;
import java.util.*;


class TreeNode {
	String s;
	boolean ischild;
	int prio;
	List<TreeNode> children;
	public TreeNode(String s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		ischild = false;
		children = new ArrayList<>();
		prio = 0;
	}
}
public class Intuit_OA {
  public static List<List<String>> create_workflow_stages(List<List<String>> precursor_steps) {
    // IMPLEMENTATION GOES HERE
	  HashMap<String, TreeNode> map = new HashMap<>();
	  //HashMap<Integer, List<String>> revMap = new HashMap<>();
	  if(precursor_steps.size() > 0) {
		  List<List<String>> res = new ArrayList<List<String>>();
		  for (List<String> slist: precursor_steps) {
			  String s1 = slist.get(0);
			  String s2 = slist.get(1);
			  if (map.containsKey(s1)) {
				  if (map.containsKey(s2)) {
					  TreeNode tp = map.get(s2);
					  tp.ischild = true;
					  map.get(s1).children.add(tp);
				} else {
					TreeNode tp = new TreeNode(s2);
					tp.ischild = true;
					map.put(s2, tp);
					map.get(s1).children.add(tp);
				}		
			  } else if (map.containsKey(s2)) {
				  TreeNode tp = new TreeNode(s1);
				  TreeNode tp2 = map.get(s2);
				  tp2.ischild = true;
				  tp.children.add(tp2);
				  map.put(s1, tp);
			  } else {
				  TreeNode t1 = new TreeNode(s1);
				  TreeNode t2 = new TreeNode(s2);
				  t2.ischild = true;
				  t1.children.add(t2);
				  map.put(s1, t1);
				  map.put(s2, t2);
			  }
		}
		  //adj list
		  List<TreeNode> nodelist = new ArrayList<>();
		  for (String s : map.keySet()) {
			  nodelist.add(map.get(s));	
		  }
		  int[] maxPrio = new int[1];
		  for (TreeNode t: nodelist) {
			  if (!t.ischild) {
				DFS(t.children, t.prio, maxPrio);
			}
		  }
		  //System.out.println("xx");
		  //System.out.println(maxPrio);
		  for (int i = 0; i <= maxPrio[0]; i++) {
			res.add(new ArrayList<String>());
		}
		  for (TreeNode t: nodelist) {
			res.get(t.prio).add(t.s);
		}
		  //System.out.println(res);
		  return res;
	  }
	  
    return null;
  }

  	private static void DFS(List<TreeNode> children, int prio_parent, int[] maxPrio) {
	// TODO Auto-generated method stub
	if (children.size() == 0) {
		return;
	}
	for(TreeNode child : children) {
		child.prio = Math.max(child.prio, prio_parent+1);
		maxPrio[0] = Math.max(maxPrio[0], child.prio);
		DFS(child.children, child.prio, maxPrio);
	}
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
