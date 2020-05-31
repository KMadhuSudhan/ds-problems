package ds.problems.array;
//https://leetcode.com/problems/decompress-run-length-encoded-list/
//1313. Decompress Run-Length Encoded List

public class _1313DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        int freq = 0;
        for (int i = 0; i < nums.length; i += 2) {
            freq += nums[i]; // determine sum of frequencies
        }
        int[] decompressed = new int[freq]; // initialize array of necessary size
        int index = 0;
        for (int i = 1; i < nums.length; i += 2) { // loop over values
            for (int j = 0; j < nums[i - 1]; j++) { // allocate the specified (by freq.) # of replications
                decompressed[index] = nums[i]; // assign
                index++; // increment index in decompressed array
            }
        }
        return decompressed;
    }
}
