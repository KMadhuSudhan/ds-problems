package ds.problems.string;
//https://leetcode.com/problems/delete-columns-to-make-sorted/
//944. Delete Columns to Make Sorted

public class _944DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        int count = 0;

        for (int col=0;col<A[0].length();col++) {
            char prev = 'A';

            for (int row=0;row<A.length;row++) {
                char curChar = A[row].charAt(col);

                if (curChar < prev) {
                    count++;
                    break;
                }

                prev = curChar;
            }
        }

        return count;
    }
}
