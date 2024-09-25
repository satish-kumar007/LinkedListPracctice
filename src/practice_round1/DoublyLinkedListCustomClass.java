package practice_round1;

public class DoublyLinkedListCustomClass {
    Node head;
    Node tail;
    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data=data;
            next=null;
            prev=null;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedListCustomClass dll = new DoublyLinkedListCustomClass();
        dll.addNodeFront(23);
        dll.addNodeFront(3);
        dll.addNodeFront(20);
        dll.addNodeFront(12);
        dll.printDLL(dll.head);

        System.out.println();
        System.out.println("====================================================================");
        System.out.println();
        dll.addNodeEnd(23);
        dll.addNodeEnd(3);
        dll.addNodeEnd(20);
        dll.addNodeEnd(12);
        dll.printDLL(dll.head);

        System.out.println();
        System.out.println("====================================================================");
        System.out.println();
        dll.addNodeInPos(35,3);
        dll.printDLL(dll.head);

        System.out.println();
        System.out.println("====================================================================");
        System.out.println();
        dll.removeFront();
        dll.printDLL(dll.head);

        System.out.println();
        System.out.println("====================================================================");
        System.out.println();
        dll.removeLast();
        dll.printDLL(dll.head);

        System.out.println();
        System.out.println("====================================================================");
        System.out.println();
        dll.removeFromPos(3);
        dll.printDLL(dll.head);
    }

    public int getSize(Node head){
        int count=0;
        if(head == null)
            return 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    public void addNodeFront(int data){
        Node newnode = new Node(data);
        newnode.next = head;
        newnode.prev = null;

        if(head != null){
            head.prev = newnode;
        }
        head = newnode;
    }

    public void addNodeEnd(int data){
        Node nodenew = new Node(data);
        if(head == null){
            head = nodenew;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = nodenew;
            nodenew.prev = temp;
        }
    }

    public void addNodeInPos(int data, int pos){
        Node nodenew = new Node(data);

        if(pos == 1){
            addNodeFront(data);
        }else{
            Node current = head;
            nodenew.next = null;
            nodenew.prev = null;

            for(int i=1;i<pos-1 && current != null;i++){
                current = current.next;
            }
            nodenew.prev = current;
            nodenew.next = current.next;
            current.next = nodenew;
            nodenew.next.prev = nodenew;
        }
    }

    public void removeFront(){
        Node temp = head;
        if(head == null)
            return;
        head = temp.next;
        head.prev = null;
    }

    public void removeLast(){
        Node temp = head;
        if(head == null)
            return;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.prev.next=null;
    }

    public void removeFromPos(int pos){
        if(head == null)
            return;
        Node current = head;
        for(int i=1;i<pos-1 && current != null;i++){
            current = current.next;
        }
        current.next = current.next.next;
        current.next.prev = current;
    }
    public void printDLL(Node head){
        int size = getSize(head);
        Node temp = head;
        if(head == null)
            return;

        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("Size of DLL is :: "+size);
    }
}
