package practice_round1;


public class LinkedListCustomClass {
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
    public static void main(String[] args) {
        LinkedListCustomClass list = new LinkedListCustomClass();
        list.addNodeFront(20);
        list.addNodeEnd(30);
        list.addNodeEnd(40);
        list.addNodeEnd(50);

        list.printList();
        System.out.println();

        list.insertAtPos(3, 32);
        list.printList();
        System.out.println();

        list.insertAtPos(2, 52);
        list.printList();
        System.out.println();
        System.out.println();
        System.out.println("==== Remove Bth mode from the end. ====");

        ListNode removeNthNodeListEnd = list.removeNthNodeListEnd(head, 2);
        list.printReverseList(removeNthNodeListEnd);

        System.out.println("===================================");
        System.out.println();

        list.deleteFromPos(4);
        list.printList();
        System.out.println();

        list.deleteFromStart();
        list.printList();
        System.out.println();

        list.deleteFromEnd();
        list.printList();
        System.out.println();
        list.insertAtPos(2,80);
        list.insertAtPos(3,90);
        list.insertAtPos(4,800);
        list.insertAtPos(1,180);
        list.printList();
        System.out.println();

        list.deleteFromPos(3);
        list.printList();
        System.out.println();

        list.insertAtPos(3,90);
        list.insertAtPos(4,800);
        list.insertAtPos(1,180);
        list.printList();
        System.out.println();

        list.deleteNodeOfGivenValue(90);
        list.printList();
        System.out.println();

        list.deleteAllNodeOfGivenValue(800);
        list.printList();
        System.out.println();

        ListNode reverseList = list.reverseList(head);
        list.printReverseList(reverseList);
        System.out.println();

        ListNode removeDuplicate = list.removeDuplicate(reverseList);
        list.printReverseList(removeDuplicate);
        System.out.println();

        System.out.println("Size of LL :: "+list.size);
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

    public void deleteFromStart(){
        head = head.next;
        size--;
        return;
    }

    public void deleteFromEnd(){
        if(head == null){
            System.out.println("Nothing to delete");
            return;
        }
        ListNode previous = null;
        ListNode temp = head;
        while(temp.next != null){
            previous = temp;
            temp = temp.next;
        }
        previous.next = null;
        size--;
    }

    public void deleteFromPos(int pos){
        if(pos < 1 || pos > size+1){
            System.out.println("unable to delete");
            return;
        }
        if(pos == 1){
            deleteFromStart();
            size--;
            return;
        }else{
            ListNode temp = head;
            ListNode previous = null;
            int actualPos = pos-1;
            while(actualPos > 0){
                previous = temp;
                temp = temp.next;
                actualPos--;
            }
            previous.next = temp.next;
            size--;
        }
    }

    public void deleteNodeOfGivenValue(int value){
        if(head == null){
            System.out.println("nothing to remove");
            return;
        }
        ListNode temp = head;
        if(temp.data == value){
            head = temp.next;
            size--;
            return;
        }

        while(temp != null){
            if(temp.next != null && temp.next.data == value){
                temp.next = temp.next.next;
                break;
            }else{
                temp = temp.next;
            }
            size--;
        }
    }

    public void deleteAllNodeOfGivenValue(int val){
        ListNode temp = head;
        if(temp.data == val){
            head = temp.next;
            size--;
            return;
        }
        while(temp.next != null){
            if(temp.next.data == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
            size--;
        }

    }

    public ListNode reverseList(ListNode head){
        ListNode current = head;
        ListNode prev=null;
        ListNode next=null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public boolean checkListForPalindrome(ListNode head){
        boolean isPalindrome = false;
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversed = reverseList(slow.next);
        ListNode first = head;
        ListNode second = reversed;
        while(second != null){
            if(first.data != second.data){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public ListNode removeDuplicate(ListNode head){
        if(head == null)
            return null;
        ListNode current = head;
        while(current != null){
            ListNode temp = current;
            while(temp != null && temp.data == current.data){
                temp = temp.next;
            }
            current.next = temp;
            current = current.next;
        }
        return head;
    }

    public ListNode removeNthNodeListEnd(ListNode head, int B){
        int pos = size-B+1;
        if(pos < 1 || pos > size+1){
            System.out.println("unable to delete");
            return head;
        }
        if(pos == 1){
            head = head.next;
            return head;
        }else{
            ListNode temp = head;
            ListNode previous = null;
            int actualPos = pos-1;
            while(actualPos > 0){
                previous = temp;
                temp = temp.next;
                actualPos--;
            }
            previous.next = temp.next;
        }
        return head;
    }

    public void  KReverseLinkedList(ListNode A, int B){

    }


    public void printList(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public void printReverseList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void getThirdElement(){

    }
}
