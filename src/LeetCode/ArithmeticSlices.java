package LeetCode;

public class ArithmeticSlices {

    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int sum = 0;
            int j = 1;
            int back = A.length - 1;
            for (int i = 1; i < back; i++) {
                if (A[i] - A[i-1] == A[i+1] - A[i]) {
                    sum += j++;
                } else {
                    j = 1;
                }

            }
            return sum;
        }
    }
}
