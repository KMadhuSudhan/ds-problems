package ds.problems.string;
//https://leetcode.com/problems/long-pressed-name/
//925. Long Pressed Name

public class _925LongPressedName {
    public static void main(String[] args) {
        _925LongPressedName longPressedName = new _925LongPressedName();
        System.out.println(longPressedName.isLongPressedName("leelee","lleeelee"));
    }
    public boolean isLongPressedName(String name, String typed) {
        int n=name.length(), m = typed.length(), i=0, j=0;
        while(i<n && j<m){
            // same character, move both i and j
            if(name.charAt(i)==typed.charAt(j)){
                i++;j++;
            }
            // different one, check if j keep move along same character
            else if(j>0&&typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }
            // if meet a different character in j but not in i
            else return false;
        }
        // keep move j until end
        while(j<m && typed.charAt(j)==typed.charAt(j-1)) j++;
        return i==n && j==m;
    }
}
