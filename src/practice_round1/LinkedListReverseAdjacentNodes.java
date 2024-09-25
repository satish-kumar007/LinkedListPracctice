package practice_round1;

public class LinkedListReverseAdjacentNodes {

    static ListNode head;
    int size=0;
    class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addNodeFront(int data){
        ListNode node = new ListNode(data); // Create a node with mention data.
        node.next = head;// Point node to head
        head = node; // Make the node as head of linked list
        size++;
    }

    public void addNodeEnd(int data){
        ListNode node = new ListNode(data); // create the node first
        if(head == null){ // check if LL contains element, if yes, move to line 40 else add an element as head and return.
            head = new ListNode(data);
            size++;
            return;
        }
        node.next = null; // Because we are adding node in the end, end node next will always null;
        ListNode temp = head; // Create a temp node who represent head;
        while(temp.next != null) { //Traverse the entire list until reach last node;
            temp = temp.next;    // its like temp++
        }
        temp.next = node;// Point last node next to node;
        size++;
        return;
    }

    public void printList(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public void reverseAdj(){
        ListNode curr = head.next.next;
        ListNode prev = head;
        head = head.next; //30
        head.next = prev; //20

        // Fix remaining nodes 20 30 40 50 70 10 90
        while (curr != null && curr.next != null){
            prev.next = curr.next; // 50
            prev = curr; //40
            ListNode next = curr.next.next;//70
            curr.next.next = curr;
            curr = next;
        }
        prev.next = curr;
    }

    public static void main(String[] args) {
        LinkedListReverseAdjacentNodes list = new LinkedListReverseAdjacentNodes();
        list.addNodeFront(20);
        list.addNodeEnd(30);
        list.addNodeEnd(40);
        list.addNodeEnd(50);
        list.addNodeEnd(70);
        list.addNodeEnd(10);
        list.addNodeEnd(90);
        //list.addNodeEnd(50);
        list.printList();
        System.out.println();

        list.reverseAdj();
        list.printList();
    }

}
