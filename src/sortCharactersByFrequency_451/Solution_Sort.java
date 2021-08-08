package sortCharactersByFrequency_451;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_Sort {
  public String frequencySort(String s) {
    if (s.isEmpty()) {
      return "";
    }

    Map<Character, Integer> frequencyForNum = new HashMap<>();
    for (char c : s.toCharArray())
      frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);

    Character[] charArr = new Character[frequencyForNum.size()];
    int i = 0;
    for (char c : frequencyForNum.keySet()) {
      charArr[i++] = c;
    }
    Arrays.sort(charArr, (a, b) -> {
      return frequencyForNum.get(b) - frequencyForNum.get(a);
    });

    String str = "";
    for (Character c : charArr) {
      int f = frequencyForNum.get(c);
      for (int j = 0; j < f; j++) {
        str += c.toString();
      }
    }

    return str;
  }
}
