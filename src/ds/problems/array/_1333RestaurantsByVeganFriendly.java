package ds.problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/submissions/
//1333. Filter Restaurants by Vegan-Friendly, Price and Distance
public class _1333RestaurantsByVeganFriendly {
    public static void main(String[] args) {
        _1333RestaurantsByVeganFriendly restaurantsByVeganFriendly = new _1333RestaurantsByVeganFriendly();
        int[][] restaurants = new int[][]{
                {1,4,1,40,10},
                {2,8,0,50,5},
                {3,8,1,30,4},
                {4,10,0,10,3},
                {5,1,1,15,1}
        };
        restaurantsByVeganFriendly.filterRestaurants(restaurants,1,50,10);
    }
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList();
        List<Integer> ans = new ArrayList();

        for(int j=0;j<restaurants.length;j++) {
            if(veganFriendly == 1 && restaurants[j][2] == 0) continue;
            if(restaurants[j][3] <= maxPrice && restaurants[j][4] <=maxDistance) {
                list.add(restaurants[j]);
            }
        }
        Collections.sort(list,(a,b)-> {
            int comparision =  b[1] - a[1];
            if(0!=comparision) {
                return comparision;
            }
            return b[0] - a[0];
        });
        for(int[] restaurant: list) {
            ans.add(restaurant[0]);
        }
        return ans;
    }
}
