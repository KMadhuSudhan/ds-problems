package ds.problems.string;
//https://leetcode.com/problems/add-strings/
//415. Add Strings

public class _415AddStrings {
    public static void main(String[] args) {
        _415AddStrings addStrings = new _415AddStrings();
        addStrings.addStrings("0","0");
    }
    public String addStrings(String num1, String num2) {
        char[] num1Chars = num1.toCharArray(),num2Chars = num2.toCharArray();
        int i = num1Chars.length -1,j = num2Chars.length -1,carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0) {
            int a = i>=0 ?  num1Chars[i--] - '0' : 0;
            int b = j>=0 ? num2Chars[j--] - '0' : 0;
            int sum = carry +  a + b;
            sb.insert(0,sum%10);
            carry = sum  > 9 ? 1 : 0;
        }
        if(carry > 0) {
            sb.insert(0,carry);
        }
        return sb.toString();
    }
}
