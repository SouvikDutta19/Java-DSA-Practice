import java.util.*;

public class day202_lfu_cache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLList {
        Node head, tail;
        int size;

        DLList(){
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
            size++;
        }

        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast(){
            if(size > 0){
                Node last = tail.prev;
                remove(last);
                return last;
            }
            return null;
        }
    }

    Map<Integer, Node> map;
    Map<Integer, DLList> freqMap;
    int capacity, minFreq;

    public day202_lfu_cache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key){
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        update(node);
        return node.value;
    }

    public void put(int key, int value){

        if(capacity == 0) return;

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            update(node);
        }
        else{

            if(map.size() == capacity){
                DLList minList = freqMap.get(minFreq);
                Node removed = minList.removeLast();
                map.remove(removed.key);
            }

            Node node = new Node(key,value);
            minFreq = 1;

            freqMap.putIfAbsent(1,new DLList());
            freqMap.get(1).add(node);

            map.put(key,node);
        }
    }

    void update(Node node){

        int freq = node.freq;
        DLList list = freqMap.get(freq);
        list.remove(node);

        if(freq == minFreq && list.size == 0)
            minFreq++;

        node.freq++;

        freqMap.putIfAbsent(node.freq,new DLList());
        freqMap.get(node.freq).add(node);
    }
}