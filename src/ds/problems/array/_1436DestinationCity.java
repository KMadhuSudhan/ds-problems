package ds.problems.array;
//https://leetcode.com/problems/destination-city/
//1436. Destination City

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1436DestinationCity {

    public String destCity(List<List<String>> paths) {
        Map<String,String> map = new HashMap();
        for(List<String> list: paths) {
            map.put(list.get(0),list.get(1));
        }
        String city = paths.get(0).get(1);
        while(map.get(city)!=null) {
            city = map.get(city);
        }
        return city;
    }
}
