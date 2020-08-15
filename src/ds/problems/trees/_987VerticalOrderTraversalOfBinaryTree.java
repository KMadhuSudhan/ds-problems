package ds.problems.trees;

import java.util.*;

public class _987VerticalOrderTraversalOfBinaryTree {
    class VerticalOrder {
        TreeNode treeNode;
        int x;
        int y;
        VerticalOrder(TreeNode treeNode,int x,int y) {
            this.treeNode = treeNode;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,List<VerticalOrder>> map =  bfs(root);
        for(Map.Entry<Integer,List<VerticalOrder>> entry: map.entrySet()) {
            List<VerticalOrder> list = entry.getValue();
            Collections.sort(list, new Comparator<VerticalOrder>() {
                @Override
                public int compare(VerticalOrder o1, VerticalOrder o2) {
                    if(o1.y == o2.y) {
                        return o1.treeNode.val - o2.treeNode.val;
                    } else {
                        return o2.y - o1.y;
                    }
                }
            });
            List<Integer> tmp = new ArrayList<>();
            for(VerticalOrder verticalOrder: list) {
                tmp.add(verticalOrder.treeNode.val);
            }
            ans.add(tmp);
        }
        return ans;
    }

    TreeMap<Integer,List<VerticalOrder>> bfs(TreeNode root) {
        TreeMap<Integer,List<VerticalOrder>> treeMap = new TreeMap<>();
        if(root == null) {
            return treeMap;
        }
        Queue<VerticalOrder> queue = new LinkedList<>();
        VerticalOrder verticalOrder = new VerticalOrder(root,0,0);
        queue.add(verticalOrder);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                verticalOrder = queue.poll();
                int x = verticalOrder.x;
                int y = verticalOrder.y;
                if(treeMap.containsKey(x)) {
                    List<VerticalOrder> list = treeMap.get(x);
                    list.add(verticalOrder);
                    treeMap.put(x,list);
                } else {
                    List<VerticalOrder> list = new ArrayList<>();
                    list.add(verticalOrder);
                    treeMap.put(x,list);
                }

                if(verticalOrder.treeNode.left!=null) {
                    queue.add(new VerticalOrder(verticalOrder.treeNode.left,x-1,y-1));
                }

                if(verticalOrder.treeNode.right!=null) {
                    queue.add(new VerticalOrder(verticalOrder.treeNode.right,x+1,y-1));
                }
            }
        }
        return treeMap;
    }
}
