package ds.problems.string;
//https://leetcode.com/contest/weekly-contest-190/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
//5417. Maximum Number of Vowels in a Substring of Given Length

public class _5417MaximumNumberofVowelsinaSubstringofGivenLength {
    public static void main(String[] args) {
        _5417MaximumNumberofVowelsinaSubstringofGivenLength maximumNumberofVowelsinaSubstringofGivenLength = new _5417MaximumNumberofVowelsinaSubstringofGivenLength();
        System.out.println(maximumNumberofVowelsinaSubstringofGivenLength.maxVowels("aeiou",2));
    }
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int i=0,count =0,maxCount =0;
        while (i<chars.length && i<k) {
            if(isVowel(chars[i])) {
                count++;
            }
            i++;
        }
        if(count>=k) return count;
        maxCount = count;
        int j=0;
        while (i<chars.length) {
            if(isVowel(chars[j])) {
                count--;
            }
            if(isVowel(chars[i])) {
                count++;
            }
            maxCount = Math.max(maxCount,count);
            if(maxCount == k) return maxCount;
            i++;
            j++;
        }
        return maxCount;
    }

    boolean isVowel(char vowel) {
        switch (vowel) {
            case 'a':
                return true;
            case 'e':
                return true;
            case 'i':
                return true;
            case 'o':
                return true;
            case 'u':
                return true;
        }
        return false;
    }

}
