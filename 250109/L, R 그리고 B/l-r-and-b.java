import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[10][10];
        
        int bx = 0, by = 0;
        int lx = 0, ly = 0;
        int rx = 0, ry = 0;

        // 입력 받기
        for (int i = 0; i < 10; i++) {
            String line = sc.next();
            for (int j = 0; j < 10; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'B') {
                    bx = j;
                    by = i;
                } else if (arr[i][j] == 'L') {
                    lx = j;
                    ly = i;
                } else if (arr[i][j] == 'R') {
                    rx = j;
                    ry = i;
                }
            }
        }

        // 거리 계산
        int r = Math.abs(bx - lx) + Math.abs(by - ly) - 1;

        if ((ly < ry && ry < by || by < ry && ry < ly) && (lx == rx && rx == bx)) {
            System.out.println(r + 2);
        } else if ((lx < rx && rx < bx || bx < rx && rx < lx) && (ly == ry && ry == by)) {
            System.out.println(r + 2);
        } else {
            System.out.println(r);
        }
        
        sc.close();
    }
}
