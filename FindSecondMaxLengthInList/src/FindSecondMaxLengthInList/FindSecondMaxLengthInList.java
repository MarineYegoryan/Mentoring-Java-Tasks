package FindSecondMaxLengthInList;

import java.util.Arrays;

public class FindSecondMaxLengthInList {

	public static void main(String[] args) {

		String str[] = new String[] { "ab", "fogs", "dogs", "cars", "ab", "ahss" };
		System.out.println(Arrays.toString(str));

		String strMax = null;

		int max = 0;
		int secondMax = 1;

		for (int i = 0; i < str.length; i++) {
			if (str[i].length() >= max) {
				if (str[i].length() != max) {
					if (secondMax != 2) {
						strMax = str[i];
					}
				}
				if (str[i].length() == max) {
					secondMax++;
					if (secondMax == 2) {
						strMax = str[i];
					}
				}
				max = str[i].length();
			}
		}
		System.out.println("Max length = " + max);
		if (secondMax == 1)
			System.out.println("There is only one string with max length and it is '" + strMax + "'");
		else
			System.out.println("Second Max length string in this array list is '" + strMax);
	}

}
