class MyLinkedList {
    Node head;
    int size;
    public MyLinkedList() {
        head = new Node(0);    
        size =0;
    }
    
    public int get(int index) {
        if(index<0 || index>= size) return -1;
        Node curr = head;
        for(int i = 0; i < index + 1; ++i) curr = curr.next;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
       addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size) return;
        if(index<0) index = 0;
        size++;
        Node curr = head;
        for(int i = 0; i < index; ++i) curr = curr.next;
        Node newNode = new Node(val);
        newNode.next = curr.next;
        curr.next = newNode; 
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        Node curr = head;
        for(int i = 0; i < index; ++i) curr = curr.next;
        curr.next = curr.next.next;
    }
}
public class Node{
    Node next;
    int val;
    public Node(int v){
        this.val = v;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */