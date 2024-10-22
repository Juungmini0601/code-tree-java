import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Line[] lines = new Line[n];

        for(int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            Line line = new Line(x1, x2);
            lines[i] = line;
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            Line cur = lines[i];

            for(int j = 0; j < n; j++) {
                if(j == i) {
                    continue;
                }

                Line target = lines[j];
                if(cur.check(target)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

class Line {
    int x1;
    int x2;

    public Line(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public boolean check(Line line) {
        if(line.x2 > this.x2) {
            return line.x1 < this.x1;
        } else {
            return line.x1 > this.x1;
        }
    }
}