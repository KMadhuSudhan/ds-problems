package ds.problems.string;
//https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
//1418. Display Table of Food Orders in a Restaurant

import java.util.*;

public class _1418DisplayTableofFoodOrdersinaRestaurant {

    public static void main(String[] args) {
        _1418DisplayTableofFoodOrdersinaRestaurant displayTableofFoodOrdersinaRestaurant = new _1418DisplayTableofFoodOrdersinaRestaurant();
        List<List<String>> input = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("David");
        row1.add("3");
        row1.add("Ceviche");
        input.add(row1);
        List<String> row2 = new ArrayList<>();
        row2.add("Corina");
        row2.add("10");
        row2.add("Beef Burrito");
        input.add(row2);


        List<String> row3 = new ArrayList<>();
        row3.add("David");
        row3.add("3");
        row3.add("Fried Chicken");
        input.add(row3);

        List<String> row4 = new ArrayList<>();
        row4.add("Carla");
        row4.add("5");
        row4.add("Water");
        input.add(row4);

        List<String> row5 = new ArrayList<>();
        row5.add("Carla");
        row5.add("5");
        row5.add("Ceviche");
        input.add(row5);


        List<String> row6 = new ArrayList<>();
        row6.add("Rous");
        row6.add("3");
        row6.add("Ceviche");
        input.add(row6);


       System.out.println(displayTableofFoodOrdersinaRestaurant.displayTable(input));
    }
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer,Map<String,String>> mapTreeMap = new TreeMap<>();
        Map<String,String> headerKeys = new TreeMap<>();
        for(List<String> stringList : orders) {
            Map<String,String> map = mapTreeMap.getOrDefault(Integer.parseInt(stringList.get(1)),new TreeMap<>());
            String itemOrders = map.getOrDefault(stringList.get(2),"0");
            map.put(stringList.get(2),Integer.toString(Integer.parseInt(itemOrders) + 1));
            headerKeys.put(stringList.get(2),"");
            mapTreeMap.put(Integer.parseInt(stringList.get(1)),map);
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for(String headerKey : headerKeys.keySet()) {
            header.add(headerKey);
        }
        ans.add(header);
        Set<Integer> tables = mapTreeMap.keySet();
        for(Integer tableNo: tables) {
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(tableNo));
            for(String headerKey : headerKeys.keySet()) {
                String value = mapTreeMap.get(tableNo).get(headerKey);
                row.add(value == null ? "0" : value);
            }
            ans.add(row);
        }
        return ans;
    }
}
