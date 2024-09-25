package practice_round1;

public class LinkedListClass2CustomClass {

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

    public void insertAtPos(int pos, int data){
        ListNode newNode = new ListNode(data);
        newNode.data = data;
        newNode.next = null;
        if(pos <1 || pos > size+1)
            return;
        if(pos == 1){
            newNode.next = head;
            head = newNode;
            size++;
        }else{
            ListNode temp = head;
            int actualPos = pos-1;
            while(actualPos > 1){
                temp = temp.next;
                actualPos--;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    public void printList(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedListClass2CustomClass list = new LinkedListClass2CustomClass();
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
        int middle = list.getMidElement(head);
        System.out.println(middle);

        System.out.println();
        int middle2 = list.getMidElementHareTortoise(head);
        System.out.println(middle2);
    }

    public int getMidElementHareTortoise(ListNode head){
        if(head == null)
            return 0;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public int getMidElement(ListNode head){
        int length = getSize(head);
        ListNode temp = head;
        int midIndex = length/2;
        while(midIndex > 0){
            temp = temp.next;
            midIndex--;
        }
        return temp.data;
    }

    public int getSize(ListNode head){
        ListNode temp = head;
        int length=0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

}
