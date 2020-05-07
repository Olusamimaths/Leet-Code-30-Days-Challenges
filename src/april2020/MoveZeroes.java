package april2020;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {
    /**
     * Using a strategy similar to Lumoto's Partition scheme for quick sort
     * @param nums
     */
    static void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != 0 ){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }

    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main() {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        printArray(arr);
    }

}
