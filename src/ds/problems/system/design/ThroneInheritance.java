package ds.problems.system.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThroneInheritance {
    List<String> ans;
    Map<String, Boolean> alive;
    Map<String, Node> map;
    Node root;

    class Node {
        String parent;
        List<Node> childrens;

        public Node(String name) {
            parent = name;
            childrens = new ArrayList();
        }
    }

    public ThroneInheritance(String kingName) {
        root = new Node(kingName);
        map = new HashMap();
        ans = new ArrayList();
        alive = new HashMap();
        map.put(kingName, root);
        alive.put(kingName, true);
    }

    public void birth(String parentName, String childName) {
        Node node = new Node(childName);
        map.get(parentName).childrens.add(node);
        map.put(childName, node);
        alive.put(childName, true);
    }

    public void death(String name) {
        alive.put(name, false);
    }

    public List<String> getInheritanceOrder() {
        ans = new ArrayList();
        inorder(root);
        return ans;
    }

    public void inorder(Node root) {
        if (root == null) return;
        if (alive.get(root.parent)) ans.add(root.parent);
        for (Node node : root.childrens) {
            inorder(node);
        }
    }
}
