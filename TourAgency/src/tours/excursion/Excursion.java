package tours.excursion;


import tours.Exceptions.DateAvailabilityException;
import tours.TourProperties.LocationType;

public class Excursion {

	private int peopleCount;
	private int duration;
	private Boolean available;
	private LocationType locationType;
	private ExcursionType excursionType;

	public LocationType getLocationType() {
		return locationType;
	}
	
	public  void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}
	
	public void setExcursionType(ExcursionType excursionType) {
		this.excursionType = excursionType;
	}

	public ExcursionType getExcursionType() {
		return excursionType;
	}
	
	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public void AvailableExcursion() {
		if (available == false) {
			throw new DateAvailabilityException("There is no available meeting per your requsted date");
		}	
	}
	
	public double calculateExcursionsPrice() {
		double price = 0;
		switch (locationType) {
		case Yerevan:
			switch (excursionType) {
			case MUSEUM:
				return price = duration * (peopleCount * 20);
			case CRUISE:
				return price = duration * (peopleCount * 30);
			case CINEMA:
				return price = duration * (peopleCount * 40);
			case TEATHRE:
				return price = duration * (peopleCount * 50);
			default:
				break;
			}
		case Moscow:
			switch (excursionType) {
			case MUSEUM:
				return price = duration * (peopleCount * 60);
			case CRUISE:
				return price = duration * (peopleCount * 70);
			case CINEMA:
				return price = duration * (peopleCount * 80);
			case TEATHRE:
				return price = duration * (peopleCount * 90);
			default:
				break;
			}
		default:
			break;
		}
		return price;
	}
}
