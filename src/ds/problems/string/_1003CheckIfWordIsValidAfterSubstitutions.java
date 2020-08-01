package ds.problems.string;
//https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/
//1003. Check If Word Is Valid After Substitutions

public class _1003CheckIfWordIsValidAfterSubstitutions {

    public boolean isValid(String S) {
        char[] chars = S.toCharArray();
        char[] stack = new char[chars.length];
        int top = -1;
        for(int i=0;i<chars.length;i++) {
            if(chars[i]!='c') {
                stack[++top] = chars[i];
            } else {
                if(top!=-1 && stack[top] == 'b') {
                    top--;
                    if( top!=-1 && stack[top] == 'a') {
                        top--;
                    }
                } else {
                    return false;
                }
            }
        }
        return top == -1;
    }
}
