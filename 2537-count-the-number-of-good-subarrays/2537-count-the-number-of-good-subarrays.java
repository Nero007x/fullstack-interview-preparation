import java.util.*;

public class Solution {
    public long countGood(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        long pairCount = 0;
        long result = 0;

        for (int right = 0; right < nums.length; right++) {

            int num = nums[right];

            // Add new element → contributes existing freq to pairs
            pairCount += freq.getOrDefault(num, 0);

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            // When we have at least k pairs
            while (pairCount >= k) {

                // All subarrays from right → end are valid
                result += nums.length - right;

                int leftNum = nums[left];

                // Remove left element → reduce pairs
                pairCount -= (freq.get(leftNum) - 1);

                freq.put(leftNum, freq.get(leftNum) - 1);

                left++;
            }
        }

        return result;
    }
}