package wordsearch2_212;

import java.util.*;

public class Solution {
	public int []dx = {1, 0, -1, 0};
    public int []dy = {0, 1, 0, -1};
    
    public void search(char[][] board, int x, int y, TrieNode root, ArrayList<String> ans) {    
        if(root.isWord == true)
        {
            if(!ans.contains(root.content)){
                ans.add(root.content);
            }
        }
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y]==0 || root == null)
            return;
        if(root.children.containsKey(board[x][y])){
            for(int i = 0; i < 4; i++){
                char tp = board[x][y];
                board[x][y] = 0;
                search(board, x+dx[i], y+dy[i], root.children.get(tp), ans);
                board[x][y] = tp;
            }
        }
        
    }
    
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> ans = new ArrayList<String>();        
        TrieTree tree = new TrieTree();
        for(String word : words){
            tree.insert(word);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
            	//kinda like DFS
                search(board, i, j, tree.root, ans);
            }
        }
        return ans;       
    }
}
