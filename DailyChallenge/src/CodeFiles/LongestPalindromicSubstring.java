package CodeFiles;

public class LongestPalindromicSubstring {
    static class Solution {
        //function to solve this problem using dynamic programming
        public String longestPalindromeDp2d(String s) {
            //use to store whether substring with a given start point and end point is palindrome or not
            boolean[][] lps = new boolean[s.length()][s.length()];
            //maximum length palindromic substring found so far
            int max_length=Integer.MIN_VALUE;
            //store starting point and end point of longest palindromic substring
            int ansStart = 0, ansEnd=0;

            //consider all length substrings starting from single character up to
            //whole string as single substring
            for(int curr_length=1; curr_length<=s.length(); curr_length++){
                //starting point of all substring of current length
                for(int substring_start=0; substring_start<s.length()-curr_length+1; substring_start++){
                    //if single character, it is always palindrome
                    if(curr_length==1)
                        lps[substring_start][substring_start]=true;

                    else{
                        //find ending point of this substring,
                        //based on starting point and current length
                        int substring_end = substring_start+curr_length-1;
                        //if characters at both corners are not same
                        //then it cannot be a plaindrome
                        if(s.charAt(substring_start) != s.charAt(substring_end)) {
                            lps[substring_start][substring_end] = false;
                            continue;
                        }
                        //if we reach here then corner characters are same
                        //if length is 2 then obviously it is palindrome
                        if(curr_length==2)
                            lps[substring_start][substring_end] = true;

                        //else we check if we remove these corner character
                        //is rest of the substring of length (current_length-2) palindrome or not
                        else
                            lps[substring_start][substring_end] = lps[substring_start+1][substring_end-1];

                        //finally er update our answer if current substring is palindrome
                        //and its length is more than the maximum length palindrome found till now
                        if(lps[substring_start][substring_end] && max_length<substring_end-substring_start){
                            max_length = substring_end-substring_start;
                            ansStart = substring_start;
                            ansEnd = substring_end;
                        }

                    }
                }
            }

            //return final aswer once we've checked all the substrings
            return s.substring(ansStart, ansEnd+1);
        }

        public String longestPalindrome(String s) {
            return longestPalindromeDp2d(s);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println("Longest palindromic substring for babad: " + s.longestPalindrome("babad"));
        System.out.println("Longest palindromic substring for cbbd: " + s.longestPalindrome("cbbd"));
        System.out.println("Longest palindromic substring for a: " + s.longestPalindrome("a"));
        System.out.println("Longest palindromic substring for aacabdkacaa: " + s.longestPalindrome("aacabdkacaa"));
    }
}
