package april2020;

/**
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class MaximumSubArray {
    /**
     * Using Kadane's algorithm
     */
    static int maxSubArray(int[] nums) {
        int max_current, max_global;
        max_current = max_global = nums[0];

        for(int i = 1; i < nums.length; i++) {
            // current max is the max between, the previous max + current element
            // and the current element
            max_current = Math.max(nums[i], max_current + nums[i]);
            if(max_current > max_global) max_global = max_current;
        }
        return max_global;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + ", ");

    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print("[");
        printArray(arr);
        System.out.print("]\n");
        System.out.println("Maximum sum is " + maxSubArray(arr));
    }
}
