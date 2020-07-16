package ds.problems.test;

public class NumberStream {
    public static String NumberStream(String str) {
        // code goes here
        char[] chars = str.toCharArray();
        int i=0;
        while(i<chars.length) {
            int num = chars[i] - '0';
            int count = 0;
            while(i<chars.length && ((chars[i] - '0') == num)) {
                count++;
                i++;
            }
            if(count == num) return "true";

        }
        return "false";
    }

    public static void main (String[] args) {
        System.out.println((int) Math.sqrt(4));
        System.out.print(NumberStream("5788888888882339999"));
    }
}
