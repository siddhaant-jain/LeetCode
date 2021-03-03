package MarchCodeFiles;

public class MissingNumber {
    static class Solution{
        public int missingNumberUsingXor(int[] numArray){
            int xorOfArray = 0;
            for(int i=0; i<numArray.length; i++){
                xorOfArray^=(numArray[i]^(i+1));
            }

            return xorOfArray;
        }
        public int missingNumberUsingSum(int[] numArray) {
            int sumOfFirstNNumbers = (numArray.length*(numArray.length+1))/2;
            int sumOfArray = 0;
            for(int num:numArray)
                sumOfArray+=num;

            return sumOfFirstNNumbers-sumOfArray;

        }
        public int missingNumber(int[] nums) {
            return missingNumberUsingSum(nums);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.missingNumber(new int[]{3,0,1}));
        System.out.println(s.missingNumber(new int[]{0,1}));
        System.out.println(s.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(s.missingNumber(new int[]{0}));
    }
}
