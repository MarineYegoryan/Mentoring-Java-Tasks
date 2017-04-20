package tours;

import java.time.LocalDate;
import tours.Exceptions.DateAvailabilityException;
import tours.TourProperties.AccomodationType;
import tours.TourProperties.LocationType;

public class ResultPrinting {
	public void writeResult(double price, LocalDate getTourStartDate, LocalDate getTourEndDate,
			LocationType locationType, AccomodationType accomodationType) {
		
		if (price > 0) {
			System.out.println("Check In " + getTourStartDate);
			System.out.println("Check Out " + getTourEndDate);
			System.out.println("City is " + locationType);
			System.out.println("Accomodation type is " + accomodationType);
			System.out.println(
					"We have found available tour per your needs and the price of your requested tour is $" + price);
		} else {
			throw new DateAvailabilityException("There is no available tour per your request");
		}
	}
}
