package CodeFiles;

import java.util.Arrays;

class Solution {

    public int countVowelRecursive(int n, int charIndex, int[][] dp){

        for(int i=0; i<5; i++){
            //if length is 1, then we know the solution
            if(n==1)
                dp[0][i]=1;

                //if we haven't calculated the solution for this sub problem yet
            else if(dp[n-2][i]==-1){
                dp[n-2][i]=countVowelRecursive(n-1, i, dp);
            }
        }

        //if length 1, then no need to proceed further
        if(n==1)
            return 1;

        int ans=0;

        //0 represents a
        if(charIndex==0){
            //with a, the substring can start with all the characters (a,e,i,o,u)
            for(int i=0; i<5; i++)
                ans+=dp[n-2][i];
        }
        //1 represents e
        else if(charIndex==1){
            //with e, the substring can start with 4  characters (e,i,o,u)
            for(int i=1; i<5; i++)
                ans+=dp[n-2][i];
        }
        //2 represents i
        else if(charIndex==2){
            //with i, the substring can start with 3 characters (i,o,u)
            for(int i=2; i<5; i++)
                ans+=dp[n-2][i];
        }
        //3 represents o
        else if(charIndex==3){
            //with o, the substring can start with 2 characters (o,u)
            for(int i=3; i<5; i++)
                ans+=dp[n-2][i];
        }
        //4 represents u
        else{
            //with u, the substring can start with only u
            ans+=dp[n-2][4];
        }

        //return the ans for current alphabet
        return ans;
    }

    public int countVowelStrings(int n) {
        //initialize dp with only 5 columns corresponding to each alphabet
        //nth length will be in n-1 position
        int[][] dp = new int[n][5];

        //initialize with -1, to signify it is not calculated yet
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i],-1);

        //find answer with all 5 alphabets
        int ans=0;
        for(int i=0; i<5; i++)
            ans+=countVowelRecursive(n, i,dp);
        //return final ans
        return ans;
    }
}

public class CountSortedVowelStrings {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countVowelStrings(1));
        System.out.println(s.countVowelStrings(2));
        System.out.println(s.countVowelStrings(33));

    }
}
