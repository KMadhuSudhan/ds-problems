package ds.problems.bits;
//https://leetcode.com/problems/add-binary/
//67. Add Binary

public class _67AddBinary {
    public static void main(String[] args) {
        _67AddBinary addBinary = new _67AddBinary();
        System.out.println(addBinary.addBinary("11","1"));
    }
    public String addBinary(String a, String b) {
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        int i= achars.length -1 ,j= bchars.length -1,carry=0;
        StringBuilder sb = new StringBuilder();
        while (i>=0 || j>=0 ) {
            char bit1 = i>=0 ? achars[i]: '0';
            char bit2 = j>=0 ? bchars[j] : '0';
            if(carry == 1 && (bit1 == '1' && bit2 == '1')) {
                sb.insert(0,'1');
                carry = 1;
            }
            else if(carry == 0 && bit1 == '1' && bit2 == '1') {
                sb.insert(0,'0');
                carry = 1;
            } else if(carry == 1 && (bit1 == '1' || bit2 == '1')) {
                sb.insert(0, '0');
                carry = 1;
            } else if(carry == 0 && (bit1 == '1' || bit2 == '1')) {
                sb.insert(0, '1');
                carry = 0;
            } else if(carry == 1 && bit1 == '0' && bit2 == '0') {
                sb.insert(0,'1');
                carry = 0;
            } else {
                sb.insert(0,'0');
                carry = 0;
            }
            i--;
            j--;
        }
        if(carry == 1) {
            sb.insert(0,'1');
        }
        return sb.toString();
    }
}
