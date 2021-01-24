package CodeFiles;

import java.util.*;

public class SortTheMatrixDiagonally {

    static class Solution{
        public int[][] diagonalSort(int[][] mat) {
            //create a map which will store a list of all elements in a particular diagonal
            Map<Integer, List<Integer>> diagonalList = new HashMap<>();

            for(int i=0; i<mat.length; i++){
                for(int j=0; j<mat[0].length; j++){
                    //each diagonal will have a unique difference between row and column
                    //and it will be same for all elements in the diagonal
                    int key = i-j;

                    //if this diagonal was not found before than add a new list with above mentioned key
                    if(!diagonalList.containsKey(key))
                        diagonalList.put(key, new ArrayList<>());

                    //add current element to the corresponding list
                    diagonalList.get(key).add(mat[i][j]);
                }
            }

            //sort each of the lists
            for(Map.Entry<Integer, List<Integer>> entry: diagonalList.entrySet())
                Collections.sort(entry.getValue());

            //store it back in the matrix
            for(int i=0; i<mat.length; i++){
                for(int j=0; j<mat[0].length; j++){
                    //again find which diagonal we need
                    int key = i-j;

                    //put the current smallest element of that diagonal in this list
                    mat[i][j] = diagonalList.get(key).get(0);

                    //remove the smallest element
                    diagonalList.get(key).remove(0);
                }
            }

            //return the final diagonally sorted matrix
            return mat;
        }
    }

    public static void printMatrix(int[][] mat, int m, int n){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};

        System.out.println("Matrix before sorting it diagonally");
        printMatrix(mat, 3, 4);
        System.out.println();

        mat = s.diagonalSort(mat);

        System.out.println("Matrix after sorting it diagonally");
        printMatrix(mat, 3, 4);
    }
}
