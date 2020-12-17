package ds.problems.test;

public class ReverseString {
    static StringBuilder sb;
    public static void main(String[] args) {
        String s = "I Love India";
        sb = new StringBuilder();
        ReverseString reverseString = new ReverseString();
        reverseString.reverse(s.toCharArray(),0);
        System.out.print(sb.toString());
    }
    public void reverse(char[] chars,int index) {
        if(index >= chars.length) return;
        reverse(chars,index+1);
        sb.append(chars[index]);
        //System.out.println(chars[index]);
    }
}
