package sortCharactersByFrequency_451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_Best {
  public String frequencySort(String s) {
    Map<Character, Integer> frequencyForNum = new HashMap<>();
    for (char c : s.toCharArray())
      frequencyForNum.put(c, frequencyForNum.getOrDefault(c, 0) + 1);

    List<List<Character>> frequencyBucket = new ArrayList<>(s.length());
    // List<Character>[] frequencyBucket = new ArrayList[s.length() + 1];
    for (int i = 0; i < s.length(); i++) {
      frequencyBucket.add(i, null);
    }

    for (char c : frequencyForNum.keySet()) {
      int f = frequencyForNum.get(c);
      if (frequencyBucket.get(f) == null) {
        frequencyBucket.set(f, new ArrayList<>());
      }
      frequencyBucket.get(f).add(c);
    }

    StringBuilder str = new StringBuilder();
    for (int i = frequencyBucket.size() - 1; i >= 0; i--) {
      if (frequencyBucket.get(i) == null) {
        continue;
      }

      for (char c : frequencyBucket.get(i)) {
        for (int j = 0; j < i; j++) {
          str.append(c);
        }
      }
    }

    return str.toString();
  }
}
