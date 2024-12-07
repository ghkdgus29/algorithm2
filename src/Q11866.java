import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int step = Integer.parseInt(st.nextToken()) - 1;

		List<Integer> a = new ArrayList<>();

		for (int i = 1; i <= size; i++) {
			a.add(i);
		}
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (!a.isEmpty()) {
			idx = (idx + step) % a.size();
			sb.append(a.remove(idx) + ", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.print(sb);
	}
}
