package FebruaryCodeFiles;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null)
                return null;

            Node listIterator = head;

            //inserting a copy of each node after that node and adjusting links
            while (listIterator != null) {
                Node newNode = new Node(listIterator.val);
                newNode.next = listIterator.next;
                listIterator.next = newNode;
                listIterator = newNode.next;
            }

            //resetting iterator to beginning of modified list
            listIterator = head;
            //new head will be second node of the modified list
            Node newHead = listIterator.next;

            //adjusting random pointers
            while (listIterator != null && listIterator.next != null) {
                //if random is null for current node then we cannot access its next node
                if (listIterator.random != null)
                    listIterator.next.random = listIterator.random.next;

                //only visiting nodes of original list
                listIterator = listIterator.next.next;
            }

            //separating the two lists
            listIterator = head;
            while (listIterator != null && listIterator.next != null) {
                Node newListNode = listIterator.next;
                listIterator.next = newListNode.next;
                if (listIterator.next != null)
                    newListNode.next = listIterator.next.next;
                listIterator = listIterator.next;
            }

            return newHead;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        Node newList = s.copyRandomList(null);
        System.out.println(newList);
    }
}
