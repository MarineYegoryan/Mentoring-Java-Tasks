package tours;

import java.time.LocalDate;
import tours.Exceptions.DateAvailabilityException;
import tours.TourProperties.AccomodationType;
import tours.TourProperties.LocationType;
import tours.TourProperties.TourType;


abstract public class Tour {

	private LocationType locationType;
	private TourType tourType;
	private LocalDate startDate;
	private LocalDate endDate;
	private AccomodationType accomodation;

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
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

	public TourType getTourType() {
		return tourType;
	}

	public void setTourType(TourType tourType) {
		this.tourType = tourType;
	}

	public void setAccomodation(AccomodationType accomodation) {
		this.accomodation = accomodation;
	}

	public AccomodationType getAccomodation() {
		return accomodation;
	}
	
	public abstract double calculateTourPrice();
	
	public void Available() throws DateAvailabilityException {
		LocalDate currentDate = LocalDate.now();
		if (startDate.isBefore(currentDate)) {
			throw new DateAvailabilityException("There is no available tour per your requsted date");
		}
		else
			if (startDate.isAfter(endDate)){
				throw new DateAvailabilityException("Please check your dates, requested time period is not proper");
			}

	}


}
