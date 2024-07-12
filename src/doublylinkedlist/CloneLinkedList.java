package doublylinkedlist;

class RandomListNode {
    int label;
    RandomListNode next, random;
   RandomListNode(int x) {
       this.label = x;
   }
}
public class CloneLinkedList {

    public static RandomListNode cloneLinkedList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode newNode = new RandomListNode(curr.label);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        RandomListNode clonedHead = head.next;
        RandomListNode clonedCurr = clonedHead;
        while (clonedCurr.next != null) {
            curr.next = curr.next.next;
            clonedCurr.next = clonedCurr.next.next;
            curr = curr.next;
            clonedCurr = clonedCurr.next;
        }
        curr.next = null;
        clonedCurr.next = null;
        return clonedHead;
    }
}
