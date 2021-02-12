package FebruaryCodeFiles;

public class NumberOfStepsToReduceNumberToZero {
    static class Solution{
        //a simple recursive code in one line
        public int numberOfSteps (int num) {

//            //an easy to understand code which does the same job as the one line code
//
//            //base case
//            if(num==0)
//                return 0;
//
//            int minSteps=0;
//
//            //if odd number then find min steps by subtraction
//            if(num%2!=0)
//                minSteps = 1+numberOfSteps(num-1);
//
//            //if even number then find min steps by division
//            else
//                minSteps = 1+numberOfSteps(num/2);
//
//            return minSteps;

            return num==0? 0: num%2!=0 ? 1+numberOfSteps(num-1) : 1+numberOfSteps(num/2);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numberOfSteps(14));
        System.out.println(s.numberOfSteps(8));
        System.out.println(s.numberOfSteps(123));
    }
}
