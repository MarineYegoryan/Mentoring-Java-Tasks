package tours.FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import tours.Exceptions.FileConfigurationException;

public class ReadDataFromTXT implements ReadFileInterface {

	@Override
	public HashMap<String, ArrayList<String>> readDataFromFile() {

		String strFile = "../TourAgency/src/tours/FileReader/FileSources/TourInputs.txt";
		HashMap<String, ArrayList<String>> inputValues = new HashMap<String, ArrayList<String>>();
		ArrayList<String> arraylist = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(strFile))) {

			String strLine;
			StringTokenizer st = null;
			int rowNumber = 0, columnNumber = 0;
			String datePattern = "\\d{2}/\\d{2}/\\d{4}";

			while ((strLine = br.readLine()) != null) {

				rowNumber++;
				st = new StringTokenizer(strLine, ",");

				while (st.hasMoreTokens()) {

					columnNumber++;
					String text = st.nextToken();
					Boolean isDate1 = text.matches(datePattern);

					if (rowNumber == 1 && columnNumber == 1) {
						if (text != null && isDate1 != false) {
							arraylist.add(text);
						} else {
							inputValues = null;
							throw new FileConfigurationException("Missing or incorrect value or key in JSON file");
						}
					} else if (rowNumber == 1 && columnNumber == 2) {
						if (text != null && isDate1 != false) {
							arraylist.add(text);
							
						}
						else {
							inputValues = null;
							throw new FileConfigurationException("Missing or incorrect value or key in JSON file");
						}
					}
					inputValues.put("meeting", arraylist);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		return inputValues;
	}

}
