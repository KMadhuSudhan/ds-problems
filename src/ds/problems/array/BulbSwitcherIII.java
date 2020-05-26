package ds.problems.array;
//https://leetcode.com/problems/bulb-switcher-iii/
//1375. Bulb Switcher III

public class BulbSwitcherIII {
    public static void main(String[] args) {
        BulbSwitcherIII bulbSwitcherIII = new BulbSwitcherIII();
        int[] lights = {2,1,3,5,4};
        bulbSwitcherIII.numTimesAllBlue(lights);
    }
    public int numTimesAllBlue(int[] light) {
        int count =0,length=light.length;
        int max = Integer.MIN_VALUE;
        int on =0;
        for (int i=0;i<length;i++) {
            max = Math.max(max, light[i]);
            on++;
            if(on==max) count++;
        }
        return count;
    }
}
