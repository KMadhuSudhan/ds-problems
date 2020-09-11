package ds.problems.array;

import java.util.Arrays;

public class _881BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boat = 0;
        int left = 0;
        int right = people.length - 1;

        while(left <= right) {
            if(people[left] + people[right] <= limit)
                left++;
            right--;
            boat++;
        }
        return boat;
    }
}
