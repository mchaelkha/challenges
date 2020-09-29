package Codility.Wayfair.NoRepeatingChar;

class Solution {

    // Since we are building incrementally, only check if first and last char are same
    public boolean checkRepeat(String sub) {
        return sub.charAt(0) == sub.charAt(sub.length() - 1);
    }

    // Helper for quickly creating the substring we are appending; index safe
    public String createAddend(String sub) {
        return sub.length() >= 2 ? sub.substring(0, 2) : sub;
    }

    // Should be O(N) time with this solution; we traverse the string one time
    // Should be O(1) space as we are only keeping tabs on the "window" string
    public String solution(String s) {
        // Sliding window through string S of size greater than 2

        // String to keep track of same char instances
        String sub = "";

        // The resulting expected string we are building
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            sub += c;
            // If window contains a new char and length is two, keep the first char
            if (!checkRepeat(sub) && sub.length() == 2) {
                result.append(sub.substring(0, 1));
                // Do not forget current char
                sub = "" + c;
            }
            // If window contains a new char, keep the first two chars
            else if (!checkRepeat(sub)) {
                result.append(createAddend(sub));
                // Do not forget current char
                sub = "" + c;
            }
        }
        // Add remaining chars from sub
        result.append(createAddend(sub));
        return result.toString();
    }
}