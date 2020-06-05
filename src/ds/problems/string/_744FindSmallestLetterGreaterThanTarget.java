package ds.problems.string;
//https://leetcode.com/problems/find-smallest-letter-greater-than-target
//744. Find Smallest Letter Greater Than Target


public class _744FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] > target)
                high = mid;
            else
                low = mid + 1;
        }

        if (letters[low] <= target)
            return letters[0];

        return letters[low];
    }
}
