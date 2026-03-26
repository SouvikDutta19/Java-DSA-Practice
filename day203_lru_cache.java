import java.util.*;

public class day203_lru_cache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    class DoublyLinkedList {
        Node head, tail;

        DoublyLinkedList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        Node removeLast(){
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    Map<Integer, Node> map;
    DoublyLinkedList dll;
    int capacity;

    public day203_lru_cache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new DoublyLinkedList();
    }

    public int get(int key){

        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        dll.remove(node);
        dll.add(node);

        return node.value;
    }

    public void put(int key, int value){

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            dll.remove(node);
            dll.add(node);
        }
        else{

            if(map.size() == capacity){
                Node last = dll.removeLast();
                map.remove(last.key);
            }

            Node node = new Node(key,value);
            dll.add(node);
            map.put(key,node);
        }
    }
}