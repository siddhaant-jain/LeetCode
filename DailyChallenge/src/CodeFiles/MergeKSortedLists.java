package CodeFiles;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    //Definition for singly-linked list.
    static class ListNode {
      int val;
      ListNode next;
//      ListNode() {}
      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            //using lambda function
            //PriorityQueue<ListNode> topNodes = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);

            //using comparator class
            PriorityQueue<ListNode> topNodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

            //this node will be used to traverse the answer linked list we will create
            ListNode ans=null;
            //this node will contain head pointer of answer linked list which we'll return at end
            ListNode headOfAns=null;

            //we will add head nodes of all the lists only if the list is not empty
            for(ListNode headNode: lists)
                if(headNode!=null)
                    topNodes.add(headNode);

            //we will take out the top element every time from the heap and add it to list
            //then we will add next element of the list whose element we've put in output
            //and check if we the list is not finished
            while (topNodes.size()>0){
                ListNode smallestNode = topNodes.poll();

                //just to ensure there is no error
                if(smallestNode==null)
                    continue;

                //if list has not started yet
                if(ans==null) {
                    //this will be the first node
                    ans = smallestNode;
                    //save the head, to return it later
                    headOfAns = ans;
                }
                else {
                    //if list already exists, add this node to end
                    ans.next = smallestNode;
                    //make ans point to last node
                    ans = ans.next;
                }

                //if this list is not exhausted yet, then add the next node to heap
                if(smallestNode.next!=null)
                    topNodes.add(smallestNode.next);
            }

            //return the final ans
            return headOfAns;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        Solution s = new Solution();
        ListNode ans = s.mergeKLists(new ListNode[]{list1, list2, list3});

        while(ans!=null){
            System.out.print(ans.val + "->");
            ans=ans.next;
        }
        System.out.println("\b\b");
    }
}
