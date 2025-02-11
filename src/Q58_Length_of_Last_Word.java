public class Q58_Length_of_Last_Word {
	public int lengthOfLastWord(String s) {
		String[] splited = s.split("\\s+");
		return splited[splited.length - 1].length();
	}
}
