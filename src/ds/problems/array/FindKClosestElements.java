package ds.problems.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/problems/find-k-closest-elements/
//658. Find K Closest Elements

public class FindKClosestElements {

    public List<Integer> findClosestElementsBinarySearch(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList();
        if (arr.length == 0) return ans;
        int n = arr.length;
        int l = 0;
        int r = n - k;
        while (l < r) {
            int middle = (l + r) / 2;
            if (x - arr[middle] > arr[middle + k] - x)
                l = middle + 1;
            else
                r = middle;
        }
        for (int i = l; i < l + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList();
        if (arr.length == 0) return ans;
        int left, right;
        int index = binarySearch(arr, x);
        left = index - 1;
        right = index;
        int count = 0;
        while (count < k) {
            if (left == -1) {
                ans.add(arr[right]);
                count++;
                right++;
                continue;
            }
            if (right == arr.length) {
                ans.add(arr[left]);
                count++;
                left--;
                continue;
            }
            if (((x - arr[left]) == (arr[right] - x)) || ((x - arr[left]) < (arr[right] - x))) {
                ans.add(arr[left]);
                left--;
            } else {
                ans.add(arr[right]);
                right++;
            }
            count++;
        }
        Collections.sort(ans);
        return ans;
    }

    int binarySearch(int[] arr, int x) {
        if (x <= arr[0]) return 0;
        if (x >= arr[arr.length - 1]) return arr.length - 1;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (end - start);
            if (arr[mid] == x) {
                return mid;
            }
            if (x > arr[mid - 1] && x < arr[mid]) {
                return mid;
            }
            if (x > arr[mid] && x < arr[mid + 1]) {
                return mid + 1;
            }
            if (arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
