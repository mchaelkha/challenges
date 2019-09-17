public class Hex {

    public long set_encode(String st) {
        long set = 0;

        for (Character c : st.toCharArray()) {
            long x = 1;
            set = set | (x << c);
        }
        return set;
    }

    public static void main(String[] args) {
        Hex h = new Hex();
        long val = h.set_encode("hello");
        System.out.println(String.format("0x%016X", val));
    }
}
