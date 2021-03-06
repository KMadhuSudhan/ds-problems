package ds.problems.array;
//https://leetcode.com/problems/keys-and-rooms/
//841. Keys and Rooms

import java.util.List;

public class _841KeysandRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        visitRooms(rooms,rooms.get(0),visited);
        for (int i=0;i<rooms.size();i++) {
            if(visited[i] == false) return false;
        }
        return true;
    }

    public void visitRooms(List<List<Integer>> rooms,List<Integer> list,boolean[] visited) {
        for (int key: list){
            if(visited[key]) continue;
            visited[key] = true;
            visitRooms(rooms,rooms.get(key),visited);
        }
    }
}
