public class day163_circular_queue {

    static class CircularQueue {
        int[] arr;
        int front, rear, size, capacity;

        CircularQueue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        boolean enqueue(int val) {
            if (size == capacity) return false;
            rear = (rear + 1) % capacity;
            arr[rear] = val;
            size++;
            return true;
        }

        boolean dequeue() {
            if (size == 0) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        int front() {
            return size == 0 ? -1 : arr[front];
        }

        int rear() {
            return size == 0 ? -1 : arr[rear];
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.dequeue();
        q.enqueue(40);

        System.out.println("Front: " + q.front());
        System.out.println("Rear: " + q.rear());
    }
}