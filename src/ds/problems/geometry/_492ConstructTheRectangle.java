package ds.problems.geometry;
//https://leetcode.com/problems/construct-the-rectangle/
//492. Construct the Rectangle

public class _492ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int [] res = new int[2];
        for(int i = (int)Math.sqrt(area); i >= 1; --i) {
            if(area % i == 0) {
                res[0] = area / i;
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
