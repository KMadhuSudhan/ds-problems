package ds.problems.string;

public class _8StringToInteger {
    public static void main(String[] args) {
        _8StringToInteger stringToInteger = new _8StringToInteger();
        System.out.println(stringToInteger.myAtoi("-91283472332"));
    }

    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        while (i < chars.length && chars[i] == ' ') {
            i++;
        }
        if(i == chars.length) return 0;
        char firstChar = chars[i];
        int sing = 1;
        if(firstChar == '-'){
            sing = -1;
            i++;
        }
        if(firstChar == '+'){
            i++;
        }
        int num = 0;
        while (i < chars.length) {
            char character = chars[i];
            if (character >= '0' && character <= '9') {
                int intValue = chars[i] - '0';
                if(num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && intValue > 7)) return Integer.MAX_VALUE;
                if(num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && intValue > 8)) return Integer.MIN_VALUE;
                num = num * 10 + intValue*sing;
            } else if(num == 0) {
                return 0;
            }
            else {
                break;
            }
            i++;
        }
        return num;
    }
}
