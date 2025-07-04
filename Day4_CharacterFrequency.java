import java.util.HashMap;
import java.util.Scanner;

public class Day4_CharacterFrequency {

    public static void countFrequency(String str) {
        HashMap<Character, Integer> freq = new HashMap<>();
        str = str.replaceAll("\\s", "").toLowerCase();

        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println("📊 Character Frequencies:");
        for (char key : freq.keySet()) {
            System.out.println("'" + key + "' : " + freq.get(key));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        countFrequency(input);

        sc.close();
    }
}
