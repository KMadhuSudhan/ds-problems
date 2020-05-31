package ds.problems.string;
//https://leetcode.com/problems/string-compression/
//443. String Compression

public class _443StringCompression {
    public static void main(String[] args) {
        _443StringCompression stringCompression = new _443StringCompression();
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(stringCompression.compress(chars));
    }
    public int compress(char[] chars) {
        int i=0,index=0;
        if(chars.length == 1) return 1;
        while(i<chars.length) {
            char currentChar = chars[i];
            int j=i;
            while(i < chars.length && chars[i] == currentChar) {
                i++;
            }
            chars[index++] = currentChar;
            if(i-j == 1) continue;
            String string = Integer.toString(i-j);
            for(char character: string.toCharArray()) {
                chars[index++] = character;
            }
        }
        return index;
    }
}
