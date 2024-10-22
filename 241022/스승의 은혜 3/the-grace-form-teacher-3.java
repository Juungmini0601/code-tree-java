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
            // i번째 선물을 반값으로 바꾼 배열을 만든다.
            Student[] arr = new Student[n];
            for(int j = 0; j < n; j++) {
                int price = students[j].price;
                int ship = students[j].ship;
                
                if(j == i) {
                    price /= 2;
                }

                arr[j] = new Student(price, ship);
            }
            Arrays.sort(arr);
            
            int sum = 0;
            int temp = 0;
            for(int j = 0; j < n; j++) {
                int nextSum = sum + arr[j].total;
                if(nextSum > b) {
                    break;
                }
                sum = nextSum;
                temp++;
            }

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

    @Override
    public String toString() {
        return this.total + "";
    }
}