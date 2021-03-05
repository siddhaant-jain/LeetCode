package MarchCodeFiles;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AverageOfLevelsInBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class MapEntry {
        double average;
        int no_of_nodes;

        public MapEntry(double avg, int num) {
            this.average = avg;
            this.no_of_nodes = num;
        }
    }

    static class Solution {
        public void averageOfLevels(TreeNode root, int currLevel, Map<Integer, MapEntry> levels) {
            if (root == null)
                return;

            if (!levels.containsKey(currLevel))
                levels.put(currLevel, new MapEntry(root.val, 1));

            else {
                double avgTillNow = levels.get(currLevel).average;
                int nodesTillNow = levels.get(currLevel).no_of_nodes;

                double newAvg = ((avgTillNow * nodesTillNow) + root.val) / (nodesTillNow + 1);

                levels.put(currLevel, new MapEntry(newAvg, nodesTillNow + 1));
            }

            averageOfLevels(root.left, currLevel + 1, levels);
            averageOfLevels(root.right, currLevel + 1, levels);
        }

        public List<Double> averageOfLevels(TreeNode root) {
            Map<Integer, MapEntry> levels = new HashMap<>();
            averageOfLevels(root, 0, levels);
            List<Double> ans = new LinkedList<>();

            for (Map.Entry<Integer, MapEntry> me : levels.entrySet())
                ans.add(me.getValue().average);

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.averageOfLevels(null));
    }
}
