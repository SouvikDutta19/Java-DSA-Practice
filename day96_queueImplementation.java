public class day96_queueimplementation {
    private int maxSize, front, rear, size;
    private int[] queueArray;

    public day96_queueimplementation(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        this.size = 0;
    }

    public void enqueue(int item) {
        if (size == maxSize) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = item;
        size++;
        System.out.println(item + " enqueued");
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int item = queueArray[front];
        front = (front + 1) % maxSize;
        size--;
        return item;
    }

    public static void main(String[] args) {
        day96_queueimplementation q = new day96_queueimplementation(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Dequeued: " + q.dequeue());
    }
}
