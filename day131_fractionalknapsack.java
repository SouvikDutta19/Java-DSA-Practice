// day131_fractionalknapsack.java
import java.util.*;

class Item {
    int value, weight;
    Item(int v, int w) { value = v; weight = w; }
}

public class day131_fractionalknapsack {
    static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value/b.weight, (double)a.value/a.weight));
        double totalValue = 0.0;
        for (Item item : items) {
            int curWt = item.weight;
            int curVal = item.value;
            if (capacity - curWt >= 0) {
                capacity -= curWt;
                totalValue += curVal;
            } else {
                double fraction = ((double)capacity / curWt);
                totalValue += (curVal * fraction);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
        int capacity = 50;
        System.out.println("Maximum value in Knapsack = " + getMaxValue(items, capacity));
    }
}
