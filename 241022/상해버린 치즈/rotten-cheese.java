import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int s = sc.nextInt();
        // 상한 치즈 후보를 저장할 배열
        int[] cheese = new int[m+1];
        EatInfo[] eatInfos = new EatInfo[d];
        SickInfo[] scikInfos = new SickInfo[s];
        // 먹은 기록을 전부 입력 받는다.
        for(int i = 0; i < d; i++) {
            eatInfos[i] = new EatInfo(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        // 아픈 기록을 전부 입력 받는다.
        for(int i = 0; i < s; i++) {
            scikInfos[i] = new SickInfo(sc.nextInt(), sc.nextInt());
        }
        // 아픈 기록을 전부 뒤지면서 상한 치즈가 될 수 있는 후보를 찾는다.
        for(int i = 0; i < s; i++) {
            int sickTime = scikInfos[i].time;
            int person = scikInfos[i].person;
            // System.out.println(String.format("%d번 사람이 먹은 치즈 중 상한 치즈 후보 찾기", person));
            // 먹은 기록을 뒤지면서 아픈시간 이전에 먹은 치즈를 찾는다.
            for(int j = 0; j < d; j++) {
                EatInfo eatInfo = eatInfos[j];
                // 먹은 사람이 다르면 패스한다.
                if(eatInfo.person != person) {
                    continue;
                }

                if(eatInfo.time < sickTime) {
                    // System.out.println(String.format("  %d번 치즈는 상한 가능성이 있음", eatInfo.cheese));
                    cheese[eatInfo.cheese]++;
                }
            }
        }

        int cnt = 0;

        for(int i = 1; i <= m; i++) {
            if(cheese[i] < scikInfos.length) {
                continue;
            }
            
            // System.out.println(String.format("상한치즈 후보 %d번", i));
            // i번 치즈를 먹은 사람의 수를 센다.
            int temp = 0;
            boolean[] countedPerson = new boolean[n+1];
            for(int j = 0; j < d; j++) {
                EatInfo eatInfo = eatInfos[j];
                // 약을 주지 않았는데 치즈를 먹은 사람의 수를 센다.
                if(eatInfo.cheese == i && !countedPerson[eatInfo.person]) {
                    temp++;
                    countedPerson[eatInfo.person] = true;
                }
            }
            cnt = Math.max(cnt, temp);
        }

        System.out.println(cnt);
    }
}

class EatInfo {
    int person;
    int cheese;
    int time;

    public EatInfo(int person, int cheese, int time) {
        this.person = person;
        this.cheese = cheese;
        this.time = time;
    }
}

class SickInfo {
    int person;
    int time;

    public SickInfo(int person, int time) {
        this.person = person;
        this.time = time;
    }
}