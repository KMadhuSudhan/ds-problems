package ds.problems.strings;
//https://leetcode.com/problems/number-of-segments-in-a-string/
//434. Number of Segments in a String

public class __434NumberOfSegmentsInAString {

    public int countSegments(String s) {
        String t = s.trim();
        if(t.isEmpty()) return 0;
        while(t.indexOf("  ")>=0){
            t =t.replaceAll("  "," ");
        }
        return t.split(" ").length;
    }
}
