package MarchCodeFiles;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    static class Solution {
        public int distributeCandies(int[] candyType) {
            Set<Integer> candyTypesFound = new HashSet<>();
            int totalCandiesToBeEaten = candyType.length / 2;
            int candiesEatenTillNow = 0;

            for (int candy : candyType) {
                if (candyTypesFound.contains(candy))
                    continue;

                candiesEatenTillNow++;
                candyTypesFound.add(candy);

                if (candiesEatenTillNow >= totalCandiesToBeEaten)
                    break;
            }
            return candiesEatenTillNow;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.distributeCandies(new int[] {1,1,2,2,3,3}));
        System.out.println(s.distributeCandies(new int[] {1,1,2,3}));
        System.out.println(s.distributeCandies(new int[] {6,6,6,6}));
    }
}
