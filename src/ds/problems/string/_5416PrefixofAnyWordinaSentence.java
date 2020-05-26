package ds.problems.string;

public class _5416PrefixofAnyWordinaSentence {
    public static void main(String[] args) {
        _5416PrefixofAnyWordinaSentence prefixofAnyWordinaSentence = new _5416PrefixofAnyWordinaSentence();
        System.out.println(prefixofAnyWordinaSentence.isPrefixOfWord("i love eating burger","burg"));
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        if(sentence.length() == 0 || searchWord.length() == 0) return -1;
        String[] sentenceChars = sentence.split(" ");
        char[] searchWordChars = searchWord.toCharArray();
        for (int i=0;i<sentenceChars.length;i++) {
            if(sentenceChars[i].length() < searchWordChars.length) {
                continue;
            }
            int j=0;
            int k=0;
            char[] chars = sentenceChars[i].toCharArray();
            while(j<searchWordChars.length &&  searchWordChars[j] == chars[k]) {
                j++;
                k++;
            }
            if(j==searchWordChars.length) return i;
        }
        return -1;
    }
}
