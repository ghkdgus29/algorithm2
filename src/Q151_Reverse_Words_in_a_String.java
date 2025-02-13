public class Q151_Reverse_Words_in_a_String {
	public String reverseWords(String s) {
		String[] splited = s.trim().split("\\s+");

		for (int i=0; i< splited.length / 2; i++) {
			String tmp = splited[i];
			splited[i] = splited[splited.length - 1 - i];
			splited[splited.length - 1 -i] = tmp;
		}

		return String.join(" ", splited);
	}
}
