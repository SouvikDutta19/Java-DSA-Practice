import java.util.*;

class Student {
    String name;
    int[] marks;
    
    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double getAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Average: " + getAverage());
        System.out.println("Grade: " + getGrade());
        System.out.println("---------------------");
    }
}

public class Day18_StudentGradeManagementSystem {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice", new int[]{85, 90, 78}),
            new Student("Bob", new int[]{70, 65, 75}),
            new Student("Charlie", new int[]{95, 88, 92})
        };

        for (Student s : students) {
            s.displayInfo();
        }
    }
}
