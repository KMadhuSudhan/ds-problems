package ds.problems.math;
//https://leetcode.com/problems/reformat-date/
//1507. Reformat Date

import java.util.HashMap;
import java.util.Map;

public class _1507ReformatDate {
    public String reformatDate(String date) {
        String[] parts = date.split(" ");
        String dateStr = parts[0];
        StringBuilder dateBuilder = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        int i=dateStr.length()-3;
        while(i>=0) {
            dateBuilder.insert(0,dateStr.charAt(i));
            i--;
        }
        Integer dateInt = Integer.valueOf(dateBuilder.toString());
        Map<String,String> map = getMap();
        String month = map.get(parts[1]);
        String year = parts[2];
        return year + "-" + month + "-" + (dateInt <=9 ? "0" + dateInt: dateInt);
    }

    Map<String,String> getMap() {
        Map<String,String> map = new HashMap();
        map.put("Jan","01");
        map.put("Feb","02");
        map.put("Mar","03");
        map.put("Apr","04");
        map.put("May","05");
        map.put("Jun","06");
        map.put("Jul","07");
        map.put("Aug","08");
        map.put("Sep","09");
        map.put("Oct","10");
        map.put("Nov","11");
        map.put("Dec","12");
        return map;
    }
}
