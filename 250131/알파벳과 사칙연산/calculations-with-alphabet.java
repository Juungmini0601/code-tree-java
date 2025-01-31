import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static String expression;
	public static int[] selected = new int[6];
	public static int ans = 0;
	public static List<Character> numbers = new ArrayList<>();
	public static List<Character> operators = new ArrayList<>();

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		input();
		select(0);
		System.out.println(ans);
	}

	public static void select(int cur) {
		if (cur == 6) {
			int temp = selected[numbers.get(0) - 'a'];

			for (int i = 1; i < numbers.size(); i++) {
				char operator = operators.get(i - 1);
				int num = selected[numbers.get(i) - 'a'];

				if (operator == '+') {
					temp += num;
				} else if (operator == '-') {
					temp -= num;
				} else if (operator == '*') {
					temp *= num;
				}
			}

			ans = Math.max(ans, temp);

			return;
		}

		for (int i = 1; i <= 4; i++) {
			selected[cur] = i;
			select(cur + 1);
		}
	}

	public static void input() throws Exception {
		expression = br.readLine();

		for (char c : expression.toCharArray()) {
			if (c >= 'a' && c <= 'f') {
				numbers.add(c);
			} else {
				operators.add(c);
			}
		}
	}
}