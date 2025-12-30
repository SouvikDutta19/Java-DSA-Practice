class StackNode {
    int data;
    StackNode next;
    StackNode(int d) { data=d; }
}

public class day174_stack_linkedlist {
    StackNode top;

    public void push(int x){
        StackNode newNode = new StackNode(x);
        newNode.next = top;
        top = newNode;
    }

    public void pop(){
        if(top==null){ System.out.println("Empty Stack"); return; }
        System.out.println("Popped: "+top.data);
        top=top.next;
    }

    public static void main(String[] args){
        day174_stack_linkedlist st=new day174_stack_linkedlist();
        st.push(5); st.push(10); st.pop();
    }
}