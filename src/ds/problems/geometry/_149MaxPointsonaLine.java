package ds.problems.geometry;
//https://leetcode.com/problems/max-points-on-a-line/
//149. Max Points on a Line

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/max-points-on-a-line/
//149. Max Points on a Line

public class _149MaxPointsonaLine {

    public int maxPoints(int[][] points) {
        if(points.length<=2)
            return points.length;
        int maxpoints=0;
        int length = points.length-1;
        for(int i=length;i>0;i--)
        {
            Map<Double,Integer> slopeMap = new HashMap<Double,Integer>();
            int duplicates=0;
            int max=0;
            for( int j=0;j<i;j++)
            {
                int [] p1 = points[j];
                int [] p2 = points[i];

                if(p2[1]==p1[1] && p1[0]==p2[0]){
                    duplicates++;
                    continue;
                }
                double  slope = Double.MAX_VALUE;
                if(p2[0]-p1[0]!=0)
                    slope = (double)(p2[1]-p1[1])/(p2[0]-p1[0]);
                if(slopeMap.containsKey(slope)){
                    int count= slopeMap.get(slope)+1;
                    slopeMap.put(slope,count);
                    max = Math.max(max,count);
                }else{
                    slopeMap.put(slope,1);
                    if(max<(1))
                        max=1;
                }
            }
            maxpoints= Math.max(maxpoints,max+duplicates);
        }
        return maxpoints+1;
    }

}
