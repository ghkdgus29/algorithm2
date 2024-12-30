import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q17219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int totalCount = Integer.parseInt(st.nextToken());
		int findCount = Integer.parseInt(st.nextToken());
		HashMap<String, String> memo = new HashMap<>();

		for (int i = 0; i < totalCount; i++) {
			String[] s = br.readLine().split(" ");
			memo.put(s[0], s[1]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < findCount; i++) {
			String site = br.readLine();
			sb.append(memo.get(site) + "\n");
		}

		System.out.print(sb);
	}
}
