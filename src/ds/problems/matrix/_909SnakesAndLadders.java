package ds.problems.matrix;
//https://leetcode.com/problems/snakes-and-ladders/
//909. Snakes and Ladders

import java.util.LinkedList;
import java.util.Queue;

public class _909SnakesAndLadders {

    class Node {
        int distance;
        int index;
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int size = n*n;

        int[] moves = getMoves(board);
        boolean[] visited = new boolean[size];

        Queue<Node> queue = new LinkedList<>();
        Node node = new Node();
        node.index = 0;
        node.distance = 0;
        queue.add(node);
        visited[0] = true;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if(visited[node.index]) continue;
            visited[node.index] = true;
            if(node.distance == size - 1) return node.distance;
            for(int dice=1;dice<=6;dice++) {
                int nextMove = node.index + dice;
                if(nextMove >= size) {
                    break;
                }
                if(moves[nextMove]!=-1) {
                    nextMove = moves[nextMove] - 1;
                }

                Node next = new Node();
                next.index = nextMove;
                next.distance = node.distance  + 1;
                queue.add(next);
            }
        }
        return -1;
    }
    int[] getMoves(int[][] board) {
        boolean reverse = false;
        int size = board.length,index=0;
        int[] moves = new int[size*size];
        for(int i=size-1;i>=0;i--) {
            if(reverse) {
                for(int j=size-1;j>=0;j--) {
                    moves[index++] = board[i][j];
                }
            } else {
                for(int j=0;j<size;j++) {
                    moves[index++] = board[i][j];
                }
            }
        }
        return moves;
    }
}
