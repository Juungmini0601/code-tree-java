import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();
        Machine[] machines = new Machine[n];
        int maxT = 0;
        int minT = 9999;

        for(int i = 0; i < n; i++) {
            int ta = sc.nextInt();
            int tb = sc.nextInt();
            maxT = Math.max(tb, maxT);
            minT = Math.min(ta, minT);

            machines[i] = new Machine(ta, tb);
        }

        int ans = 0;
        for(int i = minT - 1; i <= maxT + 1; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += caclWorks(machines[j], i, c, g, h);
            }
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }

    public static int caclWorks(Machine m, int t, int c, int g, int h) {
        if(t > m.tb) {
            return h;
        } else if (t >= m.ta) {
            return g;
        } else {
            return c;
        }
    }
}

class Machine {
    int ta;
    int tb;

    public Machine(int ta, int tb) {
        this.ta = ta;
        this.tb = tb;
    }
}