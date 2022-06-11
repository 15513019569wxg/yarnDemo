import java.util.Arrays;

public class TestArrayCopyOfRange {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        int[] ints2 = Arrays.copyOfRange(ints,1, ints.length);
        System.out.println(Arrays.toString(ints2));
    }
}
