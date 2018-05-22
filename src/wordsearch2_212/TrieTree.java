package wordsearch2_212;

import java.util.HashMap;

class TrieNode {
	String content; // note has content only when isWord is true;
	boolean isWord;
	HashMap<Character, TrieNode> children; 
	public TrieNode() {
		// TODO Auto-generated constructor stub
		children = new HashMap<>();
		content = "";
		isWord = false;
	}	
}

public class TrieTree {
	TrieNode root;
	public TrieTree() {
		root = new TrieNode(); // with no content;
	}
	
	public void insert(String word) {
		TrieNode cur = root;
		for (char ch : word.toCharArray()) {
			if (!cur.children.containsKey(ch)) {
				cur.children.put(ch, new TrieNode());
			}
			cur = cur.children.get(ch);
		}
		cur.content = word;
		cur.isWord = true;
	}
	
	public boolean search(String word) {
		TrieNode cur = root;
		for (char ch : word.toCharArray()) {
			if (!cur.children.containsKey(ch)) {
				return false;
			}
			cur = cur.children.get(ch);
		}
		return cur.isWord;
	}
}
