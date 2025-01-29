import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static int[] selected = new int[10];
	public static int cnt = 0;
	public static int n;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		select(0);
		System.out.println(cnt);
	}

	public static void select(int cur) {
		if (cur == n) {
			StringBuilder number = new StringBuilder();
			;
			for (int i = 0; i < n; i++) {
				number.append(selected[i]);
			}

			if (checkNumber(number.toString())) {
				cnt++;
			}

			return;
		}

		for (int i = 1; i <= 4; i++) {
			selected[cur] = i;
			select(cur + 1);
		}
	}

	public static boolean checkNumber(String number) {
		Map<Character, ArrayList<Integer>> map = new HashMap<>();

		map.put('1', new ArrayList<>());
		map.put('2', new ArrayList<>());
		map.put('3', new ArrayList<>());
		map.put('4', new ArrayList<>());

		char beforeNumber = number.charAt(0);
		int cnt = 1;

		for (int i = 1; i < number.length(); i++) {
			char num = number.charAt(i);

			if (num == beforeNumber) {
				cnt++;
			} else {
				map.get(beforeNumber).add(cnt);
				beforeNumber = num;
				cnt = 1;
			}
		}

		map.get(beforeNumber).add(cnt);

		for (int i = 1; i <= 4; i++) {
			char key = (char)('0' + i);
			ArrayList<Integer> list = map.get(key);

			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) % i != 0)
					return false;
			}
		}

		return true;
	}
}