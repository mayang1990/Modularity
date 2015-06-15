package Modularity;

import Modularity.unsigned;
import Modularity.signed;

public class Modularity {
	public static void main(String[] args) {

		// 输入顶点和边的数组

		int[] vexs = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
				17, 18, 19, 20, 21, 22, 23, 324, 25, 26, 27, 28, 29, 30, 31,
				32, 33, 34 };

		int[][] list = { { 1, 5, 17, 7, 11, 12, 6 },
				{ 2, 3, 4, 8, 13, 14, 18, 20, 22 }, { 9, 33, 31, 16 },
				{ 10, 15, 19, 21, 23, 24, 29, 32, 34, 30, 27 }, { 26, 28, 25 } };

		int[][] list1 = {
				{ 1, 5, 17, 7, 11, 12, 6, 2, 3, 4, 8, 13, 14, 18, 20, 22 },
				{ 9, 33, 31, 16, 10, 15, 19, 21, 23, 24, 29, 32, 34, 30, 27,
						26, 28, 25 } };

		int[] vexs2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };

		int[][] list2 = { { 2, 3, 4, 1 }, { 5, 7, 6 }, { 9, 10, 11, 8 },
				{ 13, 14, 12, 16, 15 } };
		int[][] list3 = { { 2, 3, 4, 1 }, { 5, 7, 6, 8, 9, 10, 11 },
				{ 13, 14, 12, 16, 15 } };

		readFile read = new readFile();
		int[][] edges1 = read.readLine("E:\\kong.txt");
		int[][] edges2 = read.readLine("E:\\Gahu.txt");

		unsigned pG1 = new unsigned(vexs, edges1);
		signed pG2 = new signed(vexs2, edges2);

		pG1.print(); // 打印图
		pG2.print();

		pG1.cal_Q(list); // 输出模块度
		pG1.cal_Q(list1);
		pG2.cal_Q(list2);
		pG2.cal_Q(list3);
	}

}
