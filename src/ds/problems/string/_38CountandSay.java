package ds.problems.string;
//https://leetcode.com/problems/count-and-say/
//38. Count and Say

public class _38CountandSay {
    public static void main(String[] args) {
        _38CountandSay countandSay = new _38CountandSay();
        countandSay.countAndSay(4);
    }
    public String countAndSay(int n) {
        char[] str = {'1'};
        StringBuilder newStr = new StringBuilder();
        int count =1;
        while(count<n) {
            int i=0;
            while(i < str.length) {
                char currentChar = str[i];
                int j=i;
                while(i<str.length && currentChar == str[i]) {
                    i++;
                }
                newStr.append(i-j);
                newStr.append(currentChar);
            }
            str = newStr.toString().toCharArray();
            newStr = new StringBuilder();
            count++;
        }
        return new String(str);
    }
}
