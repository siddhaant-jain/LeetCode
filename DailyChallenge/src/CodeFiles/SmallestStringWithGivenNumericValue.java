package CodeFiles;

import java.util.Arrays;

public class SmallestStringWithGivenNumericValue {

    static class Solution {
        public String getSmallestString(int n, int k) {
            //create a new character array (instead of string because we'll be making changes to this)
            char[] letters = new char[n];
            //by default fill it with lexicographically smallest string of size n
            Arrays.fill(letters, 'a');
            //since each 'a' has a value of 1 and there are total n 'a' .. so we reduce that value from k
            k-=n;

            //if k becomes 0, then we have the answer
            if(k==0)
                return String.copyValueOf(letters);

            //we will start making changes from last to get lexicographically smallest string
            for(int i=n-1; i>=0; i--){
                //if value is less than 25, then this will be the last character that needs to be changed
                if(k<25){
                    //it will be the smallest character, that makes value of k 0, or kth letter in alphabet
                    letters[i] = (char)((int)'a'+ k);
                    break;
                }
                //if value is more than 25, then we make it to z to maximum reduce k
                letters[i]='z';
                //-25 because we already recuded for character 'a', so we reduce one less
                k-=25;
            }

            //convert our character array to String and send it back
            return String.copyValueOf(letters);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getSmallestString(3, 27));
        System.out.println(s.getSmallestString(5, 73));
    }
}
