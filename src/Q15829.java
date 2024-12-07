import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class Q15829 {
	public static void main(String[] args) throws IOException {
		HashMap<Character, Integer> dict = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			dict.put((char)('a' + i), i + 1);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String word = br.readLine();
		BigInteger ans = BigInteger.ZERO;
		for (int i = 0; i < n; i++) {
			BigInteger partialSum = BigInteger.valueOf(31).pow(i).multiply(BigInteger.valueOf(dict.get(word.charAt(i)))).mod(BigInteger.valueOf(1234567891));
			ans = ans.add(partialSum);
		}
		System.out.println(ans.mod(BigInteger.valueOf(1234567891)).longValue());
	}
}
