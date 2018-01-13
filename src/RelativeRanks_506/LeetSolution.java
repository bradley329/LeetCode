package RelativeRanks_506;

import java.util.*;

public class LeetSolution {
	public String[] findRelativeRanks(int[] a)
	{
		int[] b = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		List<String> list = new ArrayList<>();
		int rank = 0;
		for (int i : a)
		{
			rank = a.length - Arrays.binarySearch(b, i);
			if (rank > 3)
			{
				list.add(Integer.toString(rank));
			}
			else if (rank == 3)
			{
				list.add("Bronze Medal");
			}
			else if (rank == 2)
			{
				list.add("Silver Medal");
			}
			else
			{
				list.add("Gold Medal");
			}
		}
		return list.toArray(new String[0]);
	}
}
