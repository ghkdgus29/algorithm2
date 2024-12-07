import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q30802 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int participantCount = Integer.parseInt(br.readLine());
		int[] tshirtCounts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tshirtBundle = Integer.parseInt(st.nextToken());
		int penBundle = Integer.parseInt(st.nextToken());

		int tshirtBundleCount = 0;
		for (int tshirtCount : tshirtCounts) {
			tshirtBundleCount += tshirtCount / tshirtBundle + (tshirtCount % tshirtBundle == 0 ? 0 : 1);
		}

		System.out.println(tshirtBundleCount);
		System.out.printf("%d %d\n", participantCount / penBundle, participantCount % penBundle);
	}
}
