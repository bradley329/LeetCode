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
		//����ڱ߽�����ʱ�� �����!��2147483647-(-2147483648) = -1
        //return this.val - o.val;
		return Integer.compare(this.val, o.val);
	}
}

public class LeetSolution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Node> minHeap = new TreeSet<>();
		TreeSet<Node> maxHeap = new TreeSet<>();
		//ע�� ʵ����������minheap
		
		if (k == 0) {
			return null;
		}
        int len = nums.length;
        int resSize = len - k + 1;
		double res[] = new double[resSize];
		int halfSize = (k+1)/2; // minHeap size;
		//һ��Ҫ�Ͳ�һ�������ˣ�
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
		//����ط����׳�����
		//�ڼӵ�minheap��һ������halfsize����Ҫ����Ƿ�Ӧ�û���maxheap�У�
		//����heap��д���ˣ�ʵ����min��max
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