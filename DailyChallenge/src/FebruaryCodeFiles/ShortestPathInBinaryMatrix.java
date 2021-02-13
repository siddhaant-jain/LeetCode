package FebruaryCodeFiles;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    //a custom object to store necessary information of any element of matrix
    static class Node{
        //will store the co-ordinates of the element and its distance from origin(0,0)
        int i,j,dist;

        //parameterized constructor
        public Node(int i, int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    static class Solution{
        //function to check if current row and column are valid or not
        public static boolean isValid(int i, int j, int n, int[][] grid, boolean[][] visited){
            //if current row and column are within the matrix and
            // are not blocked or visited then they can be included in path
            return i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 0 && !visited[i][j];
        }

        //finding shortest path using bfs
        public int shortestPathBfs(int[][] grid){
            //dimensions of grid (nXn)
            int n = grid.length;
            //a 2-d array to ensure that current element is not visited before
            boolean[][] visited = new boolean[n][n];
            //to check all 8 possibilities from any given point
            //this will have total 9 possibilities but 1 will always be visited (0,0)
            int[] possibilities = new int[] {0,1,-1};
            //mark the source as visited
            visited[0][0] = true;
            // initialize a queue which will store all the valid neighbours of current node
            Queue<Node> bfsQueue = new LinkedList<>();
            //add source vertex to the queue
            bfsQueue.add(new Node(0,0, 1));

            //while we haven't visited all the valid nodes and destination node is not found
            while(!bfsQueue.isEmpty()){
                //take the next node from the queue
                Node curr_node = bfsQueue.poll();
                //retrieve all its data
                int curr_row = curr_node.i;
                int curr_col = curr_node.j;
                int curr_dist = curr_node.dist;

                //then check for all its neighbours
                for (int row_possibility : possibilities) {
                    for (int column_possibility : possibilities) {
                        int next_row = curr_row + row_possibility;
                        int next_col = curr_col + column_possibility;

                        //if the neighbour is valid i.e. can be visited
                        if (isValid(next_row, next_col, n, grid, visited)) {
                            //if this neighbour is the destination then we got the answer
                            if (next_row == n - 1 && next_col == n - 1) {
                                //neighbour will be one node ahead of current node
                                return curr_dist+1;
                            } else {
                                //since we are inside valid neighbour block
                                //we will add this to queue

                                //before that we mark this node as visited
                                visited[next_row][next_col] = true;
                                //create a Node object with this data
                                Node next_node = new Node(next_row, next_col, curr_dist + 1);
                                //and add it to queue
                                bfsQueue.add(next_node);
                            }
                        }
                    }
                }
            }
            //if we finish the queue it means we didn't find reach the destination
            //and hence answer cannot be found
            return -1;
        }
        public int shortestPathBinaryMatrix(int[][] grid) {
            //corner test case -- when starting point is only blocked
            if(grid[0][0]==1)
                return -1;

            //another corner test case -- when starting point [0][0] is also the destination
            //and it will not be 1 because we checked that above
            if(grid.length==1)
                return 1;

            //our function which treats this grid as a graph represented as an adjacency matrix
            // and uses bfs to find the shortest path from one point to another
            return shortestPathBfs(grid);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid1 = new int[][] {{0,1},{1,0}};
        int[][] grid2 = new int[][] {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(s.shortestPathBinaryMatrix(grid1));
        System.out.println(s.shortestPathBinaryMatrix(grid2));
    }
}
