package tours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tours.TourProperties.AccomodationType;
import tours.meeting.Meeting;
import tours.meeting.MeetingType;

public class BusinessTour extends Tour {

	private Map<MeetingType, ArrayList<Meeting>> meetingMap = new HashMap<MeetingType, ArrayList<Meeting>>();

	public void addMeeting(Meeting meeting) {
		MeetingType meetingType = meeting.getMeetingType();
		ArrayList<Meeting> meetingList;

		if (meetingMap.containsKey(meetingType)) {
			meetingList = meetingMap.get(meetingType);

		} else {
			meetingList = new ArrayList<Meeting>();
			meetingMap.put(meetingType, meetingList);
		}
		meetingList.add(meeting);
	}

	public void addMeetings(ArrayList<Meeting> meetingList) {
		int listSize = meetingList.size();

		for (int i = 0; i < listSize; i++) {
			Meeting meeting = meetingList.get(i);
			addMeeting(meeting);
		}
	}

	@Override
	public double calculateTourPrice() {
		double price = 0;
		AccomodationType accomodation = this.getAccomodation();

		for (MeetingType mapKey : meetingMap.keySet()) {
			int meetingTypeSize = meetingMap.get(mapKey).size();

			if (meetingTypeSize > 0) {
				Meeting meeting = meetingMap.get(mapKey).get(0);
				if (accomodation == AccomodationType.Hotel) {
					price = price + (meetingTypeSize * meeting.calculateMeetingsPrice() + 1000);
				} else if (accomodation == AccomodationType.Appartament) {
					price = price + (meetingTypeSize * meeting.calculateMeetingsPrice() + 500);
				}
			}
		}
		return price;
	}

}
