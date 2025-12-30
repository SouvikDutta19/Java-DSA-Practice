class Node {
    int data;
    Node next;
    Node(int d){ data=d; }
}

public class day174_linkedlist_insert_end {
    Node head;

    public void insertEnd(int data){
        Node newNode = new Node(data);
        if(head==null){ head=newNode; return; }

        Node current=head;
        while(current.next!=null)
            current=current.next;
        current.next=newNode;
    }

    public void display(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }

    public static void main(String[] args) {
        day174_linkedlist_insert_end list = new day174_linkedlist_insert_end();
        list.insertEnd(5); list.insertEnd(10); list.insertEnd(15);
        list.display();
    }
}