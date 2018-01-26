package ShortestWordDistance_243;

// generalized solution is to use a hashmap
// but now we only have to query a fixed pair of words
// indeed, all the better solutions make use of the fact that we only have two words.
public class Solution {
	int shortestDistance(String[] words, String word1, String word2) {
        // dont have to keep track of all indices.
		int p1 = -1, p2 = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == word1) p1 = i;
            else if (words[i] == word2) p2 = i;
            if (p1 != -1 && p2 != -1) res = Math.min(res, Math.abs(p1 - p2));
        }
        return res;
    }
}
