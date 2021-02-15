package FebruaryCodeFiles;

import java.util.PriorityQueue;

public class TheKWeakestRowsInMatrix {
    //Since we require two details of each row for comparison, we'll make a custom object containing those two data
    //it implements comparable interface because we will store it in a priority queue
    //and priority queue will internally compare these object, so should know how to compare
    static class RowSoldiers implements Comparable<RowSoldiers>{
        //number of 1s in each row
        int countOfSoldiers;
        //index of the row
        int rowNumber;

        //constructor
        public RowSoldiers(int countOfSoldiers, int rowNumber) {
            this.countOfSoldiers = countOfSoldiers;
            this.rowNumber = rowNumber;
        }

        //method of the comparable class
        //we sort in ascending order
        @Override
        public int compareTo(RowSoldiers o) {
            //if count of 1s is same in two rows, then row number should be compared
            //else number of 1s
            return this.countOfSoldiers==o.countOfSoldiers ?
                    this.rowNumber-o.rowNumber :
                    this.countOfSoldiers-o.countOfSoldiers;
        }
    }

    static class Solution{
        public int[] kWeakestRows(int[][] mat, int k) {
            //initialize a priority queue of above defined object
            PriorityQueue<RowSoldiers> weakestSoldiers = new PriorityQueue<>();

            //iterate through each row, to get the number of soldiers in that rpw
            for(int row=0; row<mat.length; row++){
                //initialize the count to 0
                int row_iterator=0;
                //while we are in the matrix and a 0 is not encountered (since no 1 can be after a 0)
                while(row_iterator<mat[row].length && mat[row][row_iterator]!=0){
                    //increment the count of soldiers till above condition holds true
                    row_iterator++;
                }
                //create a object with above details and push it to priority queue
                weakestSoldiers.add(new RowSoldiers(row_iterator, row));
            }
            //create the ans array exactly of size k
            int[] ans = new int[k];

            //maintain index till k in ans
            int numberOfWeakestSoldiers = 0;

            //while we have not stored all k soldiers
            while (numberOfWeakestSoldiers<k){
                //according to problem constraints we'll never encounter this condition
                if(weakestSoldiers.isEmpty())
                    break;
                //dd the top of priority queue to ans
                ans[numberOfWeakestSoldiers] = weakestSoldiers.poll().rowNumber;
                //increment the index
                numberOfWeakestSoldiers++;
            }
            //return answer
            return ans;
        }
    }

    public static void main(String[] args) {
        //tried on both example test cases
        int[][] mat1 = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}};
        int k1 = 3;

        int[][] mat2 = {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}};
        int k2 = 2;

        Solution s = new Solution();
        int[] ans1 = s.kWeakestRows(mat1, k1);
        int[] ans2 = s.kWeakestRows(mat2, k2);

        for(int rows: ans1)
            System.out.print(rows + " ");
        System.out.println();

        for(int rows: ans2)
            System.out.print(rows + " ");
        System.out.println();
    }

}
