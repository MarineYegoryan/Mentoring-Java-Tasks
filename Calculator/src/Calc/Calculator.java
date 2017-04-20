package Calc;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Calculator {

	public double calc_result;

	public double calculator(double fstNum, double lstNum, char act) {

		if (act == '+') {
			calc_result = new BigDecimal(fstNum).add(new BigDecimal(lstNum)).doubleValue();
		} else if (act == '-') {
			calc_result = new BigDecimal(fstNum).subtract(new BigDecimal(lstNum)).doubleValue();
		} else if (act == '*') {
			calc_result = new BigDecimal(fstNum).multiply(new BigDecimal(lstNum)).doubleValue();
		} else if (act == '/') {
			calc_result = new BigDecimal(fstNum).divide(new BigDecimal(lstNum), 3, RoundingMode.UP).doubleValue();
		}

		return calc_result;
	}
}
