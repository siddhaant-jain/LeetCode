package MarchCodeFiles;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> s = new HashSet<>();

            ListNode headATemp = headA;
            ListNode headBTemp = headB;

            while (headATemp != null && headBTemp != null) {
                if (s.contains(headATemp))
                    return headATemp;
                s.add(headATemp);

                if (s.contains(headBTemp))
                    return headBTemp;
                s.add(headBTemp);

                headATemp = headATemp.next;
                headBTemp = headBTemp.next;
            }

            while (headATemp != null) {
                if (s.contains(headATemp))
                    return headATemp;
                s.add(headATemp);
                headATemp = headATemp.next;
            }

            while (headBTemp != null) {
                if (s.contains(headBTemp))
                    return headBTemp;
                s.add(headBTemp);
                headBTemp = headBTemp.next;
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getIntersectionNode(null, null));
    }
}
