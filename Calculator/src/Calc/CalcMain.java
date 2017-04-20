package Calc;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CalcMain {

	static String nextLine = null;

	public static void main(String[] args) throws InputMismatchException {

		Scanner input = new Scanner(System.in);

		try {
			while (nextLine != "End") {
				System.out.println("please input first number ");
				double fstNum = input.nextDouble();

				System.out.println("please input action symbol (+ or - or / or *) you want to perform ");
				char action = input.next().charAt(0);

				if ((action != '+') && (action != '-') && (action != '/') && (action != '*')) {
					System.err.println("Invalid input action");
					break;
				} else {

					System.out.println("please input second number ");
					double lstNum = input.nextDouble();

					Calculator math = new Calculator();

					double result = math.calculator(fstNum, lstNum, action);

					System.out.println("result = " + result);

					nextLine = input.nextLine();
					break;
				}
			}
		}
		catch (NoSuchElementException e) {
			System.err.println("Invalid input");
		}
		input.close();

		return;

	}

}
