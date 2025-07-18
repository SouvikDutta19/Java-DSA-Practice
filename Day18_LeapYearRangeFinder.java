public class Day18_LeapYearRangeFinder {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        int start = 2000, end = 2050;

        System.out.println("Leap Years between " + start + " and " + end + ":");
        for (int year = start; year <= end; year++) {
            if (isLeapYear(year)) {
                System.out.print(year + " ");
            }
        }
    }
}
