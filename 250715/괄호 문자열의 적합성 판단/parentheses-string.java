import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static String str;

	public static void main(String[] args) {
		str = sc.nextLine();
		ArrayDeque<Character> stack = new ArrayDeque<>();
		
		for(char c: str.toCharArray()) {
			if (c == '(') {
				stack.addLast(c);
				continue;
			}
			
			if (stack.isEmpty()) {
				System.out.println("No");
				return;
			}
			
			stack.removeLast();
		}
		
		if (stack.isEmpty()) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
