package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVtoARFF {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String csvFile = "/Users/wingrove/Desktop/data/50States_Month_utf8_v2.csv";

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String date = "";
		String[] states = new String[] {};

		br = new BufferedReader(new FileReader(csvFile));
		int counter = 0;

		while ((line = br.readLine()) != null) {
			String[] var = line.split(cvsSplitBy);
			if (counter == 0) {
				states = var;
				counter++;
				continue;
			}
			date = var[0].toString();
			for (int i = 0; i < var.length; i++) {
				if (!states[i].equals("time")) {
					System.out.println(date + "," + states[i] + "," + var[i]);
				}
			}

		}

	}

}
