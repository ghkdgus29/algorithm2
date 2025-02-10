public class Q12_Integer_to_Roman {
	public String intToRoman(int num) {
		int[] ints = new int[13];
		String[] romans = new String[13];

		// M(1000) CM(900) D(500) CD(400) C(100)
		// XC(90) L(50) XL(40) X(10) IX(9) V(5) IV(4) I(1)

		ints[0] = 1000; romans[0] = "M";
		ints[1] = 900; romans[1] = "CM";
		ints[2] = 500; romans[2] = "D";
		ints[3] = 400; romans[3] = "CD";
		ints[4] = 100; romans[4] = "C";

		ints[5] = 90; romans[5] = "XC";
		ints[6] = 50; romans[6] = "L";
		ints[7] = 40; romans[7] = "XL";
		ints[8] = 10; romans[8] = "X";
		ints[9] = 9; romans[9] = "IX";
		ints[10] = 5; romans[10] = "V";
		ints[11] = 4; romans[11] = "IV";
		ints[12] = 1; romans[12] = "I";

		StringBuilder sb = new StringBuilder();
		int i=0;
		while (i < ints.length) {
			if (ints[i] > num) {
				i++;
			} else {
				num -= ints[i];
				sb.append(romans[i]);
			}
		}
		return sb.toString();
	}
}
