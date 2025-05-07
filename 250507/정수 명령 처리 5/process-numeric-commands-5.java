import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String command = sc.next();
			if (command.equals("push_back")) {
				int a = sc.nextInt();
				list.add(a);
			} else if (command.equals("pop_back")) {
				list.remove(list.size() - 1);
			} else if (command.equals("size")) {
				System.out.println(list.size());
			} else {
				int k = sc.nextInt();
				System.out.println(list.get(k - 1));
			}
		}
	}
}