package ds.problems.string;
//https://leetcode.com/problems/keyboard-row/
//500. Keyboard Row

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _500KeyboardRow {
    public static void main(String[] args) {
        String[] strings = new String[] {
                "Hello", "Alaska", "Dad", "Peace"
        };
        _500KeyboardRow keyboardRow = new _500KeyboardRow();
        String[] result =  keyboardRow.findWords(strings);
        for(String str: result) {
            System.out.println(str);
        }
    }
    public String[] findWords(String[] words) {
        Map<Character,Integer> map = getMap();
        List<String> list = new ArrayList();
        for(int i=0;i<words.length;i++) {
            char[] chars = words[i].toCharArray();
            int j =0;
            int prevRow = map.get(toLowerCase(chars[0]));
            j++;
            for(;j<chars.length;j++) {
                char character = toLowerCase(chars[j]);
                int currentRow = map.get(character);
                if(prevRow!=currentRow) {
                    break;
                }
            }
            if(j == chars.length) {
                list.add(words[i]);
            }
        }

        String[] ans = new String[list.size()];
        for(int i=0;i<list.size();i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    Map<Character,Integer> getMap() {
        Map<Character,Integer> map = new HashMap();
        map.put('q',1);
        map.put('w',1);
        map.put('e',1);
        map.put('r',1);
        map.put('t',1);
        map.put('y',1);
        map.put('u',1);
        map.put('i',1);
        map.put('o',1);
        map.put('p',1);

        map.put('a',2);
        map.put('s',2);
        map.put('d',2);
        map.put('f',2);
        map.put('g',2);
        map.put('h',2);
        map.put('j',2);
        map.put('k',2);
        map.put('l',2);

        map.put('z',3);
        map.put('x',3);
        map.put('c',3);
        map.put('v',3);
        map.put('b',3);
        map.put('n',3);
        map.put('m',3);
        return map;
    }

    Character toLowerCase(char character) {
        return character >= 65 && character <= 90 ? (char) (character  + 32) : character;
    }
}
