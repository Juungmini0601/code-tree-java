import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static int[][] temp = new int[4][4];
    public static int[][] grid = new int[4][4];
    public static Map<String, Integer> map = new HashMap<>();   
    public static String dir;
    public static final int EMPTY = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        input();

        int rotateCount = map.get(dir);
        for (int i = 0; i < rotateCount; i++) {
            rotate();
        }

        shift();

        for (int i = 0; i < 4 - rotateCount; i++) {
            rotate();
        }

        printGrid();
    }

    public static void shift() {
        temp = new int[4][4];

        for(int col = 0; col < 4; col++) {
            int tempRow = 3;

            for(int row = 3; row >= 0; row--) {
                if (grid[row][col] != EMPTY) {
                    temp[tempRow][col] = grid[row][col];
                    tempRow--;
                }
            }
        }

        // 합쳐 주기
        for(int col = 0; col < 4; col++) {
            for(int row = 3; row > 0; row--) {
                if (temp[row][col] != EMPTY && temp[row - 1][col] == temp[row][col]) {
                    temp[row][col] += temp[row - 1][col];
                    temp[row - 1][col] = 0;
                } else if (temp[row][col] == EMPTY) {
                    temp[row][col] = temp[row - 1][col];
                    temp[row - 1][col] = EMPTY;
                }
            }
        }

        for(int row = 0; row < 4; row++) {
            for(int col = 0; col < 4; col++) {
                grid[row][col] = temp[row][col];
            }
        }
    }

    public static void rotate() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = grid[3 - j][i];
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = temp[i][j];
            }
        }
    }

    public static void printGrid() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void input() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        map.put("R", 1);
        map.put("L", 3);
        map.put("U", 2);
        map.put("D", 0);
        
        dir = sc.next();
    }
}
