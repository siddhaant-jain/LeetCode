package CodeFiles;

import java.util.Stack;

public class ValidParentheses {
    static class Solution{
        //we can do this in linear time using stack
        public boolean checkUsingStack(String s){
            //initialize an empty stack
            Stack<Character> openBracketsInOrder = new Stack<>();

            //loop variable to iterate through each character of string
            int index=0;

            //loop through the string
            while(index<s.length()){
                //if we encounter an open bracket we simply push it to the stack
                //as nothing can be determined from an opening bracket
                if(s.charAt(index) == '(' || s.charAt(index) == '{' || s.charAt(index) == '[')
                    openBracketsInOrder.push(s.charAt(index));

                //if closing bracket encountered
                else{
                    //if there are no opening brackets (extra closing bracket found)
                    //then parenthesis not balanced and hence we need not check further
                    if(openBracketsInOrder.empty())
                        return false;

                    //find the last inserted bracket whose closing brakcet has not been found yet
                    Character lastBracketType = openBracketsInOrder.pop();

                    //if it doesn't match with the closing bracket we found right now
                    //then parenthesis not balanced and hence we need not check further
                    if((s.charAt(index)==')' && lastBracketType!='(') ||
                    (s.charAt(index)=='}' && lastBracketType!='{') ||
                    (s.charAt(index)==']' && lastBracketType!='['))
                        return false;
                }

                //if everything work fine till this index, we increment it to next
                index++;
            }

            //if stack not empty after the loop, it means
            //there is one or more opening bracket whose closing bracket is not present
            //and hence parenthesis not balanced so we return false
            return openBracketsInOrder.empty();
        }
        public boolean isValid(String s) {
            return checkUsingStack(s);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        //testing our code on example test cases provided
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("([)]"));
        System.out.println(s.isValid("{[]}"));
    }
}
