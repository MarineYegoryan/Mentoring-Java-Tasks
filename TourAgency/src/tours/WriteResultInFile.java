package tours;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteResultInFile {

	private static final String FILENAME = "../TourAgency/src/tours/FileReader/FileSources/Result.txt";
	BufferedWriter bw = null;
	FileWriter fw = null;
	ResultPrinting resultPrinting = new ResultPrinting();
	public String text;
	
	public void printOutResults(double price) {
		try {
			if (price > 0){
				text =  "We have found available tour per your needs and the price of your requested tour is $" + price;
			}
			else{
				text = "There is no available tour per your request";
			}	
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(text);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
