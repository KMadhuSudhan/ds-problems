package ds.problems.graphs;
//https://leetcode.com/problems/accounts-merge/
//721. Accounts Merge

import java.util.*;

public class _721AccountsMerge {
    class DSU {
        int[] parent;
        DSU() {
            parent = new int[10001];
            for(int i=0;i<=10000;i++) {
                parent[i] = i;
            }
        }
        int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int i,int j) {
            int x = find(i);
            int y = find(j);
            parent[x] = y;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap();
        Map<String, Integer> emailToID = new HashMap();
        int id = 0;
        for(List<String> account: accounts) {
            String name = "";
            for(String email: account) {
                if(name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email,name);
                if(!emailToID.containsKey(email)) {
                    emailToID.put(email,id++);
                }
                dsu.union(emailToID.get(account.get(1)),emailToID.get(email));
            }
        }
        Map<Integer, List<String>> ans = new HashMap();
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index,x-> new ArrayList()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }
}
