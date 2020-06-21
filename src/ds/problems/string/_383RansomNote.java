package ds.problems.string;
//https://leetcode.com/problems/ransom-note/
//383. Ransom Note

public class _383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNoteChars = ransomNote.toCharArray();
        char[] magazineChars = magazine.toCharArray();
        if(magazineChars.length < ransomNoteChars.length) {
            return false;
        }
        int[] map = new int[26];
        for(int i=0;i<magazineChars.length;i++) {
            map[magazineChars[i] -'a']++;
        }
        for(int i=0;i<ransomNoteChars.length;i++) {
            if(map[ransomNoteChars[i] -'a']<=0) {
                return false;
            }
            else {
                map[ransomNoteChars[i] -'a']--;
            }
        }
        return true;
    }
}
