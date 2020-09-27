package ds.problems.string;
//https://leetcode.com/problems/reconstruct-itinerary/
//332. Reconstruct Itinerary

import java.util.*;

public class _332ReconstructItinerary {

    public static void main(String[] args) {
        _332ReconstructItinerary reconstructItinerary = new _332ReconstructItinerary();
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("MUC");
        list1.add("LHR");
        list.add(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("MUC");
        list.add(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("SFO");
        list3.add("SJC");
        list.add(list3);

        List<String> list4 = new ArrayList<>();
        list4.add("LHR");
        list4.add("SFO");
        list.add(list4);
        reconstructItinerary.findItinerary(list);

    }

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> hm = new HashMap<>();
        List<String> res = new ArrayList<>();
        //System.out.println(tickets.get(0).get(0));
        for (int i = 0; i < tickets.size(); i++) {
            if (!hm.containsKey(tickets.get(i).get(0))) {
                List<String> l = new ArrayList<>();
                l.add(tickets.get(i).get(1));
                //Collections.sort(l);
                hm.put(tickets.get(i).get(0), l);
            } else {
                hm.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
                Collections.sort(hm.get(tickets.get(i).get(0)));
            }
        }
        Stack<String> st = new Stack<>();
        st.push("JFK");
        while (!st.isEmpty()) {
            String src = st.peek();
            if (hm.get(src) == null || hm.get(src).size() == 0) {
                //System.out.println("in null");
                res.add(src);
                st.pop();
                //continue;
            } else {//System.out.println("in else");
                String s = hm.get(src).get(0);
                //System.out.println(s);
                st.push(s);
                hm.get(src).remove(s);
                //System.out.println(hm.get(src));
            }
        }
        Collections.reverse(res);
        return res;
    }
}
