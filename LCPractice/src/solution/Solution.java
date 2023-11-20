package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
//        char[] sArray = s.toCharArray();
//        char[] tArray = t.toCharArray();
//        Arrays.sort(sArray);
//        Arrays.sort(tArray);
//        return Arrays.equals(sArray,tArray);
//    }
        HashMap<Character, Integer> count = new HashMap<>();
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        for (int val : count.values()) {
            if (val != 0)
                return false;
        }
        return true;
    }
}