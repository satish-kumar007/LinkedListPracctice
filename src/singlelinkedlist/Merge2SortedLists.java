package singlelinkedlist;

public class Merge2SortedLists {
    public static void main(String[] args) {
        CreateLinkedList linkedList = new CreateLinkedList();

        Node head = linkedList.createLinkedList(3);
        Node linkedList2 = linkedList.createLinkedList(5);
        head.next = linkedList2;
        Node linkedList3 = linkedList.createLinkedList(7);
        linkedList2.next = linkedList3;
        Node linkedList4 = linkedList.createLinkedList(9);
        linkedList3.next = linkedList4;
        Node linkedList5 = linkedList.createLinkedList(10);
        linkedList4.next = linkedList5;

        CreateLinkedList linkedList_1 = new CreateLinkedList();

        Node head_1 = linkedList_1.createLinkedList(6);
        Node linkedList2_1 = linkedList_1.createLinkedList(8);
        head_1.next = linkedList2_1;
        Node linkedList3_1 = linkedList_1.createLinkedList(12);
        linkedList2_1.next = linkedList3_1;
        Node linkedList4_1 = linkedList_1.createLinkedList(14);
        linkedList3_1.next = linkedList4_1;
        Node linkedList5_1 = linkedList_1.createLinkedList(20);
        linkedList4_1.next = linkedList5_1;

        Node node = sortTwoLinkedLists(head, head_1);
        printLinkedList(node);
    }

    static Node sortTwoLinkedLists(Node head1, Node head2) {
        Node mergedList = new Node(-1);
        Node temp = mergedList;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }
        return mergedList.next;
    }

    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            // Print the data of the current node
            System.out.print(temp.data + " ");
            // Move to the next node
            temp = temp.next;
        }
        System.out.println();
    }

}
