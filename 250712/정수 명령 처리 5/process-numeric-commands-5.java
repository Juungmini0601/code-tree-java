import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int n;
	public static Scanner scanner = new Scanner(System.in);
	public static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		n = scanner.nextInt();

		for(int i = 0; i < n; i++) {
			String command = scanner.next();
			if (command.equalsIgnoreCase("push_back")) {
				int a = scanner.nextInt();
				list.add(a);
			} else if (command.equalsIgnoreCase("get")) {
				int k = scanner.nextInt();
				System.out.println(list.get(k-1));
			} else if (command.equalsIgnoreCase("size")) {
				System.out.println(list.size());
			} else {
				list.remove(list.size() - 1);
			}
		}
	}
}
