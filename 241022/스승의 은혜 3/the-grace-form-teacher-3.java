import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        Student[] students = new Student[n];

        for(int i = 0; i < n; i++) {
            students[i] = new Student(sc.nextInt(), sc.nextInt());
        }
        
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            // i번째 선물을 반값으로 바꾼다.
            students[i].discount();
            Arrays.sort(students);
            int sum = 0;
            int temp = 0;
            for(int j = 0; j < n; j++) {
                int nextSum = sum + students[j].total;
                if(nextSum > b) {
                    break;
                }
                sum = nextSum;
                temp++;
            }

            students[i].restore();
            cnt = Math.max(cnt, temp);
        }

        System.out.println(cnt);
    }
}

class Student implements Comparable<Student> {
    int price;
    int ship;
    int total;

    public Student(int price, int ship) {
        this.price = price;
        this.ship = ship;
        this.total = price + ship;
    }

    public void discount() {
        this.price /= 2;
        this.total = this.price + this.ship;
    }

    public void restore() {
        this.price *= 2;
        this.total = this.price + this.ship;
    }

    @Override
    public int compareTo(Student s) {
        return this.total - s.total;
    }
}