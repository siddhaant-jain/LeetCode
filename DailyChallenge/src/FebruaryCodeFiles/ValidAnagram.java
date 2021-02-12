package FebruaryCodeFiles;

public class ValidAnagram {
    static class Solution{
        public boolean isAnagram(String s, String t) {
            int[] charFrequencyArray = new int[256];

            //add count of every character encountered in s
            for(int i=0; i<s.length(); i++){
                charFrequencyArray[s.charAt(i)-'a']++;
            }

            //remove count of every character encountered in t
            for(int i=0; i<t.length(); i++){
                charFrequencyArray[t.charAt(i)-'a']--;
            }

            //if the addition and subtraction does not cancel out and result to 0
            //for any character, then string cannot be anagram, hence return false
            for(int i=0; i<256; i++){
                if(charFrequencyArray[i]!=0)
                    return false;
            }

            //if all elements are 0, then its an anagram, so return true
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isAnagram("anagram","nagaram"));
        System.out.println(s.isAnagram("rat", "car"));
    }
}
