package ds.problems.string;
//https://leetcode.com/problems/to-lower-case/
//709. To Lower Case

public class _709ToLowerCase {
    public static void main(String[] args) {
        _709ToLowerCase lowerCase = new _709ToLowerCase();
        String str = "Hello";
        System.out.println(lowerCase.toLowerCase(str));
    }
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if(chars[i]>= 65 && chars[i]<=90 ) chars[i] = (char) (chars[i] + 32);
        }
        return new String(chars);
    }
}
