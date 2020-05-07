package april2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.valueOf;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class SingleNumber {
    // my solution
    static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            }
            else {
                map.replace(nums[i], map.get(nums[i])+1);
            }

        }

        // find the map entry with value 1
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }

        return 0;
    }
    // better solution from leetcode
    // uses less extra memory
    static int better(int[] nums) {
        List<Integer> no_duplicate_list = new ArrayList<>();
        for(int i : nums) {
            if(!no_duplicate_list.contains(i)) {
                no_duplicate_list.add(i);
            } else {
                no_duplicate_list.remove(valueOf(i));
            }
        }
        return no_duplicate_list.get(0);
    }
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println(better(arr));
    }
}
