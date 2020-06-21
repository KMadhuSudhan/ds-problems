package ds.problems.string;
//https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
//1309. Decrypt String from Alphabet to Integer Mapping

public class _1309DecryptStringfromAlphabettoIntegerMapping {
    public static void main(String[] args) {
        _1309DecryptStringfromAlphabettoIntegerMapping decryptStringfromAlphabettoIntegerMapping = new _1309DecryptStringfromAlphabettoIntegerMapping();
        System.out.println(decryptStringfromAlphabettoIntegerMapping.freqAlphabets("10#11#12"));
    }
    public String freqAlphabets(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<chars.length) {
            if(i+ 2 < chars.length && chars[i+2] == '#') {
                int num = (chars[i] - '0')*10 + (chars[i+1] -'0')  - 1;
                char alphabet = (char) ('a' + num);
                sb.append(alphabet);
                i=i+3;
            } else {
                sb.append((char) (chars[i] - '0' + 'a'  -1));
                i++;
            }
        }
        return sb.toString();
    }
}
