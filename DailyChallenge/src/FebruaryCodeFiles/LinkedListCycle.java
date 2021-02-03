package FebruaryCodeFiles;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
    static class Solution{
        public boolean hasCycle(ListNode head) {
            if(head==null || head.next==null)
                return false;

            ListNode slowPointer = head;
            ListNode fastPointer = head.next.next;

            while(fastPointer!=null && fastPointer.next!=null){
                if(slowPointer==fastPointer || fastPointer.next==slowPointer)
                    return true;
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hasCycle(new ListNode(5)));
    }
}
