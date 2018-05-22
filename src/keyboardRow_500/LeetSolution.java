package keyboardRow_500;

import java.util.*;

public class LeetSolution {
	private static String rowOne = "qwertyuiopQWERTYUIOP";
    private static String rowTwo = "asdfghjklASDFGHJKL";
    private static String rowThree = "zxcvbnmZXCVBNM";

    public String[] findWords(String[] words) {
        List<String> wordList = new ArrayList<String>();
        for(String word : words){
           if(canInput(word)){
               wordList.add(word);
           }
        }

        String[] results = new String[wordList.size()];
        return wordList.toArray(results);
    }

    private boolean canInput(String word){

        char c = word.charAt(0);
        String checkRow = rowThree;
        if(rowOne.indexOf(c) >= 0){
            checkRow = rowOne;
        }else if(rowTwo.indexOf(c) >= 0){
            checkRow = rowTwo;
        }

        for(int i = 1; i < word.length(); i++){
            char ch = word.charAt(i);
            if(checkRow.indexOf(ch) < 0){
                return false;
            }
        }

        return true;
    }
}
