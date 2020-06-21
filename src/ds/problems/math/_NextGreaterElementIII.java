package ds.problems.math;
//https://leetcode.com/problems/next-greater-element-iii/
//556. Next Greater Element III

public class _NextGreaterElementIII {
    public static void main(String[] args) {
        _NextGreaterElementIII nextGreaterElementIII = new _NextGreaterElementIII();
        System.out.println(nextGreaterElementIII.nextGreaterElement(4916872));
        //49126782
        //4917268
    }
    public int nextGreaterElement(int n) {
        char[] a=(""+n).toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i + 1] <= a[i]) {
            i--;
        }
        if(i<0)
            return -1;
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }
        swap(a, i, j);
        reverse(a, i + 1);
        try{
            return Integer.parseInt(new String(a));
        }
        catch(Exception e){
            return -1;
        }
    }

    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
