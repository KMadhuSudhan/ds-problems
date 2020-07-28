package ds.problems.string;
//https://leetcode.com/problems/bulls-and-cows/
//299. Bulls and Cows

public class _299BullsandCows {

    public String getHint(String secret, String guess) {
        char[] secretChars = secret.toCharArray();
        char[] guessChar = guess.toCharArray();
        int[] map = new int[10];
        int correct = 0,wrong = 0;
        for(int i=0;i<secretChars.length;i++) {
            if(secretChars[i] == guessChar[i]) {
                correct++;
            } else {
                map[secretChars[i] - '0']++;
            }
        }

        for(int i=0;i<guessChar.length;i++) {
            if(map[guessChar[i] - '0'] > 0 && secretChars[i] != guessChar[i]) {
                wrong++;
                map[guessChar[i] - '0']--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(correct);
        sb.append("A");
        sb.append(wrong);
        sb.append("B");
        return sb.toString();
    }
}
