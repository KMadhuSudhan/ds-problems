package ds.problems.string;
//https://leetcode.com/problems/subdomain-visit-count/
//811. Subdomain Visit Count

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _811SubdomainVisitCount {
    public static void main(String[] args) {
        _811SubdomainVisitCount subdomainVisitCount = new _811SubdomainVisitCount();
        String[] list = {"9001 discuss.leetcode.com"};
        subdomainVisitCount.subdomainVisits(list);
    }
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap();
        for(String str: cpdomains) {
            String[] domains = str.split("\\.");
            String[] visitStr = str.split(" ");
            int visitCount = Integer.parseInt(visitStr[0]);
            String rootDomain = visitStr[1];
            int count = map.getOrDefault(rootDomain,0);
            map.put(rootDomain,count + visitCount);
            StringBuilder sb = new StringBuilder();
            sb.append(domains[domains.length-1]);
            count = map.getOrDefault(sb.toString(),0);
            map.put(sb.toString(),count + visitCount);

            for(int i=domains.length-2;i>0;i--) {
                sb.insert(0,".");
                sb.insert(0,domains[i]);
                count = map.getOrDefault(sb.toString(),0);
                map.put(sb.toString(),count + visitCount);
            }
        }

        List<String> ans = new ArrayList();
        for(Map.Entry<String,Integer> entry: map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            ans.add(sb.toString());
        }
        return ans;
    }
}
