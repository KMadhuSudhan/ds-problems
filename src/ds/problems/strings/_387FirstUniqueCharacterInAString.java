package ds.problems.strings;
//https://leetcode.com/problems/first-unique-character-in-a-string/
//387. First Unique Character in a String

public class _387FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String str = "leetcode";
        _387FirstUniqueCharacterInAString firstUniqueCharacterInAString = new _387FirstUniqueCharacterInAString();
        firstUniqueCharacterInAString.firstUniqChar(str);
    }
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] charArray = s.toCharArray();
        for(int i=0;i<charArray.length;i++) {
            count[charArray[i] - 'a']++;
        }
        for(int i=0;i<charArray.length;i++) {
            if(count[charArray[i] - 'a'] ==1) {
                return i;
            }
        }
        return -1;
    }
}
