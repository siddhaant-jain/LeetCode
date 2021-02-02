package FebruaryCodeFiles;

public class NumberOf1Bits {
    static class Solution{
        public int hammingWeight(int n) {
            int noOfOnes=0;
            while(n!=0){
                n&=(n-1);
                noOfOnes++;
            }

            return noOfOnes;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(00000000000000000000000000001011));
        System.out.println(s.hammingWeight(00000000000000000000000010000000));
        System.out.println(s.hammingWeight(-3)); //11111111111111111111111111111101
    }
}
