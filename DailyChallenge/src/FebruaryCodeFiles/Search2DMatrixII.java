package FebruaryCodeFiles;

public class Search2DMatrixII {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;

            //initialize starting point as last element of first row
            int currentRow = 0;
            int currentColumn = n - 1;

            //searching should run while we are at a valid point (inside matrix)
            while (currentRow >= 0 && currentRow < m && currentColumn >= 0 && currentColumn < n) {
                //if current location holds the target value return true
                if (matrix[currentRow][currentColumn] == target)
                    return true;

                //if the element at current location is less than target
                //then all the elements in current row will be less than target
                //and hence we move to next row
                else if (matrix[currentRow][currentColumn] < target)
                    currentRow++;

                //if the element at current location is greater than target
                //then all the elements in current column will be greater than target
                //and hence we should check in one column less
                else
                    currentColumn--;
            }

            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target1 = 5;
        int target2 = 20;


        Solution s = new Solution();
        System.out.println(s.searchMatrix(matrix, target1));
        System.out.println(s.searchMatrix(matrix, target2));
    }
}
