import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for(int i = 0; i < n; i++) {
            students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(students);
        for(int i = 0; i < n; i++) {
            System.out.println(students[i]);
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int height;
    int weight;

    public Student(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student s) {
        if(this.height != s.height) {
            return this.height - s.height;
        }

        return s.weight - this.weight;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.height, this.weight);
    }
}