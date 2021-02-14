package FebruaryCodeFiles;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class IsGraphBipartite {
    static class Solution {
        public boolean isBipartiteUtil(int[][] graph, int src, Set<Integer> black, Set<Integer> white) {
            //add the first node in any of the two sets (I'm adding in black)
            black.add(src);

            //add it to queue, so that we can add all its neighbours and assign them the other color
            //similar to bfs
            Queue<Integer> q = new LinkedList<>();
            q.add(src);

            //while we have not traversed all the node of the subgraph
            while (!q.isEmpty()) {
                //take out the first node
                Integer currNode = q.poll();

                //find all its neighbour from corresponding index
                for (int neighbour : graph[currNode]) {
                    //if it has been visited and has same colour as current node
                    //then graph cannot be bipartite
                    if ((black.contains(currNode) && black.contains(neighbour)) ||
                            (white.contains(currNode) && white.contains(neighbour)))
                        return false;

                    //if the current node has not been visited
                    if (!black.contains(neighbour) && !white.contains(neighbour)) {
                        //then put it in the colour set which does not contain current node
                        if (black.contains(currNode))
                            white.add(neighbour);
                        else
                            black.add(neighbour);

                        //finally add this node to queue if it was not previously visited
                        q.add(neighbour);
                    }
                }
            }

            //if we exhaust the queue with violating the condition then this sub graph is bipartite
            return true;
        }

        public boolean isBipartite(int[][] graph) {
            //for a bipartite graph all the nodes can be coloured using 2 colours
            //such that no 2 nodes which share an edge have the same colour

            //here we have taken two colors as black and white
            //(just variable names, can be taken as anything)
            Set<Integer> black = new HashSet<>();
            Set<Integer> white = new HashSet<>();

            //running from each node, for cases where graph is disconnected
            for (int i = 0; i < graph.length; i++) {
                //any visited node will be in either of the one colour set
                if (!black.contains(i) && !white.contains(i)) {
                    //check if the sub-graph with this node is bipartite or not
                    if (!isBipartiteUtil(graph, i, black, white))
                        //if it is not bipartite, then whole graph is not
                        return false;
                }
            }
            //if all sub-graphs are bipartite then the graph is bipartite
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] graph1 = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int[][] graph2 = new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};

        System.out.println(s.isBipartite(graph1));
        System.out.println(s.isBipartite(graph2));
    }
}
