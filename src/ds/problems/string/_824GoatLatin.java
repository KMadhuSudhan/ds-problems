package ds.problems.string;
//https://leetcode.com/problems/goat-latin/
//824. Goat Latin

public class _824GoatLatin {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        for(int i=0;i<words.length;i++) {
            char firstLetter = words[i].charAt(0);
            StringBuilder sb = new StringBuilder();
            if(isVowel(firstLetter)) {
                sb.append(words[i]);
            } else {
                sb.append(words[i].substring(1,words[i].length()));
                sb.append(firstLetter);
            }
            sb.append("ma");
            appendAs(sb,i);
            words[i] = sb.toString();
        }
        return String.join(" ", words);
    }

    void appendAs(StringBuilder sb,int count) {
        while(count>=0) {
            sb.append('a');
            count --;
        }
    }

    boolean isVowel(char character) {
        switch (character) {
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
            case 'A':
                return true;
            case 'E':
                return true;
            case 'I':
                return true;
            case 'O':
                return true;
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
