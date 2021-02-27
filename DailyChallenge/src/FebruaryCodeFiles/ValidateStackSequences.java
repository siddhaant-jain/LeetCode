package FebruaryCodeFiles;

import java.util.Stack;

public class ValidateStackSequences {
    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed.length == 0 && popped.length == 0)
                return true;

            if (pushed.length == 0 || popped.length == 0)
                return false;

            Stack<Integer> s = new Stack<>();

            int poppedIndex = 0;
            s.push(pushed[0]);

            for (int i = 1; i < pushed.length; i++) {
                while (!s.empty() && s.peek() == popped[poppedIndex]) {
                    s.pop();
                    poppedIndex++;
                }

                s.push(pushed[i]);
            }

            while (!s.empty()) {
                if (poppedIndex >= popped.length)
                    return false;
                if (s.peek() == popped[poppedIndex]) {
                    poppedIndex++;
                }
                s.pop();
            }

            return s.empty() && poppedIndex == popped.length;
        }
    }

    public static void main(String[] args) {

        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped1 = new int[]{4,5,3,2,1};
        int[] popped2 = new int[]{4,3,5,1,2};

        Solution s = new Solution();

        System.out.println(s.validateStackSequences(pushed, popped1));
        System.out.println(s.validateStackSequences(pushed, popped2));

    }
}
