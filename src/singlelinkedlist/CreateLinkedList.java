package singlelinkedlist;

public class CreateLinkedList {
    public Node createLinkedList(int data){
        Node head = null;
        Node tail = null;
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        return head;
    }
}
