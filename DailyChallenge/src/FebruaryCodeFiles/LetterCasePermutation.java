package FebruaryCodeFiles;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    static class Solution {
        public void letterCasePermutationRecursive(String s, String p, int totalLength,
                                                   int currIndex, List<String> ans) {
            //if for this permutation we have placed a character at each position
            //then one permutation is ready, we can add it to answer list
            if (currIndex == totalLength) {
                ans.add(p);
                return;
            }
            //there will three cases - lowercase letter, uppercase letter, digit

            //for all three cases
            //once we will keep the character same and check for rest of the string
            //for a digit, this will be the only case
            letterCasePermutationRecursive(s, p + s.charAt(currIndex),
                    totalLength, currIndex + 1, ans);

            //for lowercase letter
            if (s.charAt(currIndex) >= 65 && s.charAt(currIndex) <= 90)
                //second possibility
                //convert it to uppercase alphabet and check for rest of the string
                letterCasePermutationRecursive(s, p + (char) (s.charAt(currIndex) + 32),
                        totalLength, currIndex + 1, ans);

            //for uppercase letter
            else if (s.charAt(currIndex) >= 97 && s.charAt(currIndex) <= 122)
                //second possibility
                //convert it to lowercase alphabet and check for rest of the string
                letterCasePermutationRecursive(s, p + (char) (s.charAt(currIndex) - 32),
                        totalLength, currIndex + 1, ans);

        }

        public List<String> letterCasePermutation(String S) {
            List<String> ans = new ArrayList<>();

            //this function will replace each position with all characters possible there
            // and then check for rest of the string
            letterCasePermutationRecursive(S, "", S.length(), 0, ans);
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.letterCasePermutation("a1b2"));
        System.out.println(s.letterCasePermutation("3z4"));
        System.out.println(s.letterCasePermutation("12345"));
        System.out.println(s.letterCasePermutation("0"));
    }
}
