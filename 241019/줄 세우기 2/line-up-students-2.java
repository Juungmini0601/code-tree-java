import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            students[i] = new Student(i + 1, h, w);
        }

        Arrays.sort(students);

        for(int i = 0; i < n; i++) {
            System.out.println(students[i]);
        }
    }
}

class Student implements Comparable<Student> {
    int index;
    int height;
    int weight;

    public Student(int index, int height, int weight) {
        this.index = index;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student s) {
        if(this.height != s.height) {
            return this.height - s.height;
        }

        if(this.weight != s.weight) {
            return s.weight - this.weight;
        }

        return this.index - s.index;
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", this.height, this.weight, this.index);
    }
}