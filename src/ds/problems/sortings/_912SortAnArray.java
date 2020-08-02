package ds.problems.sortings;
//https://leetcode.com/problems/sort-an-array/
//912. Sort an Array

public class _912SortAnArray {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        _912SortAnArray sortAnArray = new _912SortAnArray();
        sortAnArray.sortArray(nums);
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public int[] sortArray(int[] nums) {
       // mergeSort(nums,0,nums.length-1);
       // bubbleSort(nums);
        //quickSort(nums,0,nums.length-1);
        //insertionSort(nums);
        selectionSort(nums);
        return nums;
    }

    void selectionSort(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            int min = i;
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j] < nums[i]) {
                    min = j;
                }
            }
            if(i!=min) {
                int tmp = nums[min];
                nums[min] = nums[i];
                nums[i] = tmp;
            }
        }
    }
    void insertionSort(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            int tmp = nums[i];
            int j= i-1;
            while (j>=0 && nums[j] > tmp) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = tmp;
        }
    }

    void quickSort(int[] nums,int left,int right) {
        if(left<right) {
            int pivot = partition(nums,left,right);
            quickSort(nums,left,pivot-1);
            quickSort(nums,pivot+1,right);
        }
    }

    int partition(int[] nums,int left,int right) {
            int pivot = nums[right];
            int i= left-1;
            for(int j=left;j<right;j++) {
                    if(nums[left] < pivot) {
                        i++;
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                    }
            }
            int tmp = nums[i+1];
            nums[i+1] = nums[right];
            nums[right] = tmp;
            return i+1;
    }

    void bubbleSort(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            boolean flag = false;
            for(int j=0;j<nums.length-i-1;j++) {
                if(nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = true;
                }
            }
            if(flag == false) break;
        }
    }

    void mergeSort(int[] nums,int left,int right) {
        if(left<right) {
            int mid = (left + right)/2;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    void merge(int[] nums,int left,int mid,int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] a = new int[n1];
        int[] b = new int[n2];
        int i,j,k;
        for(i=0;i<n1;i++) {
            a[i] = nums[left+i];
        }
        for(i=0;i<n2;i++) {
            b[i] = nums[mid+i+1];
        }
        i=0;
        j=0;
        k=left;
        while(i<n1&&j<n2) {
            if(a[i] <= b[j]) {
                nums[k++] = a[i++];
            } else {
                nums[k++] = b[j++];
            }
        }
        while(i<n1) {
            nums[k++] = a[i++];
        }
        while(j<n2) {
            nums[k++] = b[j++];
        }
    }

}
