package tours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tours.TourProperties.AccomodationType;
import tours.excursion.Excursion;
import tours.excursion.ExcursionType;

public class RestTour extends Tour {

	private Map<ExcursionType, ArrayList<Excursion>> excursionMap = new HashMap<ExcursionType, ArrayList<Excursion>>();

	public void addExcursion(Excursion excursion) {
		ExcursionType excursionType = excursion.getExcursionType();
		ArrayList<Excursion> excursionList;

		if (excursionMap.containsKey(excursionType)) {
			excursionList = excursionMap.get(excursionType);
		} else {
			excursionList = new ArrayList<Excursion>();
		}
		excursionList.add(excursion);
		excursionMap.put(excursionType, excursionList);
	}

	public void addExcursions(ArrayList<Excursion> excursionList) {
		int listSize = excursionList.size();

		for (int i = 0; i < listSize; i++) {
			Excursion excursion = excursionList.get(i);
			addExcursion(excursion);
		}
	}

	@Override
	public double calculateTourPrice() {
		double price = 0;
		Excursion excursion = new Excursion();
		AccomodationType accomodation = getAccomodation();

		for (ExcursionType mapKey : excursionMap.keySet()) {
			int excursionTypeSize = excursionMap.get(mapKey).size();

			if (accomodation == AccomodationType.Hotel) {
				price += (excursionTypeSize * excursion.calculateExcursionsPrice() + 1000);
			} else if (accomodation == AccomodationType.Appartament) {
				price += (excursionTypeSize * excursion.calculateExcursionsPrice() + 500);
			}
		}
		return price;
	}
}
