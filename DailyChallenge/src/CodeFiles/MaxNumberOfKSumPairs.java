package CodeFiles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

    static class Solution {
        //using Map to find the other number in pair in constant time
        public int maxOperationsUsingSet(int[] num, int k){
            //initialize an empty map
            Map<Integer, Integer> numMap = new HashMap<>();

            //store the array in the map
            for(int i : num){
                //if this number has already been encountered before, then increment its frequency by 1
                if(numMap.containsKey(i))
                    numMap.put(i, numMap.get(i) + 1);
                //otherwise add to map we frequency 1
                else
                    numMap.put(i, 1);
            }

            //initialize ans to 0
            int ans=0;
            for (int curr_num : num) {
                //if curr num is greater than k then pair cannot be made as all numbers are positive
                if (curr_num > k)
                    continue;

                //find second number of pair
                int second_num = k - curr_num;
                //since we are visiting this number, we will update the frequency to one less
                //so that same number is not used in another pair
                int freq = numMap.get(curr_num);
                numMap.put(curr_num, freq - 1);

                //if map doesn't contain the other number
                // or all its occurrences have been used in other pairs then pair cannot be formed
                if (!(numMap.containsKey(second_num) || numMap.get(second_num) <= 0))
                    continue;

                //update frequency of second number like first one
                int freq2 = numMap.get(second_num);
                numMap.put(second_num, freq2 - 1);

                //if any of the frequencies are less than zero, it implies
                //all its occurrences have been used in other pairs therefore pair cannot be formed
                if (freq <= 0 || freq2 <= 0)
                    continue;

                //if none of invalid condition is met, we add this pair to ans
                ans++;
            }

            //return the final calculated ans
            return ans;
        }

        //using sorting so that we can use two pointer method
        public int maxOperationsUsingSorting(int[] num, int k){
            //sort the array so that we can use two pointer method
            Arrays.sort(num);

            //loop variables
            int i,j;
            //initialize answer
            int ans=0;
            //run the loop with both variables, one from beginning another from end
            for(i=0, j=num.length-1; i<num.length && j>=0;){
                //if j crossed i, then pairs will start repeating and j will have values which i already had
                //so we terminate the loop
                if(j<=i)
                    break;

                //if the current two numbers form a pair
                if(num[i]+num[j]==k) {
                    //we remove both the numbers from further calculations
                    i++;
                    j--;
                    //and update the answer
                    ans++;
                }
                else if(num[i]+num[j]>k)
                    //if pair is greater than k, then j cannot form pair with any number so remove j
                    j--;
                else
                    //if pair is less than k, then i cannot form pair with any number so remove i
                    i++;
            }

            //return finally calculated answer
            return ans;
        }
        public int maxOperations(int[] nums, int k) {
            //try with both ways (second one performs better)
//          return maxOperationsUsingSet(nums,k);
            return maxOperationsUsingSorting(nums,k);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxOperations(new int[] {1,2,3,4}, 5));
        System.out.println(s.maxOperations(new int[] {3,1,3,4,3}, 6));
    }
}
