package Modularity;

import Modularity.unsigned;
import Modularity.signed;

public class Modularity {

	public static int[] vex;

	public static void main(String[] args) {

		// ���뻮�ֽ��

		/*
		 * int[][] list = { { 1, 5, 17, 7, 11, 12, 6 }, { 2, 3, 4, 8, 13, 14,
		 * 18, 20, 22 }, { 9, 33, 31, 16 }, { 10, 15, 19, 21, 23, 24, 29, 32,
		 * 34, 30, 27 }, { 26, 28, 25 } };
		 * 
		 * int[][] list1 = { { 1, 5, 17, 7, 11, 12, 6, 2, 3, 4, 8, 13, 14, 18,
		 * 20, 22 }, { 9, 33, 31, 16, 10, 15, 19, 21, 23, 24, 29, 32, 34, 30,
		 * 27, 26, 28, 25 } };
		 */

		/*
		 * int[][] list2 = { { 2, 3, 4, 1 }, { 5, 7, 6 }, { 9, 10, 11, 8 }, {
		 * 13, 14, 12, 16, 15 } }; int[][] list3 = { { 2, 3, 4, 1 }, { 5, 7, 6,
		 * 8, 9, 10, 11 }, { 13, 14, 12, 16, 15 } };
		 */

		int[][] list1 = {
				{ 1, 5, 17, 7, 11, 12, 6, 2, 3, 4, 8, 13, 14, 18, 20, 22 },
				{ 9, 33, 31, 16, 10, 15, 19, 21, 23, 24, 29, 32, 34, 30, 27,
						26, 28, 25 } };

		// �����ݼ�
		readFile read = new readFile();
		int[][] edges = read.readLine("kong.txt"); // �޷�������unsigned
		// int[][] edges = read.readLine("Gahu.txt"); // �з�������signed

		unsigned pG1 = new unsigned(vex, edges);
		// signed pG2 = new signed(vex, edges);

		// ��ӡͼ
		pG1.print();
		// pG2.print();

		// ���ģ���
		// pG1.cal_Q(list);
		pG1.cal_Q(list1);
		// pG2.cal_Q(list2);
		// pG2.cal_Q(list3);
	}
}
