package CodeFiles;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {
    static class Solution {
        public boolean closeStrings(String s1, String s2) {
            //if unequal lengths, then they cannot be transformed
            // (because neither of the operation adds or remove character)
            if (s1.length() != s2.length())
                return false;

            //store frequency of character (will also help in knowing if character present or not)
            int[] charFreq1 = new int[26];
            int[] charFreq2 = new int[26];

            //update frequency array for both words
            for (int i = 0; i < s1.length(); i++) {
                charFreq1[s1.charAt(i) - 'a']++;
                charFreq2[s2.charAt(i) - 'a']++;
            }

            //if any letter is present in one word and absent in another then transformation not possible
            for (int i = 0; i < 26; i++) {
                if ((charFreq1[i] != 0 && charFreq2[i] == 0) || (charFreq1[i] == 0 && charFreq2[i] != 0))
                    return false;
            }

            Arrays.sort(charFreq1);
            Arrays.sort(charFreq2);

            //if the same frequencies are not present in both the words,
            // then transformation is not possible by operation 2
            for (int i = 0; i < 26; i++) {
                if (charFreq1[i] != charFreq2[i])
                    return false;
            }
            //if no condition is violated, then transformation can happen
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.closeStrings("abc", "cba"));
        System.out.println(s.closeStrings("a", "aa"));
        System.out.println(s.closeStrings("cabbba", "abbccc"));
        System.out.println(s.closeStrings("cabbba", "aabbss"));
    }
}
