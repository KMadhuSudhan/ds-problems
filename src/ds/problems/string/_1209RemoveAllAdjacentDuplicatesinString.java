package ds.problems.string;

import java.util.Stack;

public class _1209RemoveAllAdjacentDuplicatesinString {

    public String removeDuplicatesWith5Pecent(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean removedChars = true;
        int i=0;
        while(removedChars) {
            removedChars = false;
            sb = new StringBuilder();
            while(i < chars.length) {
                int size = 0;
                char currentChar = chars[i];
                while(i <chars.length && chars[i] == currentChar && size <k) {
                    i++;
                    size++;
                }
                if(size>=k) {
                    removedChars = true;
                } else {
                    sb.append(chars[i-size]);
                    i = i - size;
                    i++;
                }
            }
            chars = sb.toString().toCharArray();
            i=0;
        }
        return sb.toString();
    }

    public String removeDuplicatesWith5PecentWithStack(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackCnt = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(stack.empty()){
                stack.push(s.charAt(i));
                cnt = 1;
            }else if(stack.peek() == s.charAt(i)){
                cnt++;
                stack.push(s.charAt(i));
                if(cnt == k){
                    while(cnt != 0){
                        stack.pop();
                        cnt--;
                    }
                    if(!stackCnt.empty()){
                        cnt = stackCnt.peek();
                        stackCnt.pop();
                    }
                }

            }else{
                stack.push(s.charAt(i));
                stackCnt.push(cnt);
                cnt = 1;
            }

        }
        String res="";
        while(!stack.empty()){
            res = String.valueOf(stack.peek()) + res;
            stack.pop();
        }
        return res;
    }
}
