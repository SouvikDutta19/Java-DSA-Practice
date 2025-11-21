import java.util.*;

class Item {
    int weight;
    int value;

    Item(int v, int w) {
        value = v;
        weight = w;
    }
}

public class day143_fractional_knapsack {

    public static double fractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> (b.value / (double) b.weight) >= (a.value / (double) a.weight) ? 1 : -1);

        double totalValue = 0;

        for (Item item : items) {
            if (capacity == 0) break;

            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.value * (capacity / (double) item.weight);
                capacity = 0;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        System.out.println("Maximum Value in Knapsack = " +
                fractionalKnapsack(items, 50));
    }
}
