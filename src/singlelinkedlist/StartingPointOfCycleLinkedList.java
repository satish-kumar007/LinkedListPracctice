package singlelinkedlist;

public class StartingPointOfCycleLinkedList {
    public static void main(String[] args) {
        CreateLinkedList linkedList = new CreateLinkedList();

        Node head = linkedList.createLinkedList(21);
        Node linkedList2 = linkedList.createLinkedList(34);
        head.next = linkedList2;
        Node linkedList3 = linkedList.createLinkedList(45);
        linkedList2.next = linkedList3;
        Node linkedList4 = linkedList.createLinkedList(67);
        linkedList3.next = linkedList4;
        Node linkedList5 = linkedList.createLinkedList(90);
        linkedList4.next = linkedList5;
        Node linkedList6 = linkedList.createLinkedList(21);
        linkedList5.next = linkedList6;
        Node linkedList7 = linkedList.createLinkedList(25);
        linkedList6.next = linkedList7;
        Node linkedList8 = linkedList.createLinkedList(28);
        linkedList7.next = linkedList8;
        linkedList8.next = linkedList4; // only for loop - test Floyd Algo

        Node node = startingPointOfLoop(head);
        System.out.println(node.data);
    }

    public static Node startingPointOfLoop(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;
        boolean isCycle=false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
