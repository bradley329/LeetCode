package traprainwater2_407;
//https://leetcode.com/problems/trapping-rain-water-ii/description/

import java.util.PriorityQueue;

class Cell implements Comparable<Cell> {
	public int x, y, h;
	public Cell(int x, int y, int h) {
		this.x = x;
		this.y = y;
		this.h = h;
	}
	
	@Override
	public int compareTo(Cell o) {
		// TODO Auto-generated method stub
		if (this.h == o.h) {
			return 0;
		} else if (this.h < o.h) {
			return -1;
		} else {
			return 1;
		}
	}
}
public class Solution {
	public int trapRainWater(int[][] heightMap) {
		if(heightMap.length == 0)  
	        return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        int []dx = {1,-1,0,0};
        int []dy = {0,0,1,-1};
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        int [][]visit = new int[m][n];
        
        //�ǰ�ÿ�е�һ�����һ����ӣ�
        for(int i = 0; i < m; i++) {
          pq.offer(new Cell(i,0,heightMap[i][0]));
          pq.offer(new Cell(i,n-1,heightMap[i][n-1]));
          visit[i][0] = 1;
          visit[i][n-1] = 1;
        }
        //Ϊ�����ظ��ĸ��ǣ���1��m-1��
        for(int i = 1; i < n-1; i++) {
          pq.offer(new Cell(0,i,heightMap[0][i]));
          pq.offer(new Cell(m-1,i,heightMap[m-1][i]));
          visit[0][i] = 1;
          visit[m-1][i] = 1;
        }
        
        int res = 0;      
        while(!pq.isEmpty()) {           
            Cell now = pq.poll();           
            for(int i = 0; i < 4; i++) {
              
              int x = now.x + dx[i];
              int y = now.y + dy[i];
              //ͨ��visit ���Ա�֤һ�������⵽�ڵģ�
              if(0<=x && x < m && 0 <= y && y < n && visit[x][y] == 0) {
                visit[x][y] = 1;
                //����������ľͰ��ˮλ������������Χ���ϴ�ֵ�� �� ����Сֵ����
                pq.offer(new Cell(x, y, Math.max(now.h, heightMap[x][y]))); //һ����max
                res = res + Math.max(0, now.h - heightMap[x][y]);
              }              
            }
         }
         return res;
    }
}