package ds.problems.bits;

public class CountSetBits {
    public static void main(String[] args) {
        CountSetBits countSetBits = new CountSetBits();
        System.out.println(countSetBits.countSetBits(15));
    }
    int countSetBits(int i) {
        int ctr = 0;
        while(i != 0) {
            ctr += i & 1;
            i = i >> 1;
        }
        return ctr;
    }
}
