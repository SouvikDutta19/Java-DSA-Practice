import java.util.PriorityQueue;

public class Day15_PriorityQueueSimulation {

    static class Job implements Comparable<Job> {
        String name;
        int priority;

        Job(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Job other) {
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return name + " (Priority: " + priority + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Job> queue = new PriorityQueue<>();

        queue.add(new Job("Fix bug", 2));
        queue.add(new Job("Write tests", 3));
        queue.add(new Job("Deploy", 1));
        queue.add(new Job("Design module", 4));

        System.out.println("🧾 Executing Jobs by Priority:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
