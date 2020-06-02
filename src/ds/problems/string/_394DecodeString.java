package ds.problems.string;
//https://leetcode.com/problems/decode-string/
//394. Decode String

import java.util.Stack;

public class _394DecodeString {
    public static void main(String[] args) {
        _394DecodeString decodeString = new _394DecodeString();
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }

    public String decodeStringWihBetterPerformance(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack();
        Stack<Integer> numberStack = new Stack();
        StringBuilder words = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if (c>='0' && c<='9') {
                int num = 0;
                while (chars[i]>='0' && chars[i]<='9') {
                    num = 10 * num + (chars[i] - '0');
                    i++;
                }
                i--;
                if (num != 0) {
                    numberStack.push(num);
                }
            } else if(c == '[') {
                stack.push(words.toString());
                words = new StringBuilder();
            }
            else if (c == ']') {
                StringBuilder tmp = new StringBuilder(stack.pop());
                int num = numberStack.pop();
                while (num -- > 0) {
                    tmp.append(words.toString());
                }
                words = new StringBuilder();
                words.append(tmp);
            } else {
                words.append(c);
            }
        }
        return words.toString();
    }


    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            int num = 0;
            char c = chars[i];
            if (Character.isDigit(c)) {
                while (Character.isDigit(chars[i])) {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                if (num != 0) {
                    stack.push(String.valueOf(num));
                }
            } else if (c == ']') {
                StringBuilder encodedSb = new StringBuilder(stack.pop());
                while (!stack.peek().equals("[")) {
                    encodedSb.insert(0, stack.pop());
                }
                stack.pop();
                int freq = Integer.parseInt(stack.pop());
                StringBuilder decodedSb = new StringBuilder();
                String encodedStr = encodedSb.toString();
                for (int j = 0; j < freq; j++) {
                    decodedSb.append(encodedStr);
                }
                stack.push(decodedSb.toString());
            } else {
                stack.push(Character.toString(c));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();
    }
    /*
    public String decodeString(String s) {

        Stack<String> stack = new Stack<String>();
        Stack<Integer> numStack = new Stack<Integer>();
        StringBuilder words = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(Character.isDigit(s.charAt(i))){
                    num = num * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                numStack.push(num);
            }
            else if(s.charAt(i) == '['){
                stack.push(words.toString());
                words = new StringBuilder();
                i++;
            }else if(s.charAt(i) == ']'){
                StringBuilder temp = new StringBuilder(stack.pop());
                int num = numStack.pop();

                while(num > 0){
                    temp.append(words.toString());
                    num--;
                }
                words = new StringBuilder();
                words.append(temp.toString());
                i++;
            }else{
                words.append(s.charAt(i));
                i++;
            }
        }

        return words.toString();
    }
     */
}
