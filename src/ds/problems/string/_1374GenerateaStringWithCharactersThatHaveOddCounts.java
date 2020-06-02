package ds.problems.string;
//https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
//1374. Generate a String With Characters That Have Odd Counts

public class _1374GenerateaStringWithCharactersThatHaveOddCounts {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if(n%2 == 0) {
            sb.append('p');
            n = n-1;
        }
        int i=0;
        while(i<n) {
            sb.append('q');
            i++;
        }
        return sb.toString();
    }
}
