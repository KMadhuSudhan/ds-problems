package ds.problems.array;
//https://leetcode.com/problems/roman-to-integer
//13. Roman to Integer
public class _13RomantoInteger {

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int no=0,i=0;
        while(i<chars.length) {
            char current = chars[i];
            if( i+1 < chars.length && current == 'I' && (chars[i+1] == 'V' || chars[i+1] == 'X')) {
                no+= fromChar(chars[i+1]) - fromChar(current);
                i++;
            } else if(i+1 < chars.length && current == 'X' && (chars[i+1] == 'L' || chars[i+1] == 'C')) {
                no+= fromChar(chars[i+1]) - fromChar(current);
                i++;
            } else if(i+1 < chars.length && current == 'C' && (chars[i+1] == 'D' || chars[i+1] == 'M')) {
                no+= fromChar(chars[i+1]) - fromChar(current);
                i++;
            } else {
                no+= fromChar(chars[i]);
            }
            i++;
        }
        return no;
    }

    int fromChar(char character) {
        switch(character) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return -1;
    }
}
