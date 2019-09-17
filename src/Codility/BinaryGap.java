package Codility;

public class BinaryGap {

    public static int solution(int N) {
        // write your code in Java SE 8
        String binary = Integer.toBinaryString(N);
        String[] parts = binary.split("1");
        if (binary.charAt(binary.length() - 1) == '0') {
            parts[parts.length - 1] = "";
        }
        int count = 0;
        for (String part : parts) {
            int length = part.length();
            if (length > count) {
                count = length;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = solution(32);
        System.out.println(a);
    }
}
