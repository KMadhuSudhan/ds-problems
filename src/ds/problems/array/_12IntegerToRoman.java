package ds.problems.array;
//https://leetcode.com/problems/integer-to-roman/
//12. Integer to Roman

public class _12IntegerToRoman {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++)
        {
            while(num>= values[i] && num>0)
            {
                num=num-values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
