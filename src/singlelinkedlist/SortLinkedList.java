package singlelinkedlist;

import java.util.LinkedList;

public class SortLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(3);
        list1.add(8);
        list1.add(12);
        list1.add(56);
        list1.add(2);


    }

    public Node sortedMerge(Node a, Node b){
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public Node mergeSort(Node h){
        // Base case : if head is null
        if (h == null || h.next == null) {
            return h;
        }
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;

        middle.next = null;
        Node left = mergeSort(h);
        Node right = mergeSort(nextofmiddle);
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list
    public static Node getMiddle(Node head){
        if (head == null)
            return head;
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
