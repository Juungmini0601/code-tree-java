import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 20;
        int[][] arr = new int[n][n];

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Case1. / 방향으로 올라가는 대각선 체크
        Point p1 = Case1(arr, n);
        if(p1 != null) {
            System.out.println(arr[p1.y][p1.x]);
            System.out.println(String.format("%d %d", p1.y, p1.x));
            return;
        }
        Point p2 = Case2(arr, n);
        if(p2 != null) {
            System.out.println(arr[p2.y][p2.x]);
            System.out.println(String.format("%d %d", p2.y, p2.x));
            return;
        }
        Point p3 = Case3(arr, n);
        if(p3 != null) {
            System.out.println(arr[p3.y][p3.x]);
            System.out.println(String.format("%d %d", p3.y, p3.x));
            return;
        }
        Point p4 = Case4(arr, n);
        if(p4 != null) {
            System.out.println(arr[p4.y][p4.x]);
            System.out.println(String.format("%d %d", p4.y, p4.x));
            return;
        }
    }

    // Case1. / 방향으로 올라가는 대각선 체크
    public static Point Case1(int[][] arr, int n) {
        int[] dx = {0 , 1, 2, 3, 4};
        int[] dy = {0, -1 ,-2 ,-3 ,-4};

        for(int y = 1; y < n; y++) {
            for(int x = 1; x < n; x++) {
                Point[] points = new Point[5];
                boolean allPointsInrange = true;

                for(int dir = 0; dir < 5; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(!inRange(nx, ny, n)) {
                        allPointsInrange = false;
                        break;
                    } else {
                        points[dir] = new Point(nx, ny);
                    }
                }
                
                if(allPointsInrange) {
                    int[] colors = new int[5];

                    for(int dir = 0; dir < 5; dir++) {
                        int curX = points[dir].x;
                        int curY = points[dir].y;
                        colors[dir] = arr[curY][curX];
                    }

                    boolean flag = true;
                    for(int i = 1; i < 5; i++) {
                        if(colors[i-1] != colors[i] || colors[i] == 0) {
                            flag = false;
                            break;
                        }
                    }

                    if(flag) {
                        return points[2];
                    }
                }
            }
        }

        return null;
    }

    // Case2. \ 방향으로 내려가는 대각선 체크
    public static Point Case2(int[][] arr, int n) {
        int[] dx = {0, 1, 2, 3, 4};
        int[] dy = {0, 1 ,2 ,3 ,4};

        for(int y = 1; y < n; y++) {
            for(int x = 1; x < n; x++) {
                Point[] points = new Point[5];
                boolean allPointsInrange = true;

                for(int dir = 0; dir < 5; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(!inRange(nx, ny, n)) {
                        allPointsInrange = false;
                        break;
                    } else {
                        points[dir] = new Point(nx, ny);
                    }
                }
                
                if(allPointsInrange) {
                    int[] colors = new int[5];

                    for(int dir = 0; dir < 5; dir++) {
                        int curX = points[dir].x;
                        int curY = points[dir].y;
                        colors[dir] = arr[curY][curX];
                    }

                    boolean flag = true;
                    for(int i = 1; i < 5; i++) {
                        if(colors[i-1] != colors[i] || colors[i] == 0) {
                            flag = false;
                            break;
                        }
                    }

                    if(flag) {
                        return points[2];
                    }
                }
            }
        }

        return null;
    }

    // Case3. 가로방향으로 체크
    public static Point Case3(int[][] arr, int n) {
        int[] dx = {0, 1, 2, 3, 4};
        int[] dy = {0, 0 ,0 ,0 ,0};

        for(int y = 1; y < n; y++) {
            for(int x = 1; x < n; x++) {
                Point[] points = new Point[5];
                boolean allPointsInrange = true;

                for(int dir = 0; dir < 5; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(!inRange(nx, ny, n)) {
                        allPointsInrange = false;
                        break;
                    } else {
                        points[dir] = new Point(nx, ny);
                    }
                }
                
                if(allPointsInrange) {
                    int[] colors = new int[5];

                    for(int dir = 0; dir < 5; dir++) {
                        int curX = points[dir].x;
                        int curY = points[dir].y;
                        colors[dir] = arr[curY][curX];
                    }

                    boolean flag = true;
                    for(int i = 1; i < 5; i++) {
                        if(colors[i-1] != colors[i] || colors[i] == 0) {
                            flag = false;
                            break;
                        }
                    }

                    if(flag) {
                        return points[2];
                    }
                }
            }
        }

        return null;
    }

    // Case4. 세로방향으로 체크
    public static Point Case4(int[][] arr, int n) {
        int[] dx = {0, 0, 0, 0, 0};
        int[] dy = {0, 1 ,2 ,3 ,4};

        for(int y = 1; y < n; y++) {
            for(int x = 1; x < n; x++) {
                Point[] points = new Point[5];
                boolean allPointsInrange = true;

                for(int dir = 0; dir < 5; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if(!inRange(nx, ny, n)) {
                        allPointsInrange = false;
                        break;
                    } else {
                        points[dir] = new Point(nx, ny);
                    }
                }
                
                if(allPointsInrange) {
                    int[] colors = new int[5];

                    for(int dir = 0; dir < 5; dir++) {
                        int curX = points[dir].x;
                        int curY = points[dir].y;
                        colors[dir] = arr[curY][curX];
                    }

                    boolean flag = true;
                    for(int i = 1; i < 5; i++) {
                        if(colors[i-1] != colors[i] || colors[i] == 0) {
                            flag = false;
                            break;
                        }
                    }

                    if(flag) {
                        return points[2];
                    }
                }
            }
        }

        return null;
    }

    public static boolean inRange(int x, int y, int n) {
        return (1 <= x && x < n) && (1 <= y && y < n);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}