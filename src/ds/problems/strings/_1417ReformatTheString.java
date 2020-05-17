package ds.problems.strings;
//https://leetcode.com/problems/reformat-the-string/
//1417. Reformat The String

public class _1417ReformatTheString {
    public static void main(String[] args) {
        _1417ReformatTheString a1417ReformatTheString = new _1417ReformatTheString();
        String str = "ec";
        System.out.println(a1417ReformatTheString.reformat(str));
    }

    public String reformat(String s) {
        int[] digitsCount = new int[10], charCount = new int[26];
        char[] chars = s.toCharArray();
        if (chars.length == 1) return s;
        int digits = 0, characters = 0, length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] >= 48 && chars[i] <= 57) {
                digits++;
                digitsCount[chars[i] - '0']++;
            } else {
                characters++;
                charCount[chars[i] - 'a']++;
            }
        }
        if (digits == 0 || characters == 0) return "";
        if (digits > ((length / 2) + 1) || characters > ((length / 2) + 1)) return "";
        char[] ans = new char[length];
        if (characters > digits) {
            fillChars(ans, charCount, 0, length);
            fillDigits(ans, digitsCount, 1, length);
        } else {
            fillDigits(ans, digitsCount, 0, length);
            fillChars(ans, charCount, 1, length);
        }
        return new String(ans);
    }

    void fillDigits(char[] ans, int[] digitsCount, int start, int end) {
        for (int i = 0; i < 10; i++) {
            int repeated = digitsCount[i];
            while (repeated > 0 && start < end) {
                ans[start] = (char) (i + '0');
                repeated--;
                start += 2;
            }
            if (start >= end) break;
        }
    }

    void fillChars(char[] ans, int[] charCount, int start, int end) {
        for (int i = 0; i < 26; i++) {
            int repeated = charCount[i];
            while (repeated > 0 && start < end) {
                ans[start] = (char) (i + 'a');
                repeated--;
                start += 2;
            }
            if (start >= end) break;
        }
    }
}
