package ds.problems;
//https://leetcode.com/problems/largest-time-for-given-digits/
//949. Largest Time for Given Digits
import java.util.ArrayList;
import java.util.List;

public class _949LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        String res = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || j == k || i == k)
                        continue;
                    String HH = A[i] + "" + A[j];
                    String MM = A[k] + "" + A[6 - i - j - k];
                    String TIME = HH + ":" + MM;
                    if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(TIME) < 0)
                        res = TIME;
                }
            }
        }
        return res;
    }
    //back tracking
    String res = ""; // the final result.
    int elapsed = Integer.MIN_VALUE; // record max valid permutation elapsed time.
    public String largestTimeFromDigitsBackTrack(int[] arr) {
        backtrack(new ArrayList(), arr);
        return res;
    }

    // Calculate all permutations of arr index, store them in the list.
    private void backtrack(List<Integer> list, int[] arr) {
        if(list.size() == 4) {
            String hh = arr[list.get(0)] + "" + arr[list.get(1)];
            String mm = arr[list.get(2)] + "" + arr[list.get(3)];
            int currElapsed = Integer.valueOf(hh) * 60 + Integer.valueOf(mm);
            if(hh.compareTo("24") < 0 && mm.compareTo("60") < 0 && currElapsed >= elapsed) {
                elapsed = currElapsed;
                res = hh + ":" + mm;
            }
            return;
        }

        for(int i=0; i<4; i++) {
            if(list.contains(i)) continue;
            list.add(i);
            backtrack(list, arr);
            list.remove(list.size()-1);
        }
    }
}
