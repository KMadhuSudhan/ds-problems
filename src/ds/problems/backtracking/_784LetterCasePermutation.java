package ds.problems.backtracking;
//https://leetcode.com/problems/letter-case-permutation/
//784. Letter Case Permutation

import java.util.ArrayList;
import java.util.List;

public class _784LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<String>();
        permute(s, s.length(), result, 0, "");
        return result;
    }

    private void permute(String input, int length, List<String> result, int startIndex, String prefix){

        if(prefix.length() == length ){
            result.add(prefix);
            return;
        }

        char c = input.charAt(startIndex);
        boolean isLetter = Character.isLetter(c);

        if(isLetter){
            permute(input, length, result, startIndex+1,prefix + Character.toLowerCase(c));
            permute(input, length, result, startIndex+1,prefix + Character.toUpperCase(c));
        }else{
            permute(input, length, result, startIndex+1,prefix + c);
        }
    }
}
