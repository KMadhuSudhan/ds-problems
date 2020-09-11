package ds.problems.string;

public class _1556ThousandSeparator {
    public String thousandSeparator(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.insert(0,chars[chars.length-1]);
        for(int i=chars.length-2;i>=0;i--) {
            if(count%3 == 0) {
                sb.insert(0,'.');
            }
            sb.insert(0,chars[i]);
            count++;
        }
        return sb.toString();
    }
}
