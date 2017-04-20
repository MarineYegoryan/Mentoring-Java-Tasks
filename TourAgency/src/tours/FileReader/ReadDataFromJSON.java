package tours.FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import tours.Exceptions.FileConfigurationException;

public class ReadDataFromJSON implements ReadFileInterface {

	@Override
	public HashMap<String, ArrayList<String>> readDataFromFile() {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		HashMap<String, ArrayList<String>> inputValues = new HashMap<String, ArrayList<String>>();
		ArrayList<String> arraylist = new ArrayList<String>();
		try {

			// Reading the String
			Object object = parser
					.parse(new FileReader("../TourAgency/src/tours/FileReader/FileSources/TourAvailabilityDB.JSON"));

			jsonObject = (JSONObject) object;

			// check that start and end date are not null or invalid formatted
			
			for (int i = 0; i < 4;  i = i + 2) {
				JSONArray meeting = (JSONArray) jsonObject.get("Meeting");
				String startDate = meeting.get(i).toString();
				String endDate = meeting.get(i+1).toString();
				String datePattern = "\\d{2}/\\d{2}/\\d{4}";
				if (startDate.matches(datePattern) && endDate.matches(datePattern)) {
					arraylist.add(startDate);
					arraylist.add(endDate);	
				} else {
					inputValues = null;
					throw new FileConfigurationException("Missing or incorrect value or key in JSON file");
				}
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		inputValues.put("meeting", arraylist);
		return inputValues;
	}
}
