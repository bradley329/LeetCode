package slidingwindowmedian_480;

import java.util.TreeSet;

class Node implements Comparable<Node> {
	public int val;
	public int index;
	public Node(int index, int val) {
		// TODO Auto-generated constructor stub
		this.val = val;
		this.index = index;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if (this.val == o.val) {
            return this.index - o.index;
        }
		//这个在边界条件时候 会出错!当2147483647-(-2147483648) = -1
        //return this.val - o.val;
		return Integer.compare(this.val, o.val);
	}
}

public class LeetSolution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Node> minHeap = new TreeSet<>();
		TreeSet<Node> maxHeap = new TreeSet<>();
		//注意 实际上他都是minheap
		
		if (k == 0) {
			return null;
		}
        int len = nums.length;
        int resSize = len - k + 1;
		double res[] = new double[resSize];
		int halfSize = (k+1)/2; // minHeap size;
		//一定要就差一个就满了！
		for (int i = 0; i < k-1; i++) {
			addToheap(minHeap, maxHeap, halfSize, new Node(i, nums[i]));
		}
		int j = 0;
		if (k%2 == 0) {
			for(int i = k-1; i < len; i++) {
	            addToheap(minHeap, maxHeap, halfSize, new Node(i, nums[i]));
	            res[j] = (minHeap.last().val + maxHeap.first().val)/2;
	            remove(minHeap, maxHeap, new Node(i-(k-1), nums[i-k+1]));
	            j++;
	        }
		} else {
			for(int i = k-1; i < len; i++) {
	            addToheap(minHeap, maxHeap, halfSize, new Node(i, nums[i]));
	            res[j] = minHeap.last().val;
	            remove(minHeap, maxHeap, new Node(i-(k-1), nums[i-k+1]));
	            j++;
	        }
		}
        return res;
	}
	
	void addToheap(TreeSet<Node> minHeap, TreeSet<Node> maxHeap, int halfSize, Node node) {
		//这个地方及易出错！！
		//在加到minheap里一旦等于halfsize，就要检测是否应该换到maxheap中；
		//这两heap她写反了，实际上min是max
		if (minHeap.size() < halfSize) {
			minHeap.add(node);
		} else {
			maxHeap.add(node);
		}
		if (minHeap.size() == halfSize) {
			if (maxHeap.size() >0 && minHeap.last().val > maxHeap.first().val) {
                Node s = minHeap.last();
                Node b = maxHeap.first();
                minHeap.remove(s);
                maxHeap.remove(b);
                minHeap.add(b);
                maxHeap.add(s);
            }
		}
	}
	
	void remove(TreeSet<Node> minHeap, TreeSet<Node> maxHeap, Node node) {
		if (minHeap.contains(node)) {
            minHeap.remove(node);
        }
        else {
            maxHeap.remove(node);
        }
	}
}