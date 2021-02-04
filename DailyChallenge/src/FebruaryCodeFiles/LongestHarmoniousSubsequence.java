package FebruaryCodeFiles;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    static class Solution{
        public int findLHS(int[] nums) {
            Map<Integer, Integer> numberAndCount = new HashMap<>();

            for (int num : nums) {
                if (numberAndCount.containsKey(num)) {
                    numberAndCount.put(num, numberAndCount.get(num) + 1);
                } else {
                    numberAndCount.put(num, 1);
                }
            }

            int maxCount = 0;
            for(Map.Entry<Integer, Integer> entry: numberAndCount.entrySet()){
                int curr_number = entry.getKey();
                if(!numberAndCount.containsKey(curr_number+1))
                    continue;

                int currCount = entry.getValue() + numberAndCount.get(curr_number+1);
                maxCount = Math.max(currCount, maxCount);
            }

            return maxCount;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findLHS(new int[]{1,3,2,2,5,2,3,7}));
        System.out.println(s.findLHS(new int[]{1,2,3,4}));
        System.out.println(s.findLHS(new int[]{1,1,1,1}));
    }
}
