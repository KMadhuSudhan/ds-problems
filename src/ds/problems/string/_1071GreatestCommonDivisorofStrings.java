package ds.problems.string;
//https://leetcode.com/problems/greatest-common-divisor-of-strings/
//1071. Greatest Common Divisor of Strings

public class _1071GreatestCommonDivisorofStrings {

    public String gcdOfStrings(String str1, String str2) {
        int gcd = gcd(str1.length(),str2.length());
        String temp = str2.substring(0,gcd);
        for(int i=0;i<str1.length();i+=gcd) {
            if(!str1.substring(i).startsWith(temp)) {
                return "";
            }
        }
        return temp;
    }

    int gcd(int a,int b) {
        if(a%b == 0) {
            return b;
        }
        return  gcd(b,a%b);
    }
}
