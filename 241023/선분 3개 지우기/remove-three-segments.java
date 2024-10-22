import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Line[] lines = new Line[n];

        for(int i = 0; i < n; i++) {
            lines[i] = new Line(sc.nextInt(), sc.nextInt());
        }

        int cnt = 0;
        for(int i = 0 ; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(check(lines, i, j, k)) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean check(Line[] lines, int a, int b, int c) {
        int[] arr = new int[101];

        for(int i = 0; i < lines.length; i++) {
            if(i == a || i == b || i == c) {
                continue;
            }

            Line line = lines[i];
            for(int j = line.start; j <= line.end; j++) {
                arr[j]++;
            }
        }

        for(int i = 0; i <= 100; i++) {
            if(arr[i] >= 2) {
                return false;
            }
        }

        return true;
    }
}

class Line {
    int start;
    int end;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }
}