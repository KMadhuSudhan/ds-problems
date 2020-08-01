package ds.problems.string;
//https://leetcode.com/problems/minimum-number-of-frogs-croaking/
//1419. Minimum Number of Frogs Croaking

public class _1419MinimumNumberOfFrogsCroaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int frogs = 0;
        int[] count = new int[5];
        int newCroak = 0;
        char[] chars = croakOfFrogs.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            char c = chars[i];
            switch (c) {
                case 'c':
                    count[0]++;
                    newCroak++; // sound started
                    break;
                case 'r':
                    count[1]++;
                    break;
                case 'o':
                    count[2]++;
                    break;
                case 'a':
                    count[3]++;
                    break;
                case 'k':
                    count[4]++;
                    newCroak--; // sound ended
                    break;
                default:
                    return -1;
            }

            for (int j = 0; j < count.length - 1; j++) {
                if (count[j] < count[j + 1]) {
                    return -1;
                }
            }

            frogs = Math.max(frogs, newCroak);
        }
        return newCroak == 0 ? frogs : -1;
    }
}
