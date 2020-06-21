package ds.problems.bits;
//https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n
//1016. Binary String With Substrings Representing 1 To N


public class _1016BinaryStringWithSubstringsRepresenting {

    public boolean queryString(String S, int N) {
        for (int i = N; i > N / 2; --i)
            if (!S.contains(Integer.toBinaryString(i))) return false;
        return true;
    }
}
