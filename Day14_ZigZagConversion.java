public class Day14_ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sb[i] = new StringBuilder();

        int index = 0, step = 1;

        for (char c : s.toCharArray()) {
            sb[index].append(c);
            if (index == 0) step = 1;
            else if (index == numRows - 1) step = -1;
            index += step;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : sb) result.append(row);
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        int rows = 3;
        System.out.println("↕️ ZigZag Conversion: " + convert(input, rows));
    }
}
