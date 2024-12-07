import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q18110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int exclude = Math.round(cnt  * ((float)15 /100));

		int[] difficulty = new int[cnt];

		for (int i = 0; i < cnt; i++) {
			difficulty[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(difficulty);
		int sum = 0;
		for (int i = exclude; i < cnt - exclude; i++) {
			sum += difficulty[i];
		}
		System.out.println(Math.round((float)sum / (cnt - exclude * 2)));
	}
}
