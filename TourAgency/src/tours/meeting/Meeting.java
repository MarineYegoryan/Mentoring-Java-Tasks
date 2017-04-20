package tours.meeting;

import java.time.LocalDate;
import java.time.Period;
import tours.Exceptions.DateAvailabilityException;
import tours.TourProperties.LocationType;

public class Meeting {

	private LocalDate startDate;
	private LocalDate endDate;
	private int peopleCount;
	private MeetingType meetingType;
	private LocationType locationType;

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

	public LocationType getLocationType() {
		return locationType;
	}

	public void setMeetingType(MeetingType meetingType) {
		this.meetingType = meetingType;
	}

	public MeetingType getMeetingType() {
		return meetingType;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}
	
	// Calculate meeting duration according start and end date
	public int calculateDuration() {
		Period period = Period.between(startDate, endDate);
		int days = period.getDays();
		int months = period.getMonths();
		int year = period.getYears();
		int duration = 365 * year + 30 * months + days;
		return duration;
	}

	// check that there is available meeting
	public void AvailableMeeting() {
		LocalDate currentDate = LocalDate.now();
		if (startDate.isBefore(currentDate)) {
			throw new DateAvailabilityException("There is no available meeting per your requsted date");
		} else if (startDate.isAfter(endDate)) {
			throw new DateAvailabilityException("Please check your dates, requested time period is not proper");
		} else if (startDate.isBefore(getStartDate())) {
			throw new DateAvailabilityException("There is no available meeting per your requsted date");
		}
	}

	// calculate available meetings price
	public double calculateMeetingsPrice() {
		double price = 0;
		int duration = calculateDuration();

		switch (locationType) {

		case Yerevan:
			switch (meetingType) {
			case ITMEETING:
				return price = duration * (peopleCount * 100);
			case HRMEETING:
				return price = duration * (peopleCount * 120);
			default:
				break;
			}
		case Moscow:
			switch (meetingType) {
			case ITMEETING:
				return price = duration * (peopleCount * 130);
			case HRMEETING:
				return price = duration * (peopleCount * 140);
			default:
				break;
			}
		default:
			break;
		}
		return price;
	}

}
