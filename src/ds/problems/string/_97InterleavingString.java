package ds.problems.string;
//https://leetcode.com/problems/interleaving-string/
//97. Interleaving String

public class _97InterleavingString {
    public static void main(String[] args) {
        _97InterleavingString interleavingString = new _97InterleavingString();
        interleavingString.isInterleave("aabcc","dbbca","aadbbcbcac");
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        if(sb.toString().equals(s3)) return true;
        for(int i=1;i<s1.length()-1;i++) {
            sb = new StringBuilder();
            sb.append(s1.substring(0,i));
            sb.append(s2);
            sb.append(s1.substring(i,s1.length()));
            if(sb.toString().equals(s3)) return true;
        }
        return false;
    }
}
