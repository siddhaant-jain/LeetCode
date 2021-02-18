package FebruaryCodeFiles;

public class ContainerWithMostWater {
    static class Solution{
        //O(n^2) --- time and space complexity
        public int maxAreaDp(int[] height, int startIndex, int endIndex, int[][] dp){
            if(height == null || endIndex >= height.length || startIndex < 0 || endIndex <= startIndex)
                return 0;

            if(dp[startIndex][endIndex]!=-1)
                return dp[startIndex][endIndex];

            int leftPart = maxAreaDp(height, startIndex, endIndex-1, dp);
            int rightPart = maxAreaDp(height, startIndex+1, endIndex, dp);

            int currWater = (endIndex-startIndex) * Math.min(height[startIndex], height[endIndex]);

            dp[startIndex][endIndex] = Math.max(Math.max(leftPart,rightPart), currWater);
            return dp[startIndex][endIndex];
        }
        //O(1) -- space complexity and O(n) -- time complexity
        public int maxAreaLinear(int[] height){
            //initial maximum width using first and last bar
            int max_width = Math.min(height[height.length-1],height[0])*(height.length-1);
            int j= height.length-1;
            int i = 0;
            while(i<j){
                if(height[i]<height[j])
                    i++;
                else
                    j--;

                int curr_width = Math.min(height[j],height[i])*(j-i);
                max_width = Math.max(max_width, curr_width);
            }

            return max_width;
        }
        public int maxArea(int[] height) {
            //for dp solution
//            int[][] dp = new int[height.length][height.length];
//            for(int i=0; i< height.length; i++)
//                Arrays.fill(dp[i], -1);
//
//            return maxAreaDp(height, 0, height.length-1, dp);

            return maxAreaLinear(height);
        }
    }

    public static void main(String[] args) {

        //test cases
        int[] height1 = new int[] {1,8,6,2,5,4,8,3,7};
        int[] height2 = new int[] {1,1};
        int[] height3 = new int[] {4,3,2,1,4};
        int[] height4 = new int[] {1,2,1};

        Solution s = new Solution();
        System.out.println(s.maxArea(height1));
        System.out.println(s.maxArea(height2));
        System.out.println(s.maxArea(height3));
        System.out.println(s.maxArea(height4));
    }
}
