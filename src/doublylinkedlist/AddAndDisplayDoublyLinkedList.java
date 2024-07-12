package doublylinkedlist;

public class AddAndDisplayDoublyLinkedList {
    public static void main(String[] args) {
        AddAndDisplayDoublyLinkedList doublyLinkedList = new AddAndDisplayDoublyLinkedList();
        doublyLinkedList.add(4);
        doublyLinkedList.add(6);
        doublyLinkedList.add(3);
        doublyLinkedList.add(12);
        doublyLinkedList.add(74);
        doublyLinkedList.add(9);

        doublyLinkedList.displayDoublyLinkedList();
        System.out.println("=========================================================");

        doublyLinkedList.insertAtBeginning(1);
        doublyLinkedList.displayDoublyLinkedList();
    }

    public Node head;
    public Node tail;
    public Node add(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
            head.previous = null;
            tail.next = null;
        }else{
            tail.next = newnode;
            newnode.previous = tail;
            tail = newnode;
            tail.next = null;
        }
        return head;
    }

    public void displayDoublyLinkedList(){
        Node tempNode = head;
        if(head == null){
            System.out.println("No data");
            return;
        }
        while(tempNode != null){
            System.out.print(tempNode.data+" ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void insertAtBeginning(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            tail = newnode;
        }else{
            newnode.next = head;
            head.previous = newnode;
            head = newnode;
        }
    }

    public void insertAtAnyPos(int data, int pos){

    }
}
