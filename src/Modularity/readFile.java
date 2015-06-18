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

			// 去除首尾多余空格
			line = br.readLine();
			String[] eline = line.split(" ");

			// 处理第一行的数据
			// 处理第一行第一个数据，为定点数，生成顶点数组
			int vexnum = Integer.parseInt(eline[0]);
			Modularity.vex = new int[vexnum];
			for (int i = 0; i < vexnum; i++) {
				Modularity.vex[i] = i;
			}

			// 处理第一行剩下的两个数据
			cows = Integer.parseInt(eline[1]);
			cols = Integer.parseInt(eline[2]);
			array = new int[cows][cols];

			// 处理第一行之后的数据
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
