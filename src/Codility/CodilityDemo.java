package Codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CodilityDemo {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        //Set<Integer> targetSet = new HashSet<Integer>(Arrays.asList(A));
        if (A[0] <= 0) {
            return 1;
        }
        int a = 1;
        for (int i = 1; i <= A.length; i++) {
            if (i > A[i - 1]) {
                a = i;
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};
        int s = solution(A);
        System.out.println(s);
    }
}
