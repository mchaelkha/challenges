package Codility.Honey.StringConcat;

import java.util.*;

class Solution {

    // Check that no characters repeat in a given word
    public boolean checkUniqueChar(String word) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            // Return early if a unique character is no longer unique
            if (charCount.containsKey(c)) {
                return false;
            }
            // Track unique characters
            charCount.put(c, 1);
        }
        // Returning here means all characters have been checked and are unique
        return true;
    }

    // For all words check that the characters are unique and return the longest found length
    public int checkUnique(List<String> words) {
        int result = 0;
        for (String word : words) {
            if (checkUniqueChar(word)) { // If the characters are unique
                int strLen = word.length();
                // If the length is better than the current, update the result
                if (result < strLen) result = strLen;
            }
        }
        // Returns either 0 or the actual length found
        return result;
    }

    // Naive solution is create every word and then check them while doing a running longest length
    // Up to 8 strings in the array
    public int solution(String[] a) {
        // Length of the array for bounds checking
        int size = a.length;
        // If only 1 string, there will not exist a concatenation
        if (size == 1) {
            return 0;
        }
        // Use a list since we do not how many words we are making
        List<String> allWords = new ArrayList<>();
        // The current string we are using
        String current = ""; // For efficiency should use StringBuilder; but we care about correctness
        // Build all unique letter combinations
        for (int m = 0; m < size; m++) {
            current += a[m]; // Start of the word
            for (int n = 0; n < size; n++) {
                if (m == n) continue;
                current += a[n]; // Collectively add to the current word on each iteration
                allWords.add(current);
            }
            current = "";
        }
        return checkUnique(allWords); // Let's find the resulting length and return it
    }
}