import java.util.HashMap;

public class Day14_ConvertRomanToInteger {

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10);
        map.put('L', 50); map.put('C', 100); map.put('D', 500);
        map.put('M', 1000);

        int total = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            total += (curr < prev) ? -curr : curr;
            prev = curr;
        }

        return total;
    }

    public static void main(String[] args) {
        String roman = "MCMXCIV";
        System.out.println("🔢 Integer from Roman '" + roman + "' is: " + romanToInt(roman));
    }
}
