import java.util.HashMap;
import java.util.Map;

public class testNull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		HashMap<Integer, Map<Integer, Integer>> ha = new HashMap<>();
//		ha.put(3, new HashMap<>());
//		System.out.println(ha.get(3)!=null);
		int[] a = new int[1];
		int[] b = a;
		a[0] = 1;
		System.out.println(b[0]);
	}

}
