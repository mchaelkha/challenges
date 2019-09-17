package LeetCode;

import java.util.*;

public class JewelsAndStones {

    class Solution {
        public int numJewelsInStones(String J, String S) {
            Map<Character, Boolean> map = new HashMap<>();
            for (int i = 0; i < J.length(); i++) {
                map.put(J.charAt(i), true);
            }
            int count = 0;
            for (int i = 0; i < S.length(); i++) {
                if (map.containsKey(S.charAt(i)))
                    count++;
            }
            return count;
        }
    }
}
