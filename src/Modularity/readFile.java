package Modularity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFile {

	public int[][] readLine(String path) {

		BufferedReader br = null;
		int[][] array = null;

		try {

			String line;
			int count = 0;
			int cows = 0;
			int cols = 0;

			br = new BufferedReader(new FileReader(path));

			line = br.readLine();
			String[] eline = line.split(" ");
			cows = Integer.parseInt(eline[0]);
			cols = Integer.parseInt(eline[1]);

			System.out.printf("%d", cows);
			System.out.printf("%d", cols);
			array = new int[cows][cols];

			while ((line = br.readLine()) != null) {
				eline = line.split(" ");

				array[count][0] = Integer.parseInt(eline[0]);
				array[count][1] = Integer.parseInt(eline[1]);
				array[count][2] = Integer.parseInt(eline[2]);
				count++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return array;
	}
}
