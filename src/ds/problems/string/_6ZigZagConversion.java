package ds.problems.string;
//https://leetcode.com/problems/zigzag-conversion/
//6. ZigZag Conversion


public class _6ZigZagConversion {
    public static void main(String[] args) {
        _6ZigZagConversion zigZagConversion = new _6ZigZagConversion();
        zigZagConversion.convert("PAYPALISHIRING",4);
    }

    public String convert(String s, int numRows) {
        if(numRows==1) return s;

        int l = s.length();
        StringBuilder sb = new StringBuilder();

        for(int r = 0;r<numRows;r++) { //for each row
            for(int i = r; i<l ; i= i+ 2*(numRows-1) ) { // per interval
                sb.append(s.charAt(i)); //common for all the rows
                if (r != 0 && r != numRows-1 && i+2*(numRows-1)-2*r<l) //execpt for the first and last rows.
                    sb.append(s.charAt(i+2*(numRows-1)-2*r));
            }
        }
        return sb.toString();
    }

    /*
    public String convert(String s, int numRows) {
        String[] collectors = new String[numRows];
        int c=0,subC = 0;
        char[] chars = s.toCharArray();
        while(c<chars.length) {
            int idx = Math.abs(subC);
            if(collectors[idx] == null) {
                collectors[idx] = String.valueOf(chars[c]);
            } else {
                collectors[idx] = collectors[idx] + String.valueOf(chars[c]);
            }
            c++;
            if(subC == numRows -1) {
                subC*=-1;
            }
            subC++;
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<numRows;i++) {
            ans.append(collectors[i]);
        }
        return ans.toString();
    }
    */

}
