import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q28702 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();

		int[] numbers = new int[3];

		if (isNumber(a)) {
			numbers[0] = Integer.parseInt(a);
		}
		if (isNumber(b)) {
			numbers[1] = Integer.parseInt(b);
		}
		if (isNumber(c)) {
			numbers[2] = Integer.parseInt(c);
		}

		int nextNubmer = -1;
		for (int i = 0; i < 3; i++) {
			if (numbers[i] !=0) {
				nextNubmer = numbers[i];
				nextNubmer += (3- i);
				break;
			}
		}

		if (nextNubmer % 3 == 0) {
			System.out.print("Fizz");
		}
		if (nextNubmer % 5 == 0) {
			System.out.print("Buzz");
		}
		if (nextNubmer % 3 != 0 && nextNubmer % 5 != 0) {
			System.out.print(nextNubmer);
		}
	}

	private static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
		}
		catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
