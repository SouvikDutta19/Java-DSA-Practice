import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 5;

    public synchronized void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            while (queue.size() == capacity) {
                wait();
            }

            System.out.println("Produced: " + value);
            queue.add(value++);
            notify();
            Thread.sleep(500);
        }
    }

    public synchronized void consume() throws InterruptedException {
        while (true) {
            while (queue.isEmpty()) {
                wait();
            }

            int value = queue.poll();
            System.out.println("Consumed: " + value);
            notify();
            Thread.sleep(500);
        }
    }
}

public class day159_producer_consumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            try {
                buffer.produce();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        producer.start();
        consumer.start();
    }
}