package ds.problems.maps;
//https://leetcode.com/problems/the-skyline-problem/
//218. The Skyline Problem

import java.util.*;

public class _218TheSkylineProblem {
    public static void main(String[] args) {

    }
    private static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        boolean isStart;
        int height;
        BuildingPoint(int x,int height,boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(BuildingPoint o) {
            //first compare by x.
            //If they are same then use this logic
            //if two starts are compared then higher height building should be picked first
            //if two ends are compared then lower height building should be picked first
            //if one start and end is compared then start should appear before end
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];


        int i=0;
        for(int[] building: buildings) {
            buildingPoints[i] =  new BuildingPoint(building[0],building[2],true);
            buildingPoints[i+1] =  new BuildingPoint(building[1],building[2],false);
            i+=2;
        }
        Arrays.sort(buildingPoints);
        int prevMax = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(0,1);
        for(BuildingPoint buildingPoint: buildingPoints) {
            if(buildingPoint.isStart) {
                map.compute(buildingPoint.height,(key,value) -> {
                    if(value != null) {
                        return value+1;
                    }
                    return 1;
                });
            } else {
                map.compute(buildingPoint.height,(key,value) -> {
                    if(value == 1) {
                        return null;
                    }
                    return value-1;
                });
            }
            int currentMaxHeight = map.lastKey();
            if(prevMax!=currentMaxHeight) {
                List<Integer> list = new ArrayList<>();
                list.add(buildingPoint.x);
                list.add(currentMaxHeight);
                ans.add(list);
                prevMax = currentMaxHeight;
            }
        }
        return ans;
    }
}
