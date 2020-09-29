package Codility.Honey.Bug;

import java.util.*;

class Solution {
    public String[] solution(int N, int K) {
        if (N == 0 || K == 0) {
            return new String[] {""};
        }
        ArrayList<String> result = new ArrayList<String>();
        for (String p : solution(N - 1, K)) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] x = solution.solution(10, 6);
        for (String y : x) {
            System.out.print(y + "\t");
        }
    }
}