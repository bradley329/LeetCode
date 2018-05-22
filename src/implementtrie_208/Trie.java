package implementtrie_208;

class TrieNode {
    // Initialize your data structure here.
	public char content;
	public boolean isEnd;
	int count; // indicates how many words has this character as their prefix;
	public TrieNode[] childArr = new TrieNode[26];
	
    public TrieNode(char c) {
    	content = c;
    	childArr = new TrieNode[26];
        isEnd = false;        
        count = 0;
    }
    
    public TrieNode getChild(char c){
    	if(childArr[c-'a']!=null) return childArr[c-'a'];
    	else return null;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	// if not using search, then same multiple words could be inserted;
    	// which will lead to an count-based isEnd predication. 
        if(search(word)) return;
        
        TrieNode cur = root;
        for(char c : word.toCharArray()){
        	TrieNode child = cur.getChild(c);
        	if(child!=null){
        		cur = child;
        	}
        	else{
        		TrieNode newChild = new TrieNode(c);
        		cur.childArr[c-'a'] = newChild;
        		cur = newChild;
        	}
        	cur.count++;
        }
        cur.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
        	TrieNode child = cur.getChild(c);
        	if(child==null) return false;
        	else cur = child;
        }
        // the next line is important, that's why we need isEnd;
        return cur.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode cur = root;
        for(char c : prefix.toCharArray()){
        	TrieNode child = cur.getChild(c);
        	if(child==null) return false;
        	else cur = child;
        }
        return true;
    }
    // the follwing delete is not required by LeetCode;
    // since there is no replicated word, so isEnd = false is safe; 
    /*public void deleteWord(String word){
		if(search(word) == false) return;
	
		TrieNode cur = root;
		for(char c : word.toCharArray()) { 
			TrieNode child = cur.getChild(c);
			if(child.count == 1) {
				cur.childArr.remove(child);
				return;
			} else {
				child.count--;
				cur = child;
			}
		}
		cur.isEnd = false;
	}*/

}
