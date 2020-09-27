package ds.problems.bits;
//https://leetcode.com/problems/binary-gap/
//868. Binary Gap

public class _869BinaryGap {
    public int binaryGap(int N) {
        int count = 0;
        int distance = 0;

        while (N > 0) {
            int remainder = N % 2;

            if (remainder == 1) {
                if (count != 0) {
                    if (distance < count) {
                        distance = count;
                    }
                    count = 0;
                    N *= 2;
                } else {
                    count++;
                }
            }
            if (remainder == 0) {
                if (count != 0) {
                    count++;
                }
            }
            N /= 2;
        }
        return distance;
    }
}
