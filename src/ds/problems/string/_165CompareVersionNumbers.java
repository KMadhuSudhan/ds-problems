package ds.problems.string;
//https://leetcode.com/problems/compare-version-numbers/
//165. Compare Version Numbers

public class _165CompareVersionNumbers {
    public static void main(String[] args) {
        _165CompareVersionNumbers compareVersionNumbers = new _165CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion("0.1","1.1"));
    }
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int i=0,j=0;
        while(i < ver1.length || j< ver2.length) {
            int v1 = i < ver1.length ? Integer.valueOf(ver1[i]) : 0;
            int v2 = j < ver2.length ? Integer.valueOf(ver2[j]) : 0;
            i++;
            j++;
            if(v1 == v2) continue;
            if(v1>v2) return 1;
            if(v1<v2) return -1;
        }
        return 0;
    }

}
