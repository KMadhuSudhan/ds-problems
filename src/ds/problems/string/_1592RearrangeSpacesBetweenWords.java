package ds.problems.string;
//https://leetcode.com/problems/rearrange-spaces-between-words/
//1592. Rearrange Spaces Between Words

public class _1592RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        int wordCount = 0;
        char[] newStr = new char[text.length()];
        String[] words = text.split(" ");
        char[] chars = text.toCharArray();

        for(int i=0;i<chars.length;i++) {
            if(chars[i] == ' ') spaceCount++;
        }
        if(spaceCount == 0) return text;

        for(String word: words) {
            if(!word.trim().isEmpty()) {
                wordCount++;
            }
        }
        if(wordCount == 0) return text.trim();
        int space = wordCount <= 1 ? spaceCount: spaceCount/(wordCount - 1); // space between word
        int extraSpace = wordCount <= 1 ? 0 : spaceCount%(wordCount - 1); // trailing space
        int k=0;
        for(String word: words){
            if(!word.trim().isEmpty()){

                // add words
                for(int i=0; i < word.trim().length(); i++){
                    newStr[k++] = word.trim().charAt(i);
                }

                // add spaces
                for(int i=0;k < text.length() &&  i < space; i++){
                    newStr[k++] = ' ';
                }
            }
        }

        // add trailing spaces
        for(int i=0;k < text.length() &&  i < extraSpace; i++){
            newStr[k++] = ' ';
        }

        return new String(newStr);
    }
}
