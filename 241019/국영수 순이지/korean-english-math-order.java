import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for(int i = 0; i < n; i++) {
            students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(students);

        for(int i = 0; i < n; i++) {
            System.out.println(students[i]);
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int kor;
    int eng;
    int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d", this.name, this.kor, this.eng, this.math);
    }

    @Override
    public int compareTo(Student s) {
        if(this.kor != s.kor) {
            return s.kor - this.kor;
        }

        if(this.eng != s.eng) {
            return s.eng - this.eng;
        }

        return s.math - this.math;
    }
}