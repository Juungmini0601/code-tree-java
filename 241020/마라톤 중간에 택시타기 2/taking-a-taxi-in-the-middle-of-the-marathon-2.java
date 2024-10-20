import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Position[] positions = new Position[n];
        
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            positions[i] = new Position(x, y);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i < n-1; i++) {
            Position before = positions[0];
            int sum = 0;

            for(int j = 1; j < n; j++) {
                if(j == i) continue;

                int distance = Math.abs(positions[j].x - before.x) + Math.abs(positions[j].y - before.y);
                sum += distance;
                before = positions[j];
            }

            ans = Math.min(ans, sum);
        }

        System.out.println(ans);
    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}