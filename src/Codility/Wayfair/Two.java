package Codility.Wayfair;

public class Two {

    // Drawing horizontal lines through landscape of heights depicted by array
    public int solution(int[] a) {
        // write your code in Java SE 8
        int last = a[0];
        int count = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > last) {
                count += a[i] - last;
            }
            last = a[i];
        }
        return count;
    }

    // Calculate the max appeal of visiting two cities (with duplicate)
    // appeal = city appeal + city appeal + distance between cities
    public int solution1(int[] a) {
        // write your code in Java SE 8
        int max = a[0] * 2;
        int current, inner;
        int distance;
        for (int i = 0; i < a.length; i++) {
            current = a[i];
            for (int j = i; j < a.length; j++) {
                inner = a[j];
                distance = j - i;
                max = Math.max(max, current + inner + distance);
            }
        }
        return max;
    }
}
