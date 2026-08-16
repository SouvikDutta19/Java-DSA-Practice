import java.util.*;

public class day217_daily_temperatures {

    public static int[] dailyTemperatures(
            int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack =
                new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && temperatures[i]
                    > temperatures[stack.peek()]) {

                int previous = stack.pop();

                result[previous] =
                        i - previous;
            }

            stack.push(i);
        }

        return result;
    }
}