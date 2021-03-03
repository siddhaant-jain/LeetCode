package MarchCodeFiles;

import java.util.Arrays;

public class SetMismatch {
    static class Solution {
        public int[] findErrorNums(int[] nums) {
            int duplicateNumber = -1;
            int missingNumber = -1;

            for(int i=0; i<nums.length; i++){
                int indexToVisit = Math.abs(nums[i])-1;
                if(nums[indexToVisit]>0)
                    nums[indexToVisit]*=-1;
                else
                    duplicateNumber = indexToVisit+1;
            }
            for(int i=0; i<nums.length; i++){
                if(nums[i]>0){
                    missingNumber = i+1;
                    break;
                }
            }
            return new int[]{duplicateNumber, missingNumber};
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(s.findErrorNums(new int[]{1, 1})));
    }
}
