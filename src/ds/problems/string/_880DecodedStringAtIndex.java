package ds.problems.string;
//https://leetcode.com/problems/decoded-string-at-index/
//880. Decoded String at Index

public class _880DecodedStringAtIndex {
    public static void main(String[] args) {
        _880DecodedStringAtIndex decodedStringAtIndex = new _880DecodedStringAtIndex();
        System.out.print(decodedStringAtIndex.decodeAtIndex("ha22", 10));
    }

    public String decodeAtIndex(String S, int K) {
        char[] chs = S.toCharArray();

        long count = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= '2' && chs[i] <= '9') {
                long digit = chs[i]-'0';

                if (count * digit >= K) {
                    return decodeAtIndex(S, (int) ((K % count + count-1) % count + 1));
                } else {
                    count = count * digit;
                }
            } else {
                count++;
                if (count == K) {
                    return Character.toString(chs[i]);
                }
            }
        }

        return "";
    }
}
