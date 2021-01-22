package CodeFiles;

import java.util.Stack;

public class FindTheMostCompetitiveSubsequence {
    static class Solution{
        public int[] mostCompetitiveUsingStack(int[] nums, int k){
            //find number of elements to be removed from nums to get exactly k elements in answer
            int elements_to_be_removed = nums.length-k;
            //initialize a stack to compare elements in linear time
            Stack<Integer> answerStack = new Stack<>();
            //this will contain final answer to be returned
            int[] ans = new int[k];

            //iterate through all elements of the array
            for (int num : nums) {
                //if stack is not empty and there are elements remaining to be removed
                //and current number is smaller than top element of stack then remove top element
                //and update the number of elements to be removed
                while (!answerStack.empty() && answerStack.peek() > num && elements_to_be_removed-- > 0)
                    answerStack.pop();

                //finally when all the greater elements have been removed, push this number to answer
                answerStack.push(num);
            }

            //if after processing the whole array, there are more than k elements in stack
            //then start removing from top until we reach the size of k
            //we simply remove from top as the elements are in sorted order
            while(!answerStack.empty() && elements_to_be_removed-- >0)
                answerStack.pop();

            //transfer the elements of stack to the output array in reverse order
            //since greatest number will be on top in stack
            for(int i=k-1; i>=0; i--)
                ans[i] = answerStack.pop();

            //return the final output array
            return ans;
        }

        public int[] mostCompetitive(int[] nums, int k) {
            return mostCompetitiveUsingStack(nums, k);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.print("[");
        for(int i: s.mostCompetitive(new int[]{3,5,2,6}, 2))
            System.out.print(i + ",");
        System.out.println("\b]");

        System.out.print("[");
        for(int i: s.mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4))
            System.out.print(i + ",");
        System.out.println("\b]");

    }
}
