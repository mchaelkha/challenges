package Codility.Honey.NoRepeatingChar;

class Solution {

    // Helper to check if first and last char are the same
    public boolean checkRepeat(String sub) {
        return sub.charAt(0) == sub.charAt(sub.length() - 1);
    }

    // Helper for creating the substring to be appended; needs to be index safe
    public String createAddend(String sub) {
        return sub.length() >= 2 ? sub.substring(0, 2) : sub;
    }

    // Sliding window through string S of size greater than 2
    // Should be O(N) time: need to traverse the entire string
    // Should be 0(1) space: keeping track of a current string and the resulting string
    public String solution(String s) {
        // String to keep track of same char instances
        String sub = "";
        // The resulting expected string we are building
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            sub += c;
            // If window contains a new char, need to append
            if (!checkRepeat(sub)) {
                // If the length is two
                if (sub.length() == 2) {
                    result.append(sub, 0, 1);
                } else {
                    result.append(createAddend(sub));
                }
                // Reset sub with the current char
                sub = "" + c;
            }
        }
        // Add remaining chars from sub
        result.append(createAddend(sub));
        return result.toString();
    }
}
