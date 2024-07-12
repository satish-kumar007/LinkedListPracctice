package singlelinkedlist;

public class Add2LinkedList {
    public static void main(String[] args) {
        CreateLinkedList linkedList = new CreateLinkedList();
        Node head = linkedList.createLinkedList(2);
        Node linkedList2 = linkedList.createLinkedList(4);
        head.next = linkedList2;
        Node linkedList3 = linkedList.createLinkedList(3);
        linkedList2.next = linkedList3;


        CreateLinkedList linkedList_1 = new CreateLinkedList();

        Node head_1 = linkedList_1.createLinkedList(5);
        Node linkedList2_1 = linkedList_1.createLinkedList(6);
        head_1.next = linkedList2_1;
        Node linkedList3_1 = linkedList_1.createLinkedList(4);
        linkedList2_1.next = linkedList3_1;

        Node node = addTwoNumbers(head, head_1);
        AddAndDisplayLinkedList.displayList(node);
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        //l1 = singlelinkedlist.AddAndDisplayLinkedList.reverseList(l1);
        //l2 = singlelinkedlist.AddAndDisplayLinkedList.reverseList(l2);

        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}
