package slidingwindowmedian_480;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//��������õ�TreeMap ���ȿ����뵽��PQ�е���
//������Ҫ��֤sliding window���Ԫ����ɾ��˳��
//PQ��ֻ��ȡmin/max
//this is the lintcode version
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
        return this.val - o.val;
	}
}

public class Solution {
	public List<Integer> medianSlidingWindow(int[] nums, int k) {
		TreeSet<Node> minHeap = new TreeSet<>();
		TreeSet<Node> maxHeap = new TreeSet<>();
		List<Integer> res = new ArrayList<Integer>();
		if (k == 0) {
			return res;
		}
		int halfSize = (k+1)/2; // minHeap size;
		for (int i = 0; i < k-1; i++) {
			addToheap(minHeap, maxHeap, halfSize, new Node(i, nums[i]));
		}
		for(int i = k-1; i < nums.length; i++) {
            addToheap(minHeap, maxHeap, halfSize, new Node(i, nums[i]));
            res.add(minHeap.last().val);
            remove(minHeap, maxHeap, new Node(i-(k-1), nums[i-k+1]));
        }
        return res;
	}
	
	void addToheap(TreeSet<Node> minHeap, TreeSet<Node> maxHeap, int halfSize, Node node) {
		//����ط����׳�����
		//�ڼӵ�minheap��һ������halfsize����Ҫ����Ƿ�Ӧ�û���maxheap�У�
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
