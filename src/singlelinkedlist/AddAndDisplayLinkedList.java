package singlelinkedlist;

public class AddAndDisplayLinkedList {

    private Node head = null;
    private Node tail = null;
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
        //linkedList8.next = linkedList4; // only for loop - test Floyd Algo


        AddAndDisplayLinkedList list = new AddAndDisplayLinkedList();
        //list.displayList(head);
        System.out.println("===================================");

        /*int i = list.countNodes(head);
        System.out.println("count is:: "+i);
        System.out.println("=====================================");

        String s = list.searchKElement(head, 11);
        System.out.println(s);
        System.out.println("=====================================");

        int max = list.maxElement(head);
        System.out.println("Max :: "+max);
        System.out.println("=====================================");

        int min = list.minElement(head);
        System.out.println("Min :: "+min);
        System.out.println("=====================================");

        int mid = list.getMidElement(head);
        System.out.println("Mid Element :: "+mid);
        System.out.println("=====================================");

        int sum = list.sumAllElements(head);
        System.out.println("Sum of Element :: "+sum);
        System.out.println("=====================================");

        singlelinkedlist.Node node = list.insertElement(head, 0, 100);
        list.displayList(node);
        System.out.println("=====================================");

        singlelinkedlist.Node pos5 = list.insertElement(node, 5, 120);
        list.displayList(pos5);
        System.out.println("=====================================");

        singlelinkedlist.Node del = list.deleteElement(pos5, 67);
        list.displayList(del);
        System.out.println("=====================================");

        singlelinkedlist.Node delAll = list.deleteEachOccurranceOfX(del, 21);
        list.displayList(delAll);
        System.out.println("=====================================");

        singlelinkedlist.Node reverse = list.reverseList(head);
        list.displayList(reverse);
        System.out.println("=====================================");

        singlelinkedlist.Node reverseSubList = list.reverseBetween(reverse, 3, 6);//21 34 45 67 90 21 25 28
        list.displayList(reverseSubList);
        System.out.println("=====================================");

        boolean isLoop = list.detectCycle(head);
        System.out.println(isLoop);
        System.out.println("=====================================");

        singlelinkedlist.Node removeLoop = list.detectAndRemoveLoop(head);
        list.displayList(removeLoop);
        System.out.println("=====================================");

        boolean isLoopNow = list.detectCycle(removeLoop);
        System.out.println(isLoopNow);
        System.out.println("=====================================");*/

    }

    public boolean detectCycle(Node head){
        if(head == null || head.next ==null)
            return false;
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next != null){
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public Node detectAndRemoveLoop(Node head){
        if(head == null || head.next ==null)
            return head;
        Node slow = head;
        Node fast = head;

        slow = head.next;
        fast = head.next.next;

        while(fast!=null && fast.next != null){
            if(slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow == fast){
            slow = head;
            if(slow != fast){
                while(slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
            }else{
                while(fast.next != slow){
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
        return head;
    }

    public static void displayList(Node head){
        Node temp = head;
        if(head == null){
            System.out.println("Empty List");
            return;
        }
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int countNodes(Node head){
        Node temp = head;
        int count=0;
        if(head == null) return 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    //search for K element
    public String searchKElement(Node head, int k){
        String message=null;
        if(head == null) return "No Element in the List";
        Node temp = head;

        while(temp != null){
            if(temp.data == k){
                message = "Element is present";
                break;
            }else{
                message =" Not Present";
            }
            temp = temp.next;
        }
        return message;
    }

    //Find Max element
    public int maxElement(Node head){
        int max = Integer.MIN_VALUE;
        if(head == null) return 0;
        Node temp = head;
        while(temp != null){
            if(temp.data > max){
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }

    public int minElement(Node head){
        int min = Integer.MAX_VALUE;
        if(head == null) return 0;
        Node temp = head;
        while(temp != null){
            if(temp.data < min){
                min = temp.data;
            }
            temp = temp.next;
        }
        return min;
    }

    public int getMidElement(Node head){
        int midElement = 0;
        if(head == null) return -1;
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        midElement = slow.data;
        return midElement;
    }

    public int sumAllElements(Node head){
        if(head == null) return -1;
        int sum=0;
        Node temp = head;
        while(temp != null){
            sum = sum +temp.data;
            temp = temp.next;
        }
        return sum;
    }

    public Node insertElement(Node head, int pos, int val){
        Node newnode = new Node(val);
        if(pos == 0){
            newnode.next=head;
            head = newnode;
        }else{
            Node temp = head;
            for(int i=1;i<pos;i++){
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }
        return head;
    }

    public Node deleteElement(Node head, int val){
        if(head == null) return head;
        Node temp = head;
        if(temp.data == val) {
            head = temp.next;
            return head;
        }
        while(temp != null){
            if(temp.next != null && temp.next.data == val){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public Node deleteEachOccurranceOfX(Node head, int val){
        if(head == null) return head;
        Node temp = head;
        if(temp.data == val){
            head = head.next;
        }
        while(temp.next != null){
            if(temp.next.data == val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }

    public static Node reverseList(Node head){
        Node temp = head;
        Node previous = null;
        Node next = null;
        while(temp != null){
            next = temp.next;
            temp.next=previous;
            previous = temp;
            temp = next;
        }
        head = previous;
        return head;
    }

    public Node reverseBetween(Node A, int B, int C) {
        Node current = A;
        Node first=null;
        Node from = null;
        Node to=null;
        Node last = null;
        int count=0;
        while(current != null) {
            count += 1;
            if (count < B) {
                first = current;
            }
            if (count == B) {
                from = current;
            }
            if (count == C) {
                to = current;
                last = to.next;
                break;
            }
            current = current.next;
        }
        to.next = null;
        reverseList(from);
        if(first != null){
            first.next = to;
        }else{
            A = to;
        }
        from.next = last;
        return A;
    }

    public static int isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return 1;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node node = reverseList(slow.next);
        Node first = head;


        Node second = node;
        while (second != null) {
            if (first.data != second.data) {
                return 0;
            }
            first = first.next;
            second = second.next;
        }
        return 1;
    }
}
