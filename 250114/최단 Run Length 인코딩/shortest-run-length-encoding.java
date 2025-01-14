import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static String a;

	public static void main(String[] args) throws Exception {
		a = br.readLine();
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < a.length(); i++) {
			ans = Math.min(ans, encoding(a).length());
			a = a.charAt(a.length()-1) + a.substring(0, a.length()-1);
		}

		System.out.println(ans);
	}

	public static String encoding(String s) {
		String result = s.charAt(0) + "";
		int cnt = 1;

		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) != s.charAt(i-1)) {
				result += cnt;
				result += s.charAt(i);
				cnt = 1;
			} else {
				cnt++;
			}
		}

		return result + cnt;
	}
}

