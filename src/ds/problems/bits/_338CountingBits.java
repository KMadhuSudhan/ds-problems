package ds.problems.bits;

public class _338CountingBits {

    public int[] countBits(int num) {
        int[] out = new int[num+1];
        for(int i = 1; i <= num; i++) {
            if(i % 2 == 0) {
                out[i] = out[i/2];
            } else {
                out[i] = out[i-1] + 1;
            }
        }
        return out;
    }
}
