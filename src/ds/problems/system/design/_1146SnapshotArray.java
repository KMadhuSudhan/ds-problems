package ds.problems.system.design;
//https://leetcode.com/problems/snapshot-array/
//1146. Snapshot Array

import java.util.HashMap;
import java.util.Map;

public class _1146SnapshotArray {
    Map<Integer,Map<Integer, Integer>> snaps;
    Map<Integer, Integer> current_map;

    int snapShotId;
    public _1146SnapshotArray(int length) {
        current_map = new HashMap();
        snaps = new HashMap();
        snapShotId = 0;
    }

    public void set(int index, int val) {
        current_map.put(index,val);
    }

    public int snap() {
        snaps.put(snapShotId,current_map);
        current_map = new HashMap();
        return snapShotId++;
    }

    public int get(int index, int snap_id) {
        while (snap_id >= 0) {
            Map<Integer, Integer> map = snaps.get(snap_id);
            if (map.containsKey(index)) return map.get(index);
            snap_id--;
        }

        return 0;
    }
}
