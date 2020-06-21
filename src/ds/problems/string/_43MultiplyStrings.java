package ds.problems.string;
//https://leetcode.com/problems/multiply-strings/
//43. Multiply Strings

public class _43MultiplyStrings {
    public static void main(String[] args) {

    }

    public String multiply(String num1, String num2) {
        if(num2.charAt(0) == '0') return "0";
        if(num1.charAt(0) == '0') return "0";
        String tempnum1 = num1;
        String tempnum2 = num2;
        if(num1.charAt(0) == '-') {
            num1 = num1.substring(1);
        }
        if(num2.charAt(0) == '-') {
            num2 = num2.substring(1);
        }
        int[] m = new int[num1.length() + num2.length()];
        num1 = new  StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for(int i=0;i<num1.length();i++) {
            for(int j=0;j<num2.length();j++) {
                m[i+j] = m[i+j] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        String product = new String();
        for(int i=0;i<m.length;i++) {
            int digit = m[i] % 10;
            int carry = m[i]/10;
            if(i+1 < m.length) {
                m[i+1] = m[i+1] + carry;
            }
            product = digit + product;
        }
        if(product.charAt(0) == '0') {
            product = product.substring(1);
        }
        if(tempnum1.charAt(0) == '-' && tempnum2.charAt(0)!='-' || tempnum1.charAt(0) != '-' && tempnum2.charAt(0) == '-')
        {
            product = new StringBuffer(product).insert(0,'-').toString();
        }
        return product;
    }

}
