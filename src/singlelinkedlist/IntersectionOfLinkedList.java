package singlelinkedlist;

public class IntersectionOfLinkedList {
    public static void main(String[] args) {
        CreateLinkedList linkedList = new CreateLinkedList();

        Node head = linkedList.createLinkedList(1);
        Node linkedList2 = linkedList.createLinkedList(2);
        head.next = linkedList2;
        Node linkedList3 = linkedList.createLinkedList(3);
        linkedList2.next = linkedList3;
        Node linkedList4 = linkedList.createLinkedList(4);
        linkedList3.next = linkedList4;
        Node linkedList5 = linkedList.createLinkedList(5);
        linkedList4.next = linkedList5;

        CreateLinkedList linkedList_1 = new CreateLinkedList();

        Node head_1 = linkedList_1.createLinkedList(6);
        Node linkedList2_1 = linkedList_1.createLinkedList(3);
        head_1.next = linkedList2_1;
        Node linkedList3_1 = linkedList_1.createLinkedList(4);
        linkedList2_1.next = linkedList3_1;
        Node linkedList4_1 = linkedList_1.createLinkedList(5);
        linkedList3_1.next = linkedList4_1;

        Node intersection = findIntersectionPoint(head, head_1);
        AddAndDisplayLinkedList.displayList(intersection);

    }

    static public Node getIntersectionNode(Node head1, Node head2)
    {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    private static Node findIntersectionPoint(Node list1, Node list2) {
        Node current1 = list1;

        // Traverse through the first linked list
        while (current1 != null) {
            Node current2 = list2;

            // Traverse through the second linked list
            while (current2 != null) {
                // If both linked lists point to the same node
                if (current1 == current2) {
                    return current1;
                }
                current2 = current2.next;
            }
            current1 = current1.next;
        }

        // If there is no intersecting node
        return null;
    }
}
