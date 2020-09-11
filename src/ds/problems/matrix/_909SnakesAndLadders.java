package ds.problems.matrix;
//https://leetcode.com/problems/snakes-and-ladders/
//909. Snakes and Ladders
//https://leetcode.com/problems/snakes-and-ladders/discuss/720544/Transform-the-board-to-list-and-apply-BFS

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _909SnakesAndLadders {
    public class Node{
        int index;
        int distance;
    }
    public List<Integer> getMovesAsList(int[][]board){
        boolean reverse = false;
        List<Integer> moves = new ArrayList<>();

        for(int i=board.length-1; i>=0; i--){
            if(reverse){
                for(int j=board.length-1; j>=0; j--){
                    moves.add(board[i][j]);
                }
                reverse = false;
            }else{
                for(int j=0; j<board.length; j++){
                    moves.add(board[i][j]);
                }
                reverse = true;
            }
        }
        return moves;
    }
    public int snakesAndLadders(int[][] board) {
        List<Integer> moves = getMovesAsList(board);
        int last = moves.size();
        int [] visited = new int[last];

        Node start = new Node();
        start.index = 0;
        start.distance = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(visited[node.index]==1)
                continue;

            visited[node.index] = 1;

            if(node.index == last-1)
                return node.distance;

            for(int dice=1; dice<=6; dice++){
                int nextMove = node.index+dice;

                if(nextMove >= last){
                    break;
                }

                if(moves.get(nextMove)!=-1){
                    nextMove = moves.get(nextMove)-1;
                }
                Node next = new Node();
                next.index = nextMove;
                next.distance = node.distance + 1;
                queue.add(next);
            }
        }
        return -1;
    }
}
