package ds.problems.string;
//https://leetcode.com/problems/long-pressed-name/
//925. Long Pressed Name

public class _925LongPressedName {
    public static void main(String[] args) {
        _925LongPressedName longPressedName = new _925LongPressedName();
        System.out.println(longPressedName.isLongPressedName("alex","alexxr"));
    }
    public boolean isLongPressedName(String name, String typed) {
        char[] nameChars = name.toCharArray();
        char[] typedChars = typed.toCharArray();
        int i=0,j=0;
        while (i < nameChars.length && j < typedChars.length) {
            if(nameChars[i]!= typedChars[j]) return false;
            while(i< nameChars.length && j < typedChars.length && nameChars[i] == typedChars[j]) {
                i++;
                j++;
            }
            while (i > 0 && i< nameChars.length && j < typedChars.length  && nameChars[i-1] == typedChars[j]) {
                j++;
            }
        }
        if(nameChars[nameChars.length-1] == typedChars[typedChars.length-1] || typedChars[typedChars.length-1] == nameChars[nameChars.length-2]){
            return true;
        } else {
            return false;
        }
    }
}
