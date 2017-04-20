package tours;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import tours.Exceptions.DateAvailabilityException;
import tours.Exceptions.FileConfigurationException;
import tours.FileReader.ReadDataFromJSON;
import tours.FileReader.ReadDataFromTXT;
import tours.TourProperties.AccomodationType;
import tours.TourProperties.LocationType;
import tours.TourProperties.TourType;
import tours.excursion.Excursion;
import tours.meeting.Meeting;
import tours.meeting.MeetingType;

public class TourTest {

	public static void main(String[] args) {

		double price = 0;
		BusinessTour tour = new BusinessTour();
		RestTour restTour = new RestTour();
		Excursion excursion = new Excursion();
		ResultPrinting result = new ResultPrinting();
		WriteResultInFile writeResult = new WriteResultInFile();
		excursion.setAvailable(true);
		Meeting meeting = new Meeting();

		try {

			ReadDataFromJSON readJSONfile = new ReadDataFromJSON();
			HashMap<String, ArrayList<String>> getMapValueFromJSON = readJSONfile.readDataFromFile();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			
			ReadDataFromTXT readTXTfile = new ReadDataFromTXT();
			HashMap<String, ArrayList<String>> getMapValueFromTXT = readTXTfile.readDataFromFile();
			

			// convert String to LocalDate
			if (getMapValueFromJSON != null) {

				// get values from object
				for (int i=0; i < 4; i = i + 2) {
					ArrayList<String> key1 = getMapValueFromJSON.get("meeting");
					ArrayList<String> key2 = getMapValueFromJSON.get("meeting");
					String getStartDate = key1.get(i).toString();
					String getEndDate = key2.get(i+1).toString();					
					LocalDate getMeetingStartDate = LocalDate.parse(getStartDate, formatter);
					LocalDate getMeetingEndDate = LocalDate.parse(getEndDate, formatter);
					
					// convert String to LocalDate
					if (readTXTfile.readDataFromFile() != null) {

					
						ArrayList<String> getStartDate_TXT = getMapValueFromTXT.get("meeting");
						DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d/MM/yyyy");
						String strTourDate = getStartDate_TXT.get(0);
						String edTourDate = getStartDate_TXT.get(1);
						LocalDate getTourStartDate = LocalDate.parse(strTourDate, formatter2);
						LocalDate getTourEndDate = LocalDate.parse(edTourDate, formatter2);
					
						// Initialize Tour - set all necessary parameters to make a tour search
						tour.setTourType(TourType.BUSINESS);
						TourType tourType = tour.getTourType();
						tour.setStartDate(getTourStartDate);
						tour.setEndDate(getTourEndDate);
						tour.setLocationType(LocationType.Yerevan);
						tour.setAccomodation(AccomodationType.Hotel);					
	
						// Initialize Second Meeting - Set meeting parameters
						meeting.setStartDate(getMeetingStartDate);
						meeting.setEndDate(getMeetingEndDate);
						meeting.setMeetingType(MeetingType.HRMEETING);
						meeting.setPeopleCount(5);
						meeting.setLocationType(LocationType.Yerevan);
						tour.addMeeting(meeting);
	
						try {
							tour.Available();
							if (tourType == TourType.BUSINESS) {
								meeting.AvailableMeeting();
								price = tour.calculateTourPrice();
							}
							if (tourType == TourType.REST) {
								excursion.AvailableExcursion();
								price = restTour.calculateTourPrice();
							}
						} catch (DateAvailabilityException c) {
							System.err.println("DateAvailabilityException: " + c.getMessage());
						}
						if (i == 2) {
							result.writeResult(price, getTourStartDate, getTourEndDate, LocationType.Yerevan,
									AccomodationType.Hotel);
							writeResult.printOutResults(price);
						}
					}					
				}		
			}			
		} catch (FileConfigurationException c) {
			System.err.println("FileConfigurationException: " + c.getMessage());
		}
		
	}
}
