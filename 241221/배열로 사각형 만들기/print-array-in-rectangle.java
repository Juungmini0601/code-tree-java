public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];

        for(int col = 0; col < 5; col++) arr[0][col] = 1;
        for(int row = 0; row < 5; row++) arr[row][0] = 1;

        for(int i = 1; i < 5; i++) {
            for(int j = 1; j < 5; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                sb.append(arr[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}