import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agent[] agents = new Agent[5];

        int minIndex = 0;

        for(int i = 0; i < 5; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            agents[i] = new Agent(name, score);
        }

        for(int i = 1; i < 5; i++) {
            if(agents[minIndex].score > agents[i].score) {
                minIndex = i;
            }
        }

        System.out.println(agents[minIndex]);
    }
}

class Agent {
    String name;
    int score;

    public Agent(String name, int score)  {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}