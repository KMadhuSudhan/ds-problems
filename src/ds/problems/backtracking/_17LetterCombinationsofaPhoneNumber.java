package ds.problems.backtracking;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//17. Letter Combinations of a Phone Number

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<>();
        map.put('1', new char[]{});
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        char[] chars = digits.toCharArray();
        List<String> result = new ArrayList<>();
        if(chars.length!=0) {
            helper(map, chars, 0, result, new StringBuilder());
        }
        return result;
    }

    public void helper(Map<Character, char[]> map, char[] chars, int pos, List<String> result, StringBuilder sb) {
        if (sb.length() == chars.length) {
            result.add(sb.toString());
        } else {
            for (char chr : map.get(chars[pos])) {
                sb.append(chr);
                helper(map, chars, pos + 1, result, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
