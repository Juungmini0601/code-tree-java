import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 위 오른쪽 아래 왼쪽
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[] cur = {0, 0};

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            String dir = sc.next();
            int distance = sc.nextInt();

            switch(dir) {
                case "N":
                    cur[0] = cur[0] + dy[0] * distance;
                    break;
                case "E":
                    cur[1] = cur[1] + dx[1] * distance;
                    break;
                case "S":
                    cur[0] = cur[0] + dy[2] * distance;
                    break;
                case "W":
                    cur[1] = cur[1] + dx[3] * distance;
                    break;
            }
            
        }

        System.out.println(String.format("%d %d", cur[1], cur[0]));
    }
}