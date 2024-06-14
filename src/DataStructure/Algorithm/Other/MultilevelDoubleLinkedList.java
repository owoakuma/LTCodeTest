package DataStructure.Algorithm.Other;

public class MultilevelDoubleLinkedList {
    public Node flatten(Node head) {
        if(head==null){
            return null;
        }
        Node pointer = head;
        while (pointer.next!=null){
            if(pointer.child!=null){
                pointer.child.prev = pointer;
                Node nextNode = pointer.next;
                pointer.next = flatten(pointer.child);
                pointer.child=null;
                while (pointer.next!=null){
                    pointer = pointer.next;
                }
                pointer.next=nextNode;
                nextNode.prev=pointer;
            }
            pointer=pointer.next;
        }
        if(pointer.child!=null){
            pointer.child.prev = pointer;
            pointer.next = flatten(pointer.child);
            pointer.child=null;
        }
        return head;
    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}