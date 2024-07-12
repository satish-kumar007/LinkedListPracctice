package doublylinkedlist;

public class DoublyLinkedListOperations {

    Node head=null;
    Node tail = null;
    public Node insertAtBeginning(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = newnode;
            tail = newnode;
        }else{
            newnode.next = head;
            head.previous = newnode;
            head = newnode;
        }
        return head;
    }
}
